package com.abdulmughni.personal.bts.donelistapp.core.domain.usecase

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.data.TaskRepository
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskInteractor @Inject constructor(private val taskRepository: TaskRepository): TaskUseCase{
    override fun getAllTask(): Flow<Resource<List<Task>>> = taskRepository.getAllTask()

    override fun insertTask(task: Task) {
        TODO("Not yet implemented")
    }
}