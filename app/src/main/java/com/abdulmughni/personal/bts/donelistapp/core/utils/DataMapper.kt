package com.abdulmughni.personal.bts.donelistapp.core.utils

import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task

object DataMapper {
    fun mapEntitiesToDomain(taskEntity: List<TaskEntity>): List<Task> =
        taskEntity.map {
            Task(
                id = it.id,
                title = it.title,
                description = it.description,
                isDone = it.isDone
            )
        }

    fun mapDomainToEntities(task: List<Task>): List<TaskEntity> =
        task.map {
            TaskEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                isDone = it.isDone
            )
        }

    fun mapDomainToEntities(it: Task): TaskEntity =
        TaskEntity(
            title = it.title,
            description = it.description,
            isDone = it.isDone
        )

}