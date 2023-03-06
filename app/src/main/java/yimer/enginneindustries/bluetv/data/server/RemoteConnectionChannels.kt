package yimer.enginneindustries.bluetv.data.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RemoteConnectionChannels {

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }



    private val builderChannel = Retrofit.Builder()
        .baseUrl("https://4snntwsk29.execute-api.us-east-1.amazonaws.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val services: RemoteService = builderChannel.create()
}