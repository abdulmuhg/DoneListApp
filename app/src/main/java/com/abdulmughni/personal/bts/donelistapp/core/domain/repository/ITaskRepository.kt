package com.abdulmughni.personal.bts.donelistapp.core.domain.repository

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTask(): Flow<Resource<List<Task>>>
    fun inputTaskItem(task: Task)

    fun login(username: String, password: String): Flow<Resource<User?>>
    fun register(user: User)
    fun updateUser(user: User)

    fun getSession(): Flow<Resource<Session?>>
    fun addSession(session: Session)
    fun removeSession(session: Session)
}