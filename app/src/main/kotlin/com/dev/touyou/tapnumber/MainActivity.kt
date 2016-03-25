package com.dev.touyou.tapnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var array: Array<Int?>? = null
    var problem: String? = null
    var correct: Int? = null    // 今何桁目か？

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView) as TextView
        start()
    }

    fun start() {
        array = arrayOfNulls(4)
        val rand: Random = Random()
        // indicesは実際にオブジェクトは生成せずarrayのアドレスを次々に渡していくらしい
        if (array == null) {
            return
        }
        // nullableなものを扱う時は一回一回castする必要があるらしい
        (array as Array<Int?>).indices.forEach { i -> (array as Array<Int?>)[i] = rand.nextInt(4) + 1 }
        problem = "${(array as Array<Int?>)[0].toString()}${(array as Array<Int?>)[1].toString()}${(array as Array<Int?>)[2].toString()}${(array as Array<Int?>)[3].toString()}"
        textView?.setText(problem)
        correct = 0
    }


    // arrayは.getで取得
    fun number1(v: View) {
        number(1)
    }
    fun number2(v: View) {
        number(2)
    }
    fun number3(v: View) {
        number(3)
    }
    fun number4(v: View) {
        number(4)
    }

    fun number(n: Int) {
        if (array?.get(correct!!) == n) {
            problem = problem?.substring(1)
            textView?.setText(problem)
            correct = correct!! + 1
            if (correct === 4) {
                start()
            }
        } else {
            Toast.makeText(this, "数字が違うよ！", Toast.LENGTH_SHORT).show()
        }
    }
}
