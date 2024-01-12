package kz.singularity.activity1.threads

import android.os.Handler
import android.widget.TextView
import timber.log.Timber

class MyThread(val mainHandler: Handler, val tvResult: TextView) : Thread() {
    override fun run() {
        Timber.d("Mой поток запущен...")

        val mainThread = Thread.currentThread()
        Timber.e("Текущий поток: " + mainThread.name)
        var i = 0
        var sum = 0L
        for (i in 1..Int.MAX_VALUE) {
            sum += i
        }
        Timber.e("Sum is = $sum")

        mainHandler.post {
            tvResult.text = "Sum = $sum"
        }
    }
}
