package com.abdulmughni.personal.bts.donelistapp.core.domain.usecase

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.data.TaskRepository
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskInteractor @Inject constructor(private val taskRepository: TaskRepository): TaskUseCase{
    override fun getAllTask(): Flow<Resource<List<Task>>> = taskRepository.getAllTask()

    override fun insertTask(task: Task) = taskRepository.inputTaskItem(task)

    override fun login(email: String, password: String): Flow<Resource<User?>> =
        taskRepository.login(email, password)

    override fun register(user: User) = taskRepository.register(user)

    override fun getSession(): Flow<Resource<Session?>> = taskRepository.getSession()

    override fun addSession(session: Session) = taskRepository.addSession(session)

    override fun removeSession(session: Session) = taskRepository.removeSession(session)
}