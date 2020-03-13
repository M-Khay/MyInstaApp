package com.yourself.myinstaapp.model

import com.google.gson.annotations.SerializedName

data class UserPostResponse (@SerializedName("hits")var userPostList : MutableList<UserPost>)