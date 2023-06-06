package com.anu.retrofitnews

import com.anu.retrofitnews.api.NewsApiJson
import retrofit2.http.GET

interface APIRequest {
    @GET("v1/latest-news?language=en&apiKey=7goxs3CKQUAJRGhquf6BovIkIToi_vj5Uii2lTrQCVE9EtY2")
    suspend fun getNews() : NewsApiJson

}