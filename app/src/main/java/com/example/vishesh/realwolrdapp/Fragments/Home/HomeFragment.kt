package com.example.vishesh.realwolrdapp.Fragments.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vishesh.realwolrdapp.R
import com.example.vishesh.realwolrdapp.adapters.ArticleFeedRecyclerAdapter
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var articleRecyclerView = ArticleFeedRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.home_fragment,container,false).apply {
        this.rv_article_feed.layoutManager = LinearLayoutManager(context)
        this.rv_article_feed.adapter = articleRecyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.globalFeed.observe(
            { lifecycle },
            { articleRecyclerView.updateArticleList(it) }
        )

        viewModel.refreshGlobalFeed()
    }


}
