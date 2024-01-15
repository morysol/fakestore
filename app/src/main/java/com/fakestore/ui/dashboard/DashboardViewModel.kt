package com.fakestore.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {


    val dashboardString = MutableLiveData<String>()

    init {
        viewModelScope.launch {

            dashboardString.postValue(getDashboard())
            // дернуть юзкейс
        }
    }

    private fun getDashboard(): String {
        return "This is dashboard Fragment"
    }

}