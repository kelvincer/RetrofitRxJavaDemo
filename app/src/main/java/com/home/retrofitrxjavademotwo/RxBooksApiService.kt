package com.home.retrofitrxjavademotwo

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RxBooksApiService {

    @GET("citiesJSON")
    fun queryGeonames(
        @Query("north") north: Double,
        @Query("south") south: Double,
        @Query("east") east: Double,
        @Query("west") west: Double,
        @Query("lang") lang: String
    ): Observable<CityResponse>
}