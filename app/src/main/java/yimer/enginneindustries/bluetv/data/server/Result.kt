package yimer.enginneindustries.bluetv.data.server

import com.google.gson.annotations.SerializedName
import yimer.enginneindustries.bluetv.domain.Movie


data class Result(
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @SerializedName("first_air_date")
    val first_air_date: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val origin_country: List<String>,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("name")
    val nameChannel: String,

    

) {


    fun toDomainMovie() = Movie (
        name,
        original_language,
        overview,
        backdrop_path.let { "https://image.tmdb.org/t/p/w780/$it" },
        "https://image.tmdb.org/t/p/w780/$poster_path",
        origin_country



            )

    }







