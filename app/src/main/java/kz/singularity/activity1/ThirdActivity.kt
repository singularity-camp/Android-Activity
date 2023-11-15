package kz.singularity.activity1

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val RESULT_KEY = "result"

class ThirdActivity : AppCompatActivity(R.layout.activity_third) {

    lateinit var tvResult: TextView
    lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        useReceivedData()
        initClickListeners()
    }

    private fun initViews() {
        tvResult = findViewById(R.id.tv_result)
        btnReset = findViewById(R.id.btn_reset)
    }

    private fun useReceivedData() {
        val result = intent.getIntExtra(RESULT_KEY, 0)
        val resultString = resources.getString(R.string.result_is, result)
        tvResult.text = resultString
    }

    private fun initClickListeners() {
        btnReset.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}