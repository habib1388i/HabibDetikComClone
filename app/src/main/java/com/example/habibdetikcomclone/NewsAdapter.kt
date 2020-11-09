package com.example.habibdetikcomclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val context: Context, val listNews: List<Model>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))

    override fun getItemCount() = listNews.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listNews[position])

        holder.itemView.setOnClickListener {
            this.onItemClickCallback.onItemClick(listNews[position]) }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(data: Model)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var tvTitle = view.findViewById<TextView>(R.id.txt_title)
        var tvDescription = view.findViewById<TextView>(R.id.txt_description)
        var imgNews = view.findViewById<ImageView>(R.id.img_news)

        fun bind(news: Model) {
            tvTitle.text = news.title
            tvDescription.text = news.desc
            imgNews.setImageResource(news.photo)

        }
    }
}