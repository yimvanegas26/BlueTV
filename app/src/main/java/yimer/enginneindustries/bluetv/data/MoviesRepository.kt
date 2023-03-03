package yimer.enginneindustries.bluetv.data

import yimer.enginneindustries.bluetv.domain.Category
import yimer.enginneindustries.bluetv.domain.Movie
import yimer.enginneindustries.bluetv.domain.Channels
import yimer.enginneindustries.bluetv.data.server.RemoteConnection
import yimer.enginneindustries.bluetv.data.server.RemoteConnectionChannels



class MoviesRepository(private val apiKey:String) {

    val type: Int = 1

    suspend fun getCategories(): Map<Category, List<Movie>> {
        return Category.values().associateWith { category ->
            when(category.id){
                "1","2","3"->RemoteConnection
                    .service
                    .listTypeTv(apiKey, category.id, )
                    .results.map { it.toDomainMovie() }
                else ->       RemoteConnection
                    .service
                    .listPopularTv(apiKey, category.id)
                    .results.map { it.toDomainMovie() }

            }
        }

    }

    suspend fun getChannels(): Map<Category, List<Channels>> {
        return Category.values().associateWith { category ->
            when(category.id){
                "4","5","6","7","8","9","10","11"->RemoteConnectionChannels
                    .services
                    .channelsTv(apiKey, category.id, )
                    .resultsChannel.map { it.toChannels() }
                else ->       RemoteConnectionChannels
                    .services
                    .channelsTv(apiKey, category.id)
                    .resultsChannel.map { it.toChannels() }

            }
        }

    }
}