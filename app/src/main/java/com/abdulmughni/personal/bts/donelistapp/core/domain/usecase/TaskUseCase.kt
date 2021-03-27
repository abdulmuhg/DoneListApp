package com.abdulmughni.personal.bts.donelistapp.core.domain.usecase

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskUseCase {
    fun getAllTask(): Flow<Resource<List<Task>>>
    fun insertTask(task: Task)
}