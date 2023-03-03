package yimer.enginneindustries.bluetv.detail

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import yimer.enginneindustries.bluetv.R
import yimer.enginneindustries.bluetv.domain.Movie

import androidx.leanback.widget.*


class FullWidthDetailsTvRowPresenter(private val activity: Activity):
    FullWidthDetailsOverviewRowPresenter(DetailsDescriptionPresenter()) {
    private enum class Options(@StringRes val stringRes: Int) {
        VER_AHORA(R.string.ver_ahora),
        FAVORITE(R.string.favorite)
    }

    init {
        val sharedElementHelper = FullWidthDetailsOverviewSharedElementHelper()
        sharedElementHelper.setSharedElementEnterTransition(
            activity,
            DetailActivity.SHARED_ELEMENT_NAME
        )

        setListener(sharedElementHelper)
        isParticipatingEntranceTransition = true
    }




    fun buildActions(presenter: FullWidthDetailsOverviewRowPresenter): ArrayObjectAdapter {

        presenter.setOnActionClickedListener { action ->
            val option = Options.values().first { it.ordinal == action.id.toInt() }
            Toast.makeText(activity, option.stringRes, Toast.LENGTH_SHORT).show()
        }

        return ArrayObjectAdapter().apply {
            Options.values().forEach { option ->
                add(Action(option.ordinal.toLong(), activity.getString(option.stringRes)))
            }

        }

    }
}

class DetailsDescriptionPresenter: AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder, item: Any) {
        val movie = item as Movie
        vh.title.text = movie.title
        vh.subtitle.text = movie.releaseDate
        vh.body.text = movie.summary




    }

}



