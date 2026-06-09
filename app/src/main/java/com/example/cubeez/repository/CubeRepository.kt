package com.example.cubeez.repository

import com.example.cubeez.api.CubeApi
import com.example.cubeez.database.CompletedCase
import com.example.cubeez.database.CubeDao
import com.example.cubeez.model.Step
import kotlinx.coroutines.flow.Flow

class CubeRepository(private val api: CubeApi, private val cubeDao: CubeDao) {
    suspend fun getSteps(): List<Step> {
        return api.getSteps().steps
    }

    suspend fun insert(completedCase: CompletedCase) {
        cubeDao.insertCase(completedCase)
    }

    suspend fun delete(completedCase: CompletedCase) {
        cubeDao.deleteCase(completedCase)
    }

    fun isCompleted(stepId: Int, caseId: Int) : Flow<Boolean> {
        return cubeDao.isCompleted(stepId, caseId)
    }

    fun casesFromStepId(stepId: Int): Flow<Int> {
        return cubeDao.casesFromStepId(stepId)
    }
}
