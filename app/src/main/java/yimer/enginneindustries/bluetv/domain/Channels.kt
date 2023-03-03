package yimer.enginneindustries.bluetv.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channels (
    val name:String,
    val qtyChannels: String,
    val urlImage: String,
    val description:String,
    val category:String,
    val url:String,

    ) : Parcelable

data class BannerDataOne(
    var category_name: String? = null,
    var banner_list: List<String>? = null
)

