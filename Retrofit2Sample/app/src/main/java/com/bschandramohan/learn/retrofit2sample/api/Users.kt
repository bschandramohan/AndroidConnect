package com.bschandramohan.learn.retrofit2sample.api

data class UserList(
        var page: Int,
        var per_page: Int,
        var total: Int,
        var total_pages: Int,
        var data: List<User>
)

data class UserData(
        var data: User
)

data class User(
    var id: Int,
    var first_name: String,
    var last_name: String,
    var avatar: String
)

