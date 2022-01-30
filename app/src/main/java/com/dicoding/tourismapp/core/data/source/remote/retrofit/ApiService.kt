package com.dicoding.tourismapp.core.data.source.remote.retrofit

import com.dicoding.tourismapp.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse //hapus Call, tambahkan suspend
}