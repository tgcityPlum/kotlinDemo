package com.chrissen.kotlindemo.module

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.chrissen.kotlindemo.R
import com.chrissen.kotlindemo.data.ListBean
import com.chrissen.kotlindemo.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //添加样式
        forecast_list.layoutManager = LinearLayoutManager(this)

        //切换线程
        doAsync {
            //访问数据
            val result = RequestForecastCommand("94043").execute()
            Log.e("Weather", result.toString())

            uiThread {
                //更新UI，设置适配器
                forecast_list.adapter = ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener {

                    override fun invoke(forecast: ListBean) {
                        toast(forecast.toString())
                    }
                })
            }
        }



    }


}
