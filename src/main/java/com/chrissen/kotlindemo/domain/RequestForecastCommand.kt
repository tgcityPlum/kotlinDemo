package com.chrissen.kotlindemo.domain

import com.chrissen.kotlindemo.data.WeatherResponseBean

/**
 *  Function:
 *  <br/>
 *  Describe:请求提交的类
 *  <br/>
 *  Author: chris on 2018/4/10.
 *  <br/>
 *  Email: sunqirui@jiuhuar.com
 */

class RequestForecastCommand(private val zipCode : String) : Command<WeatherResponseBean> {

    override fun execute(): WeatherResponseBean {
        val forecastRequest = ForecastRequest(zipCode)
        return forecastRequest.execute()
    }
}