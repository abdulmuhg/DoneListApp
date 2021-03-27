package com.abdulmughni.personal.bts.donelistapp.core.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.Navigation.findNavController

import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Session
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.ui.auth.AuthenticationActivity
import com.abdulmughni.personal.bts.donelistapp.core.ui.auth.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "user"
    }
    private val viewModel: AuthenticationViewModel by viewModels()
    private var mSession: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val user = intent.getParcelableExtra<User>(EXTRA_USER)
        viewModel.user.value = user

        viewModel.session.observe(this, {session ->
            if (session.data != null){
                mSession = session.data
            }
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun performLogout() {
        mSession?.let {
            viewModel.logout(it)
            goToAuthActivity()
        }
    }

    private fun goToAuthActivity(){
        startActivity(Intent(this, AuthenticationActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_logout -> {
                performLogout()
            }
        }
        return true
    }
}