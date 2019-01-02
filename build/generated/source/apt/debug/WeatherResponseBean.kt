data class WeatherResponseBean(
        val city: City,
        val cnt: Int,
        val cod: String,
        val list: List<X>,
        val message: Double
)