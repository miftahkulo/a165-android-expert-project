package com.dicoding.tourismapp.core.di

import android.content.Context
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.data.source.local.LocalDataSource
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase
import com.dicoding.tourismapp.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismapp.core.data.source.remote.retrofit.ApiConfig
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import com.dicoding.tourismapp.core.domain.usecase.TourismInteractor
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        //val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.getApiService(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())

        return TourismRepository.getInstance(remoteDataSource, localDataSource)
    }

    fun provideTourimsUseCase(context: Context) : TourismUseCase {

        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}
