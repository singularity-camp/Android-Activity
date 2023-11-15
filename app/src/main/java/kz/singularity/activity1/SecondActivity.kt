package kz.singularity.activity1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val TAG = "SecondActivity"
    private val KEY_COUNTER = "key_counter"

    private lateinit var counterTextView: TextView
    private lateinit var plusButton: Button
    private lateinit var btnOpenThird: Button

    var currentCounter = 0

    private val activityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Log.d(TAG, "onActivityResult")

            if (it.resultCode == Activity.RESULT_CANCELED) {
                showToast("We got cancelled")
            }
            if (it.resultCode == Activity.RESULT_OK) {
                currentCounter = 0
                updateCounterText()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate = $this")
        setContentView(R.layout.activity_second)

        initViews()

        updateCounterText()

        setupClickListeners()
    }

    private fun initViews() {
        plusButton = findViewById(R.id.plusButton)
        counterTextView = findViewById(R.id.counterTextView)
        btnOpenThird = findViewById(R.id.btn_open_third)
    }

    private fun updateCounterText() {
        counterTextView.text = currentCounter.toString()
    }

    private fun setupClickListeners() {
        plusButton.setOnClickListener {
            currentCounter++
            updateCounterText()
        }
        btnOpenThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra(RESULT_KEY, currentCounter)
            activityResultLauncher.launch(intent)
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, currentCounter)

        Log.d(TAG, "onSaveInstanceState() is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val restoredCounterValue = savedInstanceState.getInt(KEY_COUNTER, 0)
        counterTextView.text = restoredCounterValue.toString()
        Log.d(TAG, "Restored counter value = $restoredCounterValue")
        Log.d(TAG, "onRestoreInstanceState() is called")
    }

}