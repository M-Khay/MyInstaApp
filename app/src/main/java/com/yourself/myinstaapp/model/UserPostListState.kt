package com.yourself.myinstaapp.model


sealed class UserPostListState {
    abstract val data: List<UserPost>
    abstract val loadedAllItems: Boolean
}


data class DefaultState(override val data: List<UserPost>, override val loadedAllItems: Boolean) :
    UserPostListState()

data class LoadingState(override val data: List<UserPost>, override val loadedAllItems: Boolean) :
    UserPostListState()

data class ErrorState(val errorMessage: String, override val data: List<UserPost>, override val loadedAllItems: Boolean) :
    UserPostListState()

