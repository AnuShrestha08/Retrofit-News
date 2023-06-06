package com.anu.retrofitnews

import com.anu.retrofitnews.api.NewsApiJson
import retrofit2.http.GET

interface APIRequest {
    @GET("v1/latest-news?language=en&apiKey=-i__IXNm-XzGV_J68cqwRMSYzuIYiUT02wKKSilk4VSI_fDV")
    suspend fun getNews() : NewsApiJson

}