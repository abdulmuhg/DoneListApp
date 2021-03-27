package com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.SessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM session")
    fun getSession(): Flow<SessionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSession(sessionEntity: SessionEntity)

    @Update
    fun updateSession(sessionEntity: SessionEntity)

    @Delete
    fun deleteSession(sessionEntity: SessionEntity)
}