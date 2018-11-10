package com.home.retrofitrxjavademotwo

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun createOkHttpClient(): OkHttpClient {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder();
        httpClient.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url: HttpUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter("username", "kelcervan")
                    .build()
                val requesteBuilder = original.newBuilder().url(url)
                val request = requesteBuilder.build()
                return chain.proceed(request)
            }
        })

        return httpClient.build()
    }

    fun createRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.geonames.org")
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    fun getCityService(): RxBooksApiService {
        val retrofit = createRetrofit()
        return retrofit.create(RxBooksApiService::class.java)
    }
}