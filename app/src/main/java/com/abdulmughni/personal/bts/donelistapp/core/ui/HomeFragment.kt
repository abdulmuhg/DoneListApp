package com.abdulmughni.personal.bts.donelistapp.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdulmughni.personal.bts.donelistapp.R
import com.abdulmughni.personal.bts.donelistapp.core.data.Resource
import com.abdulmughni.personal.bts.donelistapp.core.domain.model.Task
import com.abdulmughni.personal.bts.donelistapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskAdapter = TaskListAdapter()
        taskAdapter.onItemClick = { selectedData ->

        }
        viewModel.doneList.observe(viewLifecycleOwner, { task ->
            if (task != null){
                when(task){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.textError.root.visibility = View.VISIBLE
                        binding.textError.tvError.text = task.message ?: getString(R.string.something_wrong)
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        taskAdapter.setData(task.data)
                    }
                }
            }
        })

        with(binding.rvTask){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = taskAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}