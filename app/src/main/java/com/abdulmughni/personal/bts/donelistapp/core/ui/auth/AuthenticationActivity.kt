package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity
import com.abdulmughni.personal.bts.donelistapp.core.utils.DataMapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : AppCompatActivity() {

    private val viewModel: AuthenticationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        setSupportActionBar(findViewById(R.id.toolbar))

        viewModel.session.observe(this, {session ->
            if (session.data != null){
                viewModel.user.value = DataMapper.convertSessionToUser(session.data)
                goToMainActivity(DataMapper.convertSessionToUser(session.data))
            }
        })
    }
    private fun goToMainActivity(user: User?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_USER, user)
        startActivity(intent)
    }
}