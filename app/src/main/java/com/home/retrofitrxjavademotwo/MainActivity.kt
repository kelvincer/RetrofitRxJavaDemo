package com.home.retrofitrxjavademotwo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        viewModel.liveData.observe(this, Observer {

            val strBuilder = StringBuilder()
            it?.forEach {
                strBuilder.append(it.name).append("\n")
            }
            txv.setText(strBuilder.toString())
        })

        viewModel.getData()
    }
}
