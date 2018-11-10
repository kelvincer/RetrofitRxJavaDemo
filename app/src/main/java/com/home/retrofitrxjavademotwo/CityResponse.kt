package com.home.retrofitrxjavademotwo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityResponse(
        @SerializedName("geonames")
        @Expose
        var geonames: List<Geoname>
)
