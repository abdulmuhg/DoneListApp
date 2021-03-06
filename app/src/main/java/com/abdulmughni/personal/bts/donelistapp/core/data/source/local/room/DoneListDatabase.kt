package com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.SessionEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.UserEntity

@Database(entities = [TaskEntity::class, UserEntity::class, SessionEntity::class], version = 3, exportSchema = false)
abstract class DoneListDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun userDao(): UserDao
    abstract fun sessionDao(): SessionDao
}