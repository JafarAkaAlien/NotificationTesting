package com.leblebi.alone.base

import android.content.Context
import com.leblebi.alone.data.WebServiceAPI
import com.leblebi.alone.local.MyDatabase
import com.leblebi.alone.utils.RetrofitInstance

open class BaseRepository {
    fun httpExecute() = RetrofitInstance.INSTANCE.create(WebServiceAPI::class.java)
    fun getRoom(context:Context) = MyDatabase.getInstance(context)
}