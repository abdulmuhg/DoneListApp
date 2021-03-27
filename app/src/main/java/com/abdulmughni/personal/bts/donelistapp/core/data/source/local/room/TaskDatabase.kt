package com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 2, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}