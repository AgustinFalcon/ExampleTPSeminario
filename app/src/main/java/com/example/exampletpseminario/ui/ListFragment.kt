package com.example.exampletpseminario.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletpseminario.R
import com.example.exampletpseminario.databinding.FragmentListBinding
import com.example.exampletpseminario.model.UserExample
import com.example.exampletpseminario.viewmodel.UserViewModel


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)


        val adapter = ListAdapter()
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.listRecyclerView.adapter = adapter


        // Linea divisoria
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
        binding.listRecyclerView.addItemDecoration(divider)


        binding.btnAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addUserFragment)
        }

        userViewModel.readAllData.observe(viewLifecycleOwner) { users ->
            adapter.setData(users = users)
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}