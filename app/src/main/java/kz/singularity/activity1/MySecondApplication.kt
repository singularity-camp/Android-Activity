package kz.singularity.activity1

import android.app.Application
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MySecondApplication : Application() {

    private val TAG = "MySecondApplication"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

        val color1: Int = ContextCompat.getColor(this, R.color.black)
    }
}