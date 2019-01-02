package com.chrissen.kotlindemo.domain

import com.chrissen.kotlindemo.data.WeatherResponseBean
import com.google.gson.Gson

/**
 *  Function:
 *  <br/>
 *  Describe:
 *  <br/>
 *  Author: chris on 2018/4/10.
 *  <br/>
 *  Email: sunqirui@jiuhuar.com
 */

public class ForecastRequest(val zipCode: String) {

    //修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): WeatherResponseBean {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, WeatherResponseBean::class.java)
    }

}
