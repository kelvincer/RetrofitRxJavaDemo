package com.home.retrofitrxjavademotwo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var model: MainDataModel = MainDataModel()
    val liveData: MutableLiveData<List<Geoname>> = MutableLiveData()

    init {
        model.liveData.observeForever {
            liveData.value = it
        }
    }

    fun getData() {
        model.getData()
    }
}