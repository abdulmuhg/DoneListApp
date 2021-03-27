package com.abdulmughni.personal.bts.donelistapp.core.di

import android.content.Context
import androidx.room.Room
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.TaskDao
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.DoneListDatabase
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room.UserDao
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
    fun provideDatabase(@ApplicationContext context: Context): DoneListDatabase = Room.databaseBuilder(
        context,
        DoneListDatabase::class.java,
        "DoneList.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTaskDao(database: DoneListDatabase): TaskDao = database.taskDao()

    @Provides
    fun provideUserDao(database: DoneListDatabase): UserDao = database.userDao()
}