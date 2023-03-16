package com.leblebi.alone.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.leblebi.alone.model.User

@Database (entities = [User::class], version = 2)
abstract class MyDatabase:RoomDatabase() {

    abstract fun userDao():UserDao

    companion object{
        private var INSTANCE : MyDatabase? = null
        fun getInstance(context: Context) : MyDatabase{
            if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "my_database").build()
            }
            return INSTANCE!!
        }
    }
}