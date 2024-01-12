package kz.singularity.activity1.threads

import timber.log.Timber

class MyRunnable : Runnable {
override fun run() {
    val mainThread = Thread.currentThread()
    Timber.e("Текущий поток: " + mainThread.name)
    var i = 0
    var sum = 0L
    for (i in 1..Int.MAX_VALUE) {
        sum += i
    }
    Timber.e("Sum is = $sum")
    }
}