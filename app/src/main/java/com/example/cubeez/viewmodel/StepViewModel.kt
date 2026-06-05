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
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class StepViewModel(
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
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun isCompleted(stepId: Int, caseId: Int): Flow<Boolean> {
        return repository.isCompleted(stepId, caseId)
    }

    fun toggle(completedCase: CompletedCase) {
        viewModelScope.launch (ioDispatcher) {
            if (repository.isCompleted(completedCase.stepId, completedCase.caseId).first()) {
                repository.delete(completedCase)
            } else {
                repository.insert(completedCase)
            }
        }
    }
}