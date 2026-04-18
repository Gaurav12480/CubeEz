package com.example.cubeez.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubeez.api.api
import com.example.cubeez.model.Step
import com.example.cubeez.repository.CubeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StepViewModel: ViewModel() {
    private val _steps = MutableStateFlow<List<Step>>(emptyList())
    val steps = _steps.asStateFlow()

    private val repository = CubeRepository(api)

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
    fun getStep(stepId: Int): Step? {
        return _steps.value.find {it.stepId == stepId}
    }
}