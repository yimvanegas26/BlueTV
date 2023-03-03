package yimer.enginneindustries.bluetv.detail


import android.content.Intent
import android.os.Bundle
import android.view.View


import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.*

import yimer.enginneindustries.bluetv.domain.Movie
import yimer.enginneindustries.bluetv.iu.common.loadImageUrl



class DetailFragment: DetailsSupportFragment() {

    private val detailsBackgroundState = DetailsBackgroundState(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = requireActivity().intent.getParcelableExtra<Movie>(DetailActivity.MOVIE_EXTRA)
            ?: throw IllegalStateException("Movie no  encontrada")

        val presenter = FullWidthDetailsTvRowPresenter(requireActivity())

        val rowsAdapter = ArrayObjectAdapter(presenter)
        val detailsOverviewRow = DetailsOverviewRow(movie)
        detailsOverviewRow.loadImageUrl(requireContext(), movie.poster)
        detailsOverviewRow.actionsAdapter = presenter.buildActions(presenter)


        rowsAdapter.add(detailsOverviewRow)

        adapter = rowsAdapter

        detailsBackgroundState.loadUrl(movie.backdrop)



    }



}






