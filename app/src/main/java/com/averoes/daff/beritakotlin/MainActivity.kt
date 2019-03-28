package com.averoes.daff.beritakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.averoes.daff.beritakotlin.adapter.MyAdapter
import com.averoes.daff.beritakotlin.model.BeritaItem
import com.averoes.daff.beritakotlin.model.ResponseItem
import com.averoes.daff.beritakotlin.networking.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 6 panggil configurasi retrofit

        val request = ConfigRetrofit().getRequest()


        request.getDataServer().enqueue(object : Callback<ResponseItem>{
            override fun onFailure(call: Call<ResponseItem>, t: Throwable) {
                toast("Response Failure")
//                error("Response Failure")
            }

            override fun onResponse(call: Call<ResponseItem>, response: Response<ResponseItem>) {
                toast("Succes")
                showList(response.body()?.berita)
            }
        })

    }

    private fun showList(articles: List<BeritaItem?>?) {

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MyAdapter(this, articles)
        recycler.setHasFixedSize(true)
    }
}
