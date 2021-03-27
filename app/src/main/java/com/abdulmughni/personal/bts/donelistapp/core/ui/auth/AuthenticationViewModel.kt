package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.domain.usecase.TaskUseCase

class AuthenticationViewModel @ViewModelInject constructor(private val taskUseCase: TaskUseCase): ViewModel() {
    fun login(email: String, password: String) = taskUseCase.login(email, password).asLiveData()

    fun register(user: User) = taskUseCase.register(user)

    val user = MutableLiveData<User>()

    val session = taskUseCase.getSession().asLiveData()

    fun addSession(session: Session) = taskUseCase.addSession(session)

    fun logout(session: Session) = taskUseCase.removeSession(session)
}