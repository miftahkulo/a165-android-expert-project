package com.dicoding.tourismapp.core.data.source.remote.retrofit

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.dicoding.tourismapp.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {
        fun getApiService(context: Context): ApiService {
            val loggingInterceptor = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

            val builder = OkHttpClient.Builder()
            builder
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .connectTimeout(180, TimeUnit.SECONDS)
                .interceptors()
                .add {
                    it.proceed(
                        it.request()
                            .newBuilder()
                            // header to every request
                            //.addHeader("Authorization", BuildConfig.API_KEY)
                            .build()
                    )
                }
            val client = builder
                .addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .collector(ChuckerCollector(context))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(
                    GsonConverterFactory.create(
                        // convert any null request
                        GsonBuilder().serializeNulls().create()
                    )
                )
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}