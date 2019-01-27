package com.example.vishesh.realwolrdapp.Fragments.Home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.vishesh.realwolrdapp.Fragments.enqueue
import com.example.vishesh.realwolrdapp.data.ConduitClient
import com.example.vishesh.realwolrdapp.data.models.Article

class HomeViewModel : ViewModel() {

    val globalFeed: MutableLiveData<ArrayList<Article>> by lazy {
        MutableLiveData<ArrayList<Article>>()
    }
    fun refreshGlobalFeed () {
        ConduitClient.conduitApi.getArticles().enqueue { t, response ->
            response?.body()?.let {
                globalFeed.postValue(it.articles)
            }
        }
    }
}

