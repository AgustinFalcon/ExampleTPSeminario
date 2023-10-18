package com.example.exampletpseminario.repository

import androidx.lifecycle.LiveData
import com.example.exampletpseminario.data.UserDB
import com.example.exampletpseminario.model.User


class UserRepository {

    private val userDao = UserDB.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()


    fun insertUser(user: User) {
        userDao.insertUser(user = user)
    }


}