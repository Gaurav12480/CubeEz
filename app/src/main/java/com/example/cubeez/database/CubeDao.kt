package com.example.cubeez.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface CubeDao {
    @Dao
    interface ProgressDao {

        @Insert
        suspend fun insertCase(completedCase: CompletedCase)

        @Delete
        suspend fun deleteCase(completedCase: CompletedCase)

        @Query("""
        SELECT EXISTS(
            SELECT * FROM CaseProgress
            WHERE stepId = :stepId
            AND caseId = :caseId
        )
        """)
        suspend fun isCompleted(
            stepId: Int,
            caseId: Int
        ): Boolean
    }
}
