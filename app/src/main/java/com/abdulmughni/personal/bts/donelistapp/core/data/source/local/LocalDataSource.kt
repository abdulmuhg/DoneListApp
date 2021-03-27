package com.abdulmughni.personal.bts.donelistapp.core.data.source.local

import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.TaskDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val taskDao: TaskDao) {
    fun getAllTask(): Flow<List<TaskEntity>> = taskDao.getAllTask()
    fun insertTaskItem(taskEntity: TaskEntity) = taskDao.insertTask(taskEntity)
    fun updateTask(taskEntity: TaskEntity) = taskDao.updateTask(taskEntity)
    fun deleteTask(taskEntity: TaskEntity) = taskDao.deleteTask(taskEntity)
}