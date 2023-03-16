package com.leblebi.alone.data

import com.leblebi.alone.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServiceAPI {
    @GET("api/users")
    fun getAllUsers(@Query("page") page:Int , @Query("per_page") perPage:Int):Response<UserResponse>

    @GET("api/{resources}")
    fun getResources(@Query("resources") resources: String, @Query("page")page: Int, @Query("per_page") perPage: Int)
}