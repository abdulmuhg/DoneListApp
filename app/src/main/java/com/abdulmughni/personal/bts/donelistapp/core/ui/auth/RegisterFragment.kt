package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity.Companion.EXTRA_USER
import com.abdulmughni.personal.bts.donelistapp.core.utils.DataMapper
import com.abdulmughni.personal.bts.donelistapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private val viewModel: AuthenticationViewModel by viewModels()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonRegister.setOnClickListener {
            val user = User(
                name = binding.name.text.toString(),
                email = binding.email.text.toString(),
                password = binding.password.text.toString()
            )
            viewModel.register(user)
            viewModel.addSession(DataMapper.convertUserToSessionUser(user))
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.putExtra("name", EXTRA_USER)
            startActivity(intent)
            activity?.finish()
        }
    }
}