package com.leblebi.alone.repository

import android.content.Context
import com.leblebi.alone.base.BaseRepository
import com.leblebi.alone.model.User
import com.leblebi.alone.model.UserResponse
import retrofit2.Response

class UserRepository(val context: Context):BaseRepository() {
        private val userDao by lazy { getRoom(context).userDao() }

        suspend fun getAllUserFromRemote(page:Int, perPage:Int): Response<UserResponse>{
                return httpExecute().getAllUsers(page,perPage)
        }
        suspend fun saveAllUsers(users:List<User>){
                userDao.saveAllUsers(users)
        }

        fun getAllLocalUsers() = userDao.getAllUsers()
}