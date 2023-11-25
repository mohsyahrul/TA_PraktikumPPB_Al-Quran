package com.alquran.networking

import retrofit2.http.GET
import com.alquran.model.main.ModelSurah
import com.alquran.model.main.ModelAyat
import retrofit2.Call
import retrofit2.http.Path
import java.util.ArrayList

interface ApiInterface {
    @GET("/99c279bb173a6e28359c/data")
    fun getListSurah(): Call<ArrayList<ModelSurah>>

    @GET("/99c279bb173a6e28359c/surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<ArrayList<ModelAyat>>
}