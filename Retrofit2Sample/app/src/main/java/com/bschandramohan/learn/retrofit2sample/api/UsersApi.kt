package com.bschandramohan.learn.retrofit2sample.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {

    @GET ("users")
    fun getUsers() : Call<UserList>

    @GET ("users/{userId}") // NOTE the parameter 4 should come from the output of previous input
    fun getUser(@Path(value = "userId", encoded = true) userId: String) : Call<UserData>
}
