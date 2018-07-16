package com.bschandramohan.learn.retrofit2sample.api

import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {

    @GET ("users")
    fun getUsers() : Call<UserList>

    @GET ("users/4") // NOTE the parameter 4 should come from the output of previous input
    fun getUser() : Call<UserData>
}
