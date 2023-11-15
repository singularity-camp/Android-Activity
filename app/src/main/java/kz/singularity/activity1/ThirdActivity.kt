package kz.singularity.activity1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val RESULT_KEY = "result"

class ThirdActivity : AppCompatActivity(R.layout.activity_third) {

    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        useReceivedData()
    }

    private fun initViews() {
        tvResult = findViewById(R.id.tv_result)
    }

    private fun useReceivedData() {
        val result = intent.getIntExtra(RESULT_KEY, 0)
        val resultString = resources.getString(R.string.result_is, result)
        tvResult.text = resultString
    }

}