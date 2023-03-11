package com.example.semafor

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imSemafor: ImageView? = null
    var counter: Int = 0
    var timer: Timer? = null
    var isRun = false

    var imageArray: IntArray = intArrayOf(R.drawable.red,R.drawable.yellow,R.drawable.green)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSemafor = findViewById(R.id.imSemafor)
        imSemafor?.setImageResource(imageArray[2])
    }
    fun onClickStartStop(view: View) {
        view as ImageButton
//        imSemafor?.setImageResource(R.drawable.green)
        if (!isRun){
            startStop()

            isRun = true}
        else{
            imSemafor?.setImageResource(R.drawable.none)
            view.setImageResource((R.drawable.start))
            timer?.cancel()
            isRun = false
            counter = 0

        }


        view.setImageResource(R.drawable.stop)
    }
    fun startStop(){
        timer = Timer()
        timer?.schedule(object:TimerTask(){
            override fun run() {
                runOnUiThread {
                    imSemafor?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0}
            }

        },0,1000)

    }
}