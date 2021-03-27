package com.abdulmughni.personal.bts.donelistapp.core.domain.repository

import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTask(): Flow<Resource<List<Task>>>
    fun inputTaskItem(task: Task)
}