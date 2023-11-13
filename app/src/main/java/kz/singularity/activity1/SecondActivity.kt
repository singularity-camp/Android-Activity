package kz.singularity.activity1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val TAG = "SecondActivity"
    private val KEY_COUNTER = "key_counter"
    var currentCounter = 0
    lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate = $this")
        setContentView(R.layout.activity_second)


        val plusButton: Button = findViewById(R.id.plusButton)
        counterTextView = findViewById(R.id.counterTextView)

        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
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