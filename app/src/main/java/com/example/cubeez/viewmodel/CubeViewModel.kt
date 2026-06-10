package com.example.cubeez.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubeez.database.CompletedCase
import com.example.cubeez.model.Step
import com.example.cubeez.repository.CubeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CubeViewModel(
    private val ioDispatcher: CoroutineDispatcher,
    private val cubeRepository: CubeRepository
): ViewModel() {
    private val _steps = MutableStateFlow<List<Step>>(emptyList())
    val steps = _steps.asStateFlow()
    private val repository = cubeRepository

    init {
        viewModelScope.launch {
            try {
                _steps.value = repository.getSteps()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun isCompleted(stepId: Int, caseId: Int): Flow<Boolean> {
        return repository.isCompleted(stepId, caseId)
    }

    fun toggle(completedCase: CompletedCase) {
        viewModelScope.launch(ioDispatcher) {
            if (repository.isCompleted(completedCase.stepId, completedCase.caseId).first()) {
                repository.delete(completedCase)
            } else {
                repository.insert(completedCase)
            }
        }
    }

    fun isStepCompleted(stepId: Int): Flow<Boolean> {
        val step = _steps.value.find { it.stepId == stepId }
        val totalCasesInStep = step?.cases?.size ?: 0
        return repository.casesFromStepId(stepId).map { completedCases ->
            completedCases == totalCasesInStep
        }
    }

    fun getProgress(): Flow<Float> {
        return repository.completedCases().combine(steps) { completed, steps ->
            val totalCases = steps.sumOf { it.cases.size }
            if (totalCases > 0) completed.toFloat() / totalCases else 0f
        }
    }
}