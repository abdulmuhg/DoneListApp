package com.abdulmughni.personal.bts.donelistapp.di

import com.abdulmughni.personal.bts.donelistapp.core.domain.usecase.TaskInteractor
import com.abdulmughni.personal.bts.donelistapp.core.domain.usecase.TaskUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideTaskUseCase(taskInteractor: TaskInteractor): TaskUseCase
}