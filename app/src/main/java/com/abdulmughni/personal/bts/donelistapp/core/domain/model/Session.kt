package com.abdulmughni.personal.bts.donelistapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Session(
    val id: Int,
    var name: String,
    var email: String,
    var password: String
): Parcelable