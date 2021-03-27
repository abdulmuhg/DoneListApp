package com.abdulmughni.personal.bts.donelistapp.core.domain.usecase

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface TaskUseCase {
    fun getAllTask(): Flow<Resource<List<Task>>>
    fun insertTask(task: Task)
    fun login(email: String, password: String): Flow<Resource<User?>>
    fun register(user: User)
    fun getSession(): Flow<Resource<Session?>>
    fun addSession(session: Session)
    fun removeSession(session: Session)
}