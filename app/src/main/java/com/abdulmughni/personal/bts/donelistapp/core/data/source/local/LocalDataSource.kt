package com.abdulmughni.personal.bts.donelistapp.core.data.source.local

import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.SessionEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.UserEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.SessionDao
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.TaskDao
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val taskDao: TaskDao, private val userDao: UserDao, private val sessionDao: SessionDao) {
    fun getAllTask(): Flow<List<TaskEntity>> = taskDao.getAllTask()
    fun insertTaskItem(taskEntity: TaskEntity) = taskDao.insertTask(taskEntity)
    fun updateTask(taskEntity: TaskEntity) = taskDao.updateTask(taskEntity)
    fun deleteTask(taskEntity: TaskEntity) = taskDao.deleteTask(taskEntity)

    fun createUser(userEntity: UserEntity) = userDao.register(userEntity)
    fun loginUser(email: String, password: String) = userDao.login(email, password)
    fun updateUser(userEntity: UserEntity) = userDao.updateUser(userEntity)

    fun getSession(): Flow<SessionEntity> = sessionDao.getSession()
    fun addSession(sessionEntity: SessionEntity) = sessionDao.insertSession(sessionEntity)
    fun removeSession(sessionEntity: SessionEntity) = sessionDao.deleteSession(sessionEntity)
}