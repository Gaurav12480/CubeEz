package com.example.cubeez.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface CubeDao {

    @Insert
    suspend fun insertCase(completedCase: CompletedCase)

    @Delete
    suspend fun deleteCase(completedCase: CompletedCase)

    @Query(
        """
        SELECT EXISTS(
            SELECT 1 FROM CompletedCase 
            WHERE stepId = :stepId
            AND caseId = :caseId
        )
        """
    )
    fun isCompleted(
        stepId: Int,
        caseId: Int
    ): Flow<Boolean>

    @Query("""SELECT COUNT(*) FROM CompletedCase WHERE stepId = :stepId""")
    fun casesFromStepId(stepId: Int): Flow<Int>

    @Query("""SELECT COUNT(*) FROM CompletedCase""")
    fun completedCases(): Flow<Int>
}
