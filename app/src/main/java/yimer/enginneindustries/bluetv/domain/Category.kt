package yimer.enginneindustries.bluetv.domain

enum class Category(val id: String) {

    DOCUMENTALES("1"),
    MINISERIES("2"),
    REALITY("3"),
    DEPORTIVO("4"),
    DOCUMENTAL("5"),
    ENTRETENIMIENTO("6"),
    INFANTIL("7"),
    MUSICA ("8"),
    NOVELAS("9"),
    NOTICIAS("10"),
    RELIGIOSO("11"),
    POPULARES("popularity.desc"),
    NUEVO("first_air_date.desc"),
    VOTADAS("vote_average.desc"),


}