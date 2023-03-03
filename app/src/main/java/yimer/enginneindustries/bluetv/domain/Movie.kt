package yimer.enginneindustries.bluetv.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Movie(
    val title:String,
    val releaseDate: String,
    val summary: String,
    val poster:String,
    val backdrop:String,
    val origin_country:List<String>,

    ) : Parcelable




data class Data(
    var category_name: String? = null,
    var sub_categories: List<Category>? = null
)

data class SubCategory(
    var sub_category_name: String? = null,
    var items: List<Category>? = null
)

data class BannerData(
    var category_name: String? = null,
    var banner_list: List<String>? = null
)

data class Item(
    var name: String? = null,
    var imageUrl: String? = null
)