package com.averoes.daff.beritakotlin.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by daff on 28/03/19 at 6:45.
 */

//todo 2 buat class baru sebagai configurasi retrofit

class ConfigRetrofit {

    //todo 3 configurasi retrofit

    fun getRetrofit() : Retrofit{

        val retrofit = Retrofit.Builder()
                //masukkan url nya
                //karna penggunaan localhost kurang bagus di android jadi gunakan ip address
            .baseUrl("http://192.168.0.106/portal_berita/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    //todo 4 configurasi retrofit ke dalam request
    fun getRequest(): ApiRequest{

        val request = getRetrofit().create(ApiRequest::class.java)

        return request
    }

}