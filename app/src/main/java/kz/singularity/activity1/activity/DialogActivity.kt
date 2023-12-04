package kz.singularity.activity1.activity

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast
import java.util.*

class DialogActivity : AppCompatActivity(R.layout.activity_dialog) {

    private companion object {
        private const val TAG = "DialogActivity"
    }

    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var btnAlert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignViews()
        setupClickListeners()
    }

    private fun assignViews() {
        btnDate = findViewById(R.id.btn_date)
        btnTime = findViewById(R.id.btn_time)
        btnAlert = findViewById(R.id.btn_alert)
    }

    private fun setupClickListeners() {
        btnDate.setOnClickListener { openDatePickerDialog() }
        btnTime.setOnClickListener { openTimePickerDialog() }
        btnAlert.setOnClickListener { openAlertDialog() }
    }

    private fun openDatePickerDialog() {
        val onDateSetListener = OnDateSetListener { p0, year, month, dayOfMonth ->
            showToast("Chose $dayOfMonth/${month + 1}/$year")
        }
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            onDateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun openTimePickerDialog() {
        val onTimeSetListener = OnTimeSetListener { _, hour, minute ->
            showToast("Chose $hour:$minute")
        }
        val calendar = Calendar.getInstance()
        val datePickerDialog = TimePickerDialog(
            this,
            onTimeSetListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        datePickerDialog.show()
    }

    private fun openAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Do you want to buy it?")
            .setPositiveButton(android.R.string.ok) { _, _ -> Log.e(TAG, "onPositiveButton Click") }
            .setNegativeButton(android.R.string.cancel) { _, _ ->
                Log.e(
                    TAG,
                    "onNegativeButtonClick"
                )
            }
            .setNeutralButton("I'l think", null)
            .setOnCancelListener { Log.e(TAG, "onCancelListener") }
            .setOnDismissListener { Log.e(TAG, "onDismissListener") }
            .show()

    }

}