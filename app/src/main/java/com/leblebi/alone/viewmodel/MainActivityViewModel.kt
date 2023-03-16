package com.leblebi.alone.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leblebi.alone.model.User
import com.leblebi.alone.model.UserResponse
import com.leblebi.alone.repository.UserRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application):AndroidViewModel(application) {

    val _remoteData = MutableLiveData<List<User>>()
    val remoteData: LiveData<List<User>> = _remoteData

    val userRepository by lazy { UserRepository(application.applicationContext) }

    fun getAllUser()= userRepository.getAllLocalUsers()

    fun saveUser(user:User){
        viewModelScope.launch {

        }
    }

    fun getAllRemoteUser(page:Int , perPage:Int){
        viewModelScope.launch {
            val response = userRepository.getAllUserFromRemote(page, perPage)
        if(response.isSuccessful && response.code()==200){
            response.body()?.let {
                _remoteData.postValue(it.data)
            }
        }
        }
    }

}