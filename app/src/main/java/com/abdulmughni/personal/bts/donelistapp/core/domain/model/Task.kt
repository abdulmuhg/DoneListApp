package com.abdulmughni.personal.bts.donelistapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var isDone: Boolean = false
): Parcelable
