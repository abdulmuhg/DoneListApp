package com.abdulmughni.personal.bts.donelistapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Int = 0,
    var title: String,
    var description: String = "",
    var isDone: Boolean = false
): Parcelable
