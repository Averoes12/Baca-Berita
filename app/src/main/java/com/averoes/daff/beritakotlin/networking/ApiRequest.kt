package com.averoes.daff.beritakotlin.networking

import com.averoes.daff.beritakotlin.model.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by daff on 28/03/19 at 6:56.
 */

//todo 3 membuat class baru untuk request data ke database
interface ApiRequest {

//todo 4 panggil request methode

  //@REQUEST_METHODE("endpoints"/data yang kita minta)

    @GET("tampil_berita.php")
    fun getDataServer() : Call<ResponseItem>
}