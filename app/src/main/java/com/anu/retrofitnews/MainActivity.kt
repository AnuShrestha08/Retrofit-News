package com.anu.retrofitnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anu.retrofitnews.adapter.RecyclerAdapter
import com.anu.retrofitnews.retrofitClasses.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception
import kotlin.collections.mutableListOf

//const val BASE_URL = "https://api.currentsapi.services"
class MainActivity : AppCompatActivity() {



    private lateinit var rv_recyclerView:RecyclerView

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<String>()
    private var linksList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_recyclerView= findViewById(R.id.rv_recyclerView)

        makeAPIRequest()
    }

    fun setUpRecyclerview(){
        rv_recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        rv_recyclerView.adapter = RecyclerAdapter(titlesList, descList, imageList, linksList)
    }

    private fun addToList(title: String, description: String, image: String, link:String){
        titlesList.add(title)
        descList.add(description)
        imageList.add(image)
        linksList.add(link)
    }


    private fun makeAPIRequest(){
//        val api= Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(APIRequest::class.java)
        val api = RetrofitInstance.getRetrofitInstance().create(APIRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getNews()
                for(article in response.news){
                    Log.i("MainActivity", "Result=$article")
                    addToList(article.title, article.description, article.image, article.url)
                }
                withContext(Dispatchers.Main){
                    setUpRecyclerview()
                }
            }catch (e:Exception){
                Log.e("MainActivity",e.toString())
            }
        }
    }
}