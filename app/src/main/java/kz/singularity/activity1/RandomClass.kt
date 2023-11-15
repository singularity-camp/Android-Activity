package kz.singularity.activity1

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class RandomClass {

    fun openSecondActivity(context: Context) {
        val intent = Intent(context, SecondActivity::class.java)
        context.startActivity(intent)
    }
}