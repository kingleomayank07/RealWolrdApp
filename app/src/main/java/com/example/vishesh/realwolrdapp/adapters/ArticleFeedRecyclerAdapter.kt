package com.example.vishesh.realwolrdapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vishesh.realwolrdapp.R
import com.example.vishesh.realwolrdapp.data.models.Article
import kotlinx.android.synthetic.main.item_list_article.view.*

class ArticleFeedRecyclerAdapter:
    RecyclerView.Adapter<ArticleFeedRecyclerAdapter.ArticleViewHolder>() {

    private var articlelist=ArrayList<Article>()

    fun updateArticleList(newArticleList: ArrayList<Article>){
        articlelist.clear()
        articlelist.addAll(newArticleList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        with(parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater) {
            ArticleViewHolder(inflate(R.layout.item_list_article, parent, false))
        }

    override fun getItemCount(): Int = articlelist.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articlelist[position])
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(article: Article){
            itemView.tv_article_title.text = article.title
            if (article.body.length > 100) {
                itemView.tv_article_description.text = article.body.substring(100) + " . . . "
            } else {
                itemView.tv_article_description.text = article.body
            }
        }
        }
}