package com.leblebi.alone.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leblebi.alone.model.User

@Dao
interface UserDao {

    @Query("select * from users")
    fun getAllUsers():LiveData<List<User>>

    @Insert
    fun insertUser(user:User)

    @Insert
    fun saveAllUsers(users:List<User>)
}