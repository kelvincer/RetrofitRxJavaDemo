package com.home.retrofitrxjavademotwo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geoname(

    @SerializedName("lng")
    @Expose
    val lng: Double?,
    @SerializedName("geonameId")
    @Expose
    var geonameId: Int? = null,
    @SerializedName("countrycode")
    @Expose
    var countrycode: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("fclName")
    @Expose
    var fclName: String? = null,
    @SerializedName("toponymName")
    @Expose
    var toponymName: String? = null,
    @SerializedName("fcodeName")
    @Expose
    var fcodeName: String? = null,
    @SerializedName("wikipedia")
    @Expose
    var wikipedia: String? = null,
    @SerializedName("lat")
    @Expose
    var lat: Double? = null,
    @SerializedName("fcl")
    @Expose
    var fcl: String? = null,
    @SerializedName("population")
    @Expose
    var population: Int? = null,
    @SerializedName("fcode")
    @Expose
    var fcode: String? = null
)
