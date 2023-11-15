package kz.singularity.activity1

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var btnOpenSecond: Button
    lateinit var btnOpenGoogle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        initViews()
        initClickListeners()

        contextExamples()

        this.applicationContext
        applicationContext
    }

    private fun initViews() {
        btnOpenSecond = findViewById(R.id.btn_open_second)
        btnOpenGoogle = findViewById(R.id.btn_open_google)
    }

    private fun initClickListeners() {
        btnOpenSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        btnOpenGoogle.setOnClickListener {
            val address = Uri.parse("http://google.com")
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        }
    }

    private fun contextExamples() {
        val color1: Int = ContextCompat.getColor(this, R.color.black)

        val color2 = ResourcesCompat.getColor(resources, R.color.black, null)
        val text: String = getString(R.string.app_name)
        val dimen: Float =
            resources.getDimension(androidx.core.R.dimen.compat_notification_large_icon_max_width)
        val apps: MutableList<ApplicationInfo> = packageManager.getInstalledApplications(
            PackageManager.GET_META_DATA
        )
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }


}