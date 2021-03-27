package com.abdulmughni.personal.bts.donelistapp.core.di

import com.abdulmughni.personal.bts.donelistapp.core.data.TaskRepository
import com.abdulmughni.personal.bts.donelistapp.core.domain.repository.ITaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(taskRepository: TaskRepository): ITaskRepository
}