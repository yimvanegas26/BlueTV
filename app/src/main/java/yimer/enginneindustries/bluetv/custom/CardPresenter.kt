package yimer.enginneindustries.bluetv.custom

import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import yimer.enginneindustries.bluetv.domain.Movie
import yimer.enginneindustries.bluetv.domain.Channels
import yimer.enginneindustries.bluetv.iu.common.loadUrl

class CardPresenter: Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            cardType = BaseCardView.CARD_TYPE_INFO_UNDER
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(450, 400)
        }



        return ViewHolder(cardView)
    }

    // override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
    //     val movie = item as Movie
    //     with(viewHolder.view as ImageCardView) {
    //         titleText = movie.title
    //         contentText = movie.releaseDate
    //         mainImageView.loadUrl(movie.poster)
    //     }     
    // }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val channel = item as Channels
        with(viewHolder.view as ImageCardView) {
            titleText = channel.name
            contentText = channel.description
            mainImageView.loadUrl(channel.urlImage)
        }     
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as ImageCardView) {
            mainImage = null
        }

    }

}