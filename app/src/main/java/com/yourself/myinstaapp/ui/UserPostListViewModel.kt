package com.yourself.myinstaapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourself.myinstaapp.model.DefaultState
import com.yourself.myinstaapp.model.ErrorState
import com.yourself.myinstaapp.model.UserPostListState
import com.yourself.myinstaapp.repository.UserPostListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class UserPostListViewModel : ViewModel() {
    val TAG: String = UserPostListViewModel::class.java.name
    @Inject
    lateinit var repository: UserPostListRepository
    var stateLiveData = MutableLiveData<UserPostListState>()

    init {
        stateLiveData.value = DefaultState(emptyList(), true)
    }

    fun getUserPostList(imageType: String,perPage: Int,safeSearch:Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getUserPostList(imageType, perPage,safeSearch)
                withContext(Dispatchers.Main) {
                    stateLiveData.value = DefaultState(result.userPostList, true)
                }
            }catch (exception: Exception){
                Log.d(TAG, "Error from API ${exception.localizedMessage}")
                withContext(Dispatchers.Main) {
                    stateLiveData.value = ErrorState(exception.localizedMessage,emptyList(), true)
                }
            }
        }
    }
}
