package yimer.enginneindustries.bluetv.iu.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.leanback.widget.DetailsOverviewRow
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import retrofit2.http.Url

fun ImageView.loadUrl(url: String) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}

fun DetailsOverviewRow.loadImageUrl(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable>?,
            ) {
                imageDrawable = resource

            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })
}