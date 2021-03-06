package com.abdulmughni.personal.bts.donelistapp.core.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.core.ui.auth.AuthenticationViewModel
import com.abdulmughni.personal.bts.donelistapp.databinding.FragmentNewTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private val authViewModel: AuthenticationViewModel by viewModels()
    private var _binding: FragmentNewTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.session.observe(viewLifecycleOwner, {session ->
            if (session.data != null){
                binding.textName.text = session.data.name
            }
        })

        binding.btnAdd.setOnClickListener {
            val taskTitle = binding.inputText.text.toString()
            if (taskTitle.isNotBlank()){
                viewModel.insertTask(Task(
                        title = taskTitle
                ))
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }
}