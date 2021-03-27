package com.abdulmughni.personal.bts.donelistapp.core.di

import android.content.Context
import androidx.room.Room
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.TaskDao
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TaskDatabase = Room.databaseBuilder(
        context,
        TaskDatabase::class.java,
        "DoneList.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTaskDao(database: TaskDatabase): TaskDao = database.taskDao()
}