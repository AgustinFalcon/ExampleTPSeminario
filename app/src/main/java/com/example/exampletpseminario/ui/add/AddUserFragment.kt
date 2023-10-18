package com.example.exampletpseminario.ui.add

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.exampletpseminario.R
import com.example.exampletpseminario.databinding.FragmentAddUserBinding
import com.example.exampletpseminario.model.User
import com.example.exampletpseminario.viewmodel.UserViewModel


class AddUserFragment : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(inflater, container, false)


        binding.btnAdd.setOnClickListener {
            insertDatatoDataBase()
        }


        return binding.root
    }

    private fun inputCheck(firstName: String, lastNasme: String, age: String): Boolean {
        return if (firstName.isNotEmpty() && lastNasme.isNotEmpty() && age.isNotEmpty()) {
            true
        } else {
            false
        }
    }

    private fun insertDatatoDataBase() {
        val firstName = binding.etName.text.toString()
        val lastNasme = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()

        if (inputCheck(firstName, lastNasme, age)) {

            // Crea el objeto del usuario
            val user = User(id = 0, firstName = firstName, lastName = lastNasme, age = age.toInt())

            // se lo pasa al viewmodel para agregalo a la db
            userViewModel.insertUser(user = user)

            Toast.makeText(requireContext(), "Agregado!", Toast.LENGTH_SHORT).show()

            // navegamos al listado
            findNavController().navigate(R.id.action_addUserFragment_to_listFragment)
            Log.d("AddUserFrag", "usuario creado! $user")

        } else {
            Toast.makeText(requireContext(), "Complete todos los datos!", Toast.LENGTH_SHORT).show()
        }
    }


}