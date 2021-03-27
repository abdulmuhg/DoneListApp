package com.abdulmughni.personal.bts.donelistapp.core.utils

import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.SessionEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.UserEntity
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User

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

    fun mapEntitiesToDomain(userEntity: UserEntity?): User? {
        return if (userEntity != null)
        User(
            id = userEntity.id,
            name = userEntity.name,
            password = userEntity.password,
            email = userEntity.email
        )
        else null
    }

    fun mapEntitiesToDomain(entity: SessionEntity?): Session? {
        return if (entity != null)
            Session(
                id = entity.id,
                name = entity.name,
                password = entity.password,
                email = entity.email
            )
        else null
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

    fun mapDomainToEntities(domain: Session): SessionEntity =
        SessionEntity(
            id = domain.id,
            name = domain.name,
            password = domain.password,
            email = domain.email
        )

    fun mapDomainToEntities(it: User): UserEntity =
        UserEntity(
            id = it.id,
            name = it.name,
            password = it.password,
            email = it.email
        )

    fun convertUserToSessionUser(it: User): Session =
        Session(
            id = it.id,
            name = it.name,
            password = it.password,
            email = it.email
        )

    fun convertSessionToUser(it: Session): User =
        User(
            id = it.id,
            name = it.name,
            password = it.password,
            email = it.email
        )

}