package com.example.exampletpseminario.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.exampletpseminario.model.User
import com.example.exampletpseminario.repository.UserRepository


class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    val readAllData: LiveData<List<User>> = userRepository.readAllData


    fun insertUser(user: User) {
        userRepository.insertUser(user = user)
    }

}