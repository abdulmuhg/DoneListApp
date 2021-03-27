package com.abdulmughni.personal.bts.donelistapp.core.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.domain.usecase.TaskUseCase

class TaskViewModel @ViewModelInject constructor(private val taskUseCase: TaskUseCase): ViewModel() {
    val doneList = taskUseCase.getAllTask().asLiveData()
    fun insertTask(task: Task) = taskUseCase.insertTask(task)
}