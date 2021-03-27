package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abdulmughni.personal.bts.donelistapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}