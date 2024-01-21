package com.fakestore.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val homeString = MutableLiveData<String>()

    init {
        viewModelScope.launch {

            homeString.postValue(getNotifications())

            // дернуть юзкейс
        }
    }

    private fun getNotifications(): String {
        return "This is notifications Fragment"
    }


}