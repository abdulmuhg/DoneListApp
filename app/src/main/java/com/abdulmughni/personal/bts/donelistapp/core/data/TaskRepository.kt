package com.abdulmughni.personal.bts.donelistapp.core.data

import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.SessionEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.TaskEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.UserEntity
import com.abdulmughni.personal.bts.donelistapp.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.bts.donelistapp.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.domain.repository.ITaskRepository
import com.abdulmughni.personal.bts.donelistapp.core.utils.AppExecutors
import com.abdulmughni.personal.bts.donelistapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : ITaskRepository {
    override fun getAllTask(): Flow<Resource<List<Task>>> =
        object : NetworkBoundResource<List<Task>, List<TaskEntity>>() {
            override fun loadFromDB(): Flow<List<Task>> {
                return localDataSource.getAllTask().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Task>?): Boolean = false

            override suspend fun createCall(): Flow<ApiResponse<List<TaskEntity>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<TaskEntity>) {
                TODO("Not yet implemented")
            }

        }.asFlow()

    override fun inputTaskItem(task: Task) {
        val taskEntity = DataMapper.mapDomainToEntities(task)
        appExecutors.diskIO().execute { localDataSource.insertTaskItem(taskEntity) }
    }

    override fun login(username: String, password: String): Flow<Resource<User?>> =
        object : NetworkBoundResource<User?, UserEntity>() {
            override fun loadFromDB(): Flow<User?> {
                return localDataSource.loginUser(username, password)
                    .map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: User?): Boolean = false

            override suspend fun createCall(): Flow<ApiResponse<UserEntity>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: UserEntity) {
                TODO("Not yet implemented")
            }

        }.asFlow()

    override fun register(user: User) {
        val userEntity = DataMapper.mapDomainToEntities(user)
        appExecutors.diskIO().execute { localDataSource.createUser(userEntity) }
    }

    override fun updateUser(user: User) {
        val userEntity = DataMapper.mapDomainToEntities(user)
        appExecutors.diskIO().execute {localDataSource.updateUser(userEntity)}
    }

    override fun getSession(): Flow<Resource<Session?>> =
        object : NetworkBoundResource<Session?, SessionEntity>() {
            override fun loadFromDB(): Flow<Session?> {
                return localDataSource.getSession().map {  sessionEntity ->
                    DataMapper.mapEntitiesToDomain(sessionEntity)
                }
            }

            override fun shouldFetch(data: Session?): Boolean = false

            override suspend fun createCall(): Flow<ApiResponse<SessionEntity>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: SessionEntity) {
                TODO("Not yet implemented")
            }

        }.asFlow()

    override fun addSession(session: Session) {
        val sessionEntity = DataMapper.mapDomainToEntities(session)
        appExecutors.diskIO().execute{ localDataSource.addSession(sessionEntity) }
    }

    override fun removeSession(session: Session) {
        val entity = DataMapper.mapDomainToEntities(session)
        appExecutors.diskIO().execute {localDataSource.removeSession(entity)}
    }
}