package com.fakestore.ui.notifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotificationsViewModel : ViewModel() {

    val notificationsString = MutableLiveData<String>()

    init {
        viewModelScope.launch {

            notificationsString.postValue(getNotifications())

            // дернуть юзкейс
        }
    }

    private fun getNotifications(): String {
        return "This is notifications Fragment"
    }


}