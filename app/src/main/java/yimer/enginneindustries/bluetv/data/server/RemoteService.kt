package yimer.enginneindustries.bluetv.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("discover/tv")
    suspend fun listPopularTv(
        @Query("api_key") apiKey: String,
        @Query("sort_by") sortBy: String,
        @Query("language") language: String = "es-US",
        @Query("with_original_language") with_original_language: String = "es",
        @Query("vote_count.gte") voteCount: Int = 100,



    ): RemoteResult

    @GET("discover/tv")
    suspend fun listTypeTv(
        @Query("api_key") apiKey: String,
        @Query("with_type") with_type: String,
        @Query("language") language: String = "es-US",
        @Query("with_original_language") with_original_language: String = "es",
        ): RemoteResult

    @GET("/api/user")
    suspend fun channelsTv(searchQuery: String, id: String): RemoteChannelsResult




}