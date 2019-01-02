package com.chrissen.kotlindemo.data


/**
 * Created by TGCity on 19-1-2.
 */
data class WeatherResponseBean(
    val city: CityBean,
    val cnt: Int,
    val cod: String,
    val list: List<ListBean>,
    val message: Double
){
    operator fun get(position: Int) = list[position]

    fun size() = list.size
}


data class ListBean(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val humidity: Int,
    val pressure: Double,
    val rain: Double,
    val speed: Double,
    val temp: Temp,
    val weather: List<WeatherBean>
)

data class Temp(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)

data class WeatherBean(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class CityBean(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int
)

data class Coord(
    val lat: Double,
    val lon: Double
)