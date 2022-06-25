package com.example.datamodule.di

import com.example.datamodule.network.ApiConstants
import com.example.datamodule.network.ApiService
import com.example.datamodule.repo.ImdbRepo
import com.example.domainmodule.IImdbRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.IMDB_BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideGithubRepository(apiService: ApiService): IImdbRepo {
        return ImdbRepo(apiService)
    }

    @Provides
    fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}