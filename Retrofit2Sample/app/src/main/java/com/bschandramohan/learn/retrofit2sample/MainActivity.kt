package com.bschandramohan.learn.retrofit2sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bschandramohan.learn.retrofit2sample.api.UserData
import com.bschandramohan.learn.retrofit2sample.api.UserList
import com.bschandramohan.learn.retrofit2sample.api.UsersApi
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val baseUrl = "https://reqres.in/api/"

    private var gson = GsonBuilder()
            .setLenient()
            .create()

    private var retrofitInstance = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers()

        getUser()
    }

    private fun getUsers() {
        val usersApi = retrofitInstance.create(UsersApi::class.java)

        var call = usersApi.getUsers()
        call.enqueue(object: Callback<UserList> {
            override fun onFailure(call: Call<UserList>?, t: Throwable?) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<UserList>?, response: Response<UserList>?) {
                if (response!!.isSuccessful) {
                    val users = response.body()
                    System.out.println("List of USERS=${users}")
                } else {
                    System.out.println(response.errorBody())
                }
            }
        })
    }

    private fun getUser() {
        var usersApi = retrofitInstance.create(UsersApi::class.java)

        var nextCall = usersApi.getUser()
        nextCall.enqueue(object: Callback<UserData> {
            override fun onResponse(call: Call<UserData>?, response: Response<UserData>?) {
                if (response!!.isSuccessful) {
                    val user = response.body()
                    System.out.println("USER'S ${user!!.data.id} info = ${user.data}")
                } else {
                    System.out.println(response.errorBody())
                }
            }

            override fun onFailure(call: Call<UserData>?, t: Throwable?) {
                t!!.printStackTrace()
            }
        })
    }
}
