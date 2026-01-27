package com.example.cubeez.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cubeez.api.api
import com.example.cubeez.model.Step
import com.example.cubeez.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {
    private val _steps = MutableStateFlow<List<Step>>(emptyList())
    var steps = _steps.asStateFlow()

    private val repository = HomeRepository(api)

    init {
        viewModelScope.launch{
            try {
                _steps.value = repository.getHomeSteps()
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}