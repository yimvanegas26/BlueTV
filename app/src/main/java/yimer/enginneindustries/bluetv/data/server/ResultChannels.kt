package yimer.enginneindustries.bluetv.data.server

import com.google.gson.annotations.SerializedName
import yimer.enginneindustries.bluetv.domain.Channels

data class ResultChannels (

    @SerializedName("name")
    val name: String,
    @SerializedName("qtyChannels")
    val qtyChannels: String,
    @SerializedName("urlImage")
    val urlImage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("url")
    val url: String,

    ) {

    fun toChannels() = Channels (
        name,
        qtyChannels,
        urlImage,
        description,
        category,
        url

    )

}





