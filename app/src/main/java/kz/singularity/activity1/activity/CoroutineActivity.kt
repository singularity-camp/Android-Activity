package kz.singularity.activity1.activity

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.coroutines.delay
import kz.singularity.activity1.CustomActionBroadCastReceiver
import kz.singularity.activity1.EXTRA_NOTIFICATION_ID
import kz.singularity.activity1.R
import kz.singularity.activity1.SecondActivity
import kz.singularity.activity1.ThirdActivity
import kotlin.random.Random
import kotlin.time.ExperimentalTime

private const val CHANNEL_ID = "myNotifChannel"
class CoroutineActivity : AppCompatActivity(R.layout.activity_main) {

    @BindView(R.id.tv_hello)
    lateinit var tvHello: TextView

    var showNotificationClickCounter = 0

    @OnClick(R.id.btn_open_second)
    fun showBasicNotification() {
        val intent = Intent(this, SecondActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT or FLAG_IMMUTABLE)

        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntent(intent)
        taskStackBuilder.addNextIntent(Intent(this, ThirdActivity::class.java))

        showNotificationClickCounter++
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_menu_gallery)
            .setContentTitle("My first notification!")
            .setContentText("Clicked = $showNotificationClickCounter times")
            .setContentIntent(taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT or FLAG_IMMUTABLE))
            .setAutoCancel(true)
            .build()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(0, notification)
        }
    }

    @OnClick(R.id.btn_open_google)
    fun showNotificationWithActionButton() {
        val notificationID = Random.nextInt()
        val customActionIntent = Intent(this, CustomActionBroadCastReceiver::class.java).apply {
            putExtra(EXTRA_NOTIFICATION_ID, notificationID)
        }
        val customActionPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            customActionIntent,
            PendingIntent.FLAG_ONE_SHOT or FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_menu_gallery)
            .setContentTitle("My second notification!")

        builder.addAction(
            android.R.drawable.ic_dialog_info,
            "Custom Button",
            customActionPendingIntent
        )
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(notificationID, builder.build())
        }
    }

    @OptIn(ExperimentalTime::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        createNotificationChannel()









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

//        GlobalScope.launch(Dispatchers.IO) {
//
//            delay(1000)
//            withContext(Dispatchers.Main) {
//                showToast("I got the result from network")
//            }
////            println("I am in ${Thread.currentThread()}")
////            withContext(Dispatchers.IO) {
////                println("Now I am in ${Thread.currentThread()}")
////            }
//        }

//        val job = GlobalScope.launch {
//            printHello()
//            printThis()
//            printIs()
//            printSuspend()
//            println("Functions")
//        }
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

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = "Basic notifications"
            val descriptionText = "This is our first channel. Please don't turn it off. We want to annoy you"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }


            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
//            notificationManager.deleteNotificationChannel(CHANNEL_ID)
        }
    }

}