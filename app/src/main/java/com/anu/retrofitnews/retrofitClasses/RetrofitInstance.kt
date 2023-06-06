package com.anu.retrofitnews.retrofitClasses

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
//    companion object{
//        val BASE_URL = "https://api.currentsapi.services"
//        private var retrofit: Retrofit? = null
//        val retrofitInstance: Retrofit?
//            get() {
//                if (retrofit == null) {
//                    retrofit = Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build()
//                }
//                return retrofit
//            }
//    }
companion object {
    private var retrofit: Retrofit? = null
    private const val BASE_URL =  "https://api.currentsapi.services"

    fun getRetrofitInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
}