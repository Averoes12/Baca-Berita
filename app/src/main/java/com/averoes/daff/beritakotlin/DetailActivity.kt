package com.averoes.daff.beritakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_model.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //todo 8 panggil function yang tadi dibuat untuk menampilkan data
        showDetailBerita()
    }

    //todo 7 membuat fuction untuk menampilkan detail berita

    fun showDetailBerita(){
        val intent = getIntent()
        title_detail.text = intent.getStringExtra(TITLE)
        author_detail.text = intent.getStringExtra(AUTHOR)
        date_detail.text = intent.getStringExtra(DATE)

        //menampilkan isi berita dengan menggunakan webview

        content_detail.settings.javaScriptEnabled
        content_detail.loadData(intent.getStringExtra(CONTENT), "text/html; utf=8", "UTF-8")

        //menampilkan gambar menggunakan picasso

        Picasso.get().load(intent.getStringExtra(IMAGE)).into(img_detail)
    }

    //untuk membuat key pada saat pengiriman data menggunakan intent
    //jika di java sama dengan menggunakan modifier static
    companion object {

        val TITLE = "title"
        val AUTHOR = "author"
        val CONTENT = "content"
        val DATE = "date"
        val IMAGE = "image"
    }
}
