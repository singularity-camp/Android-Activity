package kz.singularity.activity1.activity

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import kz.singularity.activity1.R
import timber.log.Timber

class ThreadActivity : AppCompatActivity() {

    @BindView(R.id.btn_start)
    lateinit var btnStart: Button
    @BindView(R.id.tv_result)
    lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        ButterKnife.bind(this)
        btnStart.setOnClickListener {
            doSomething()
        }
    }

    private fun doSomething() {
//        val handlerOne = Handler(mainLooper)
//        MyThread(handlerOne, tvResult).start()

        val handlerThread = HandlerThread("MyHandlerThread")

        handlerThread.start()
        val handlerTwo = object : Handler(handlerThread.looper) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Timber.e("Received message")
            }
        }
        val handlerOne = Handler(handlerThread.looper)

        val message = Message()
        message.obj = "Message to recipient"
        handlerTwo.sendMessage(message)

//        }


    }
}