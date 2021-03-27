package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity.Companion.EXTRA_USER
import com.abdulmughni.personal.bts.donelistapp.core.utils.DataMapper
import com.abdulmughni.personal.bts.donelistapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: AuthenticationViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            viewModel.login(
                binding.email.text.toString(),
                binding.password.text.toString()
            ).observe(viewLifecycleOwner, { user ->
                if (user?.data != null) {
                    viewModel.user.postValue(user.data)
                    viewModel.addSession(
                        DataMapper.convertUserToSessionUser(user.data)
                    )
                    goToMainActivity(user.data)
                } else {
                    binding.textError.tvError.text =
                        user?.message ?: getString(R.string.something_wrong)
                }
            })
        }
    }

    private fun goToMainActivity(user: User?) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.putExtra(EXTRA_USER, user)
        startActivity(intent)
    }
}