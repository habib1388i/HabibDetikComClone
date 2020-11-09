package com.example.habibdetikcomclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var headlineNews: Model?
        if (Model.NewsModel.newList.size > 0){
            headlineNews = Model.NewsModel.newList[Model.NewsModel.newList.size-1]
            txt_titleHeadline.setText(headlineNews.title)
            txt_descriptionHeadline.setText(headlineNews.desc)
            img_headline.setImageResource(headlineNews.photo)

            cv_newsheadline.setOnClickListener {
                val intent_detail = Intent(this@MainActivity,
                    DetailActivity::class.java).apply {
                    putExtra(DetailActivity.cont_TitleNews,
                        headlineNews.title.toString())
                    putExtra(DetailActivity.cont_PhotoNews,
                        headlineNews.photo.toString())
                }

                startActivity(intent_detail)
                finish()
            }

        }

        val layManager = LinearLayoutManager(this)
        layManager.orientation = LinearLayoutManager.VERTICAL
        rv_daftar_berita.layoutManager = layManager

        newsAdapter = NewsAdapter(this, Model.NewsModel.newList)
        rv_daftar_berita.adapter = newsAdapter

        newsAdapter.setOnItemClickCallback(
            object : NewsAdapter.OnItemClickCallback {
                override fun onItemClick(data: Model) {
                    val intent = Intent(this@MainActivity,
                        DetailActivity::class.java).apply {
                        putExtra(DetailActivity.cont_TitleNews,
                            data.title.toString())
                        putExtra(DetailActivity.cont_PhotoNews,
                            data.photo.toString())
                    }
                    startActivity(intent)
                    finish()
                }
            }
        )

    }
}