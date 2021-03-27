package com.abdulmughni.personal.bts.donelistapp.core.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.User
import com.abdulmughni.personal.bts.donelistapp.core.ui.main.MainActivity
import com.abdulmughni.personal.bts.donelistapp.core.utils.DataMapper
import com.abdulmughni.personal.bts.donelistapp.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAuth : Fragment() {

    private val viewModel: AuthenticationViewModel by viewModels()
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.session.observe(viewLifecycleOwner, {session ->
            if (session.data != null){
                viewModel.user.value = DataMapper.convertSessionToUser(session.data)
                goToMainActivity(DataMapper.convertSessionToUser(session.data))
            } else {
                binding.root.visibility = View.VISIBLE
            }
        })
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_to_login)
        }
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_to_register)
        }
    }

    private fun goToMainActivity(user: User?) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra(MainActivity.EXTRA_USER, user)
        startActivity(intent)
        activity?.finish()
    }
}