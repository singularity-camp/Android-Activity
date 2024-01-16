package kz.singularity.activity1.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast
import kotlin.time.ExperimentalTime

class CoroutineActivity : AppCompatActivity(R.layout.activity_main) {

    @BindView(R.id.tv_hello)
    lateinit var tvHello: TextView

    @OptIn(ExperimentalTime::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)

//        val time: Duration = measureTime {
//            repeat(10) {
//                Thread {
//                    println("Hi from thread = ${Thread.currentThread()}")
//                }.start()
//            }
//        }
//
//        println("Finished in ${time.inWholeMilliseconds} ms")


//        runBlocking {
//            val time: Duration = measureTime {
//                launch { // корутина для измерения времени
//                    repeat(10) {
//                        launch {
//                            println("Hi from coroutine. I'm on thread = ${Thread.currentThread()}")
//                        }
//                    }
//                }.join()
//            }
//            println("Finished in ${time.inWholeMilliseconds} ms")
//        }


//        val job = GlobalScope.launch {
//            delay(1000L)
//            println("After 1s")
//            delay(1000L)
//            println("After 2s")
//            delay(1000L)
//            println("After 3s")
//            delay(1000L)
//            println("After 4s")
//        }
//
//        Thread.sleep(2500L)
//        println("Cancelling after 2.5s")
//        job.cancel()
//        Thread.sleep(2000L)
//        println(job.isCancelled)
//        println(job.isCompleted)

        GlobalScope.launch(Dispatchers.IO) {

            delay(1000)
            withContext(Dispatchers.Main) {
                showToast("I got the result from network")
            }
//            println("I am in ${Thread.currentThread()}")
//            withContext(Dispatchers.IO) {
//                println("Now I am in ${Thread.currentThread()}")
//            }
        }

        val job = GlobalScope.launch {
            printHello()
            printThis()
            printIs()
            printSuspend()
            println("Functions")
        }

    }

    private suspend fun printHello() {
        println("Hello")
        delay(1000)
    }

    private suspend fun printThis() {
        println("This")
        delay(1000)
    }

    private suspend fun printIs() {
        println("Is")
        delay(1000)
    }

    private suspend fun printSuspend() {
        println("Suspend")
        delay(1000)
    }
}