package com.home.retrofitrxjavademotwo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.database.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber
import io.reactivex.Flowable


class MainDataModel {

    val liveData: MutableLiveData<List<Geoname>> = MutableLiveData()

    fun getData() {

        val service = RetrofitClient.getCityService()
        val observable = service.queryGeonames(44.1, -9.9, -22.4, 55.2, "de")

        val composite = CompositeDisposable()
        composite.add(observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ cityResponse ->
                liveData.value = cityResponse?.geonames
            }, { error ->
                error.printStackTrace()
            }))
    }
}

