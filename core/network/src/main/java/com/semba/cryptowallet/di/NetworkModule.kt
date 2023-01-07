package com.semba.cryptowallet.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.semba.cryptowallet.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesWalletRetrofitService(json: Json): WalletNetworkService
    {
        val networkApi = Retrofit.Builder()
            .baseUrl(Routes.WALLET_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(WalletNetworkService::class.java)

        return networkApi
    }

    @Provides
    @Singleton
    fun providesBitcoinRetrofitService(json: Json): BitcoinNetworkService
    {
        val networkApi = Retrofit.Builder()
            .baseUrl(Routes.BITCOIN_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(BitcoinNetworkService::class.java)

        return networkApi
    }

    @Provides
    @Singleton
    fun providesEthereumRetrofitService(json: Json): EthereumNetworkService
    {
        val ethereumApiKey = ""
        val networkApi = Retrofit.Builder()
            .baseUrl(Routes.ETHEREUM_BASE_URL + ethereumApiKey)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(EthereumNetworkService::class.java)

        return networkApi
    }

    @Provides
    @Singleton
    fun providesBinanceRetrofitService(json: Json): BinanceNetworkService
    {
        val networkApi = Retrofit.Builder()
            .baseUrl(Routes.BINANCE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(BinanceNetworkService::class.java)

        return networkApi
    }

    @Provides
    @Singleton
    fun providesTronRetrofitService(json: Json): TronNetworkService
    {
        val networkApi = Retrofit.Builder()
            .baseUrl(Routes.TRON_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(TronNetworkService::class.java)

        return networkApi
    }
}