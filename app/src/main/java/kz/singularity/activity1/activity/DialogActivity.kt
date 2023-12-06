package kz.singularity.activity1.activity

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kz.singularity.activity1.R
import kz.singularity.activity1.fragments.CustomDialogFragment
import kz.singularity.activity1.showToast
import java.util.*

class DialogActivity : AppCompatActivity(R.layout.activity_dialog) {

    private companion object {
        private const val TAG = "DialogActivity"
    }

    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var btnAlert: Button
    private lateinit var btnCustomAlert: Button
    private lateinit var btnDialogFragment: Button

    private var selectedIndex = 0
    private val students by lazy { resources.getStringArray(R.array.array_students) }
    private val studentsTicked by lazy { students.map { false }.toBooleanArray() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignViews()
        setupClickListeners()
    }

    private fun assignViews() {
        btnDate = findViewById(R.id.btn_date)
        btnTime = findViewById(R.id.btn_time)
        btnAlert = findViewById(R.id.btn_alert)
        btnCustomAlert = findViewById(R.id.btn_custom_alert)
        btnDialogFragment = findViewById(R.id.btn_dialog_fragment)
    }

    private fun setupClickListeners() {
        btnDate.setOnClickListener { openDatePickerDialog() }
        btnTime.setOnClickListener { openTimePickerDialog() }
        btnAlert.setOnClickListener { openAlertDialog() }
        btnCustomAlert.setOnClickListener { openCustomAlertDialog() }
        btnDialogFragment.setOnClickListener { openFragmentDialog() }
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
//            .setSingleChoiceItems(R.array.array_students, selectedIndex) {_, index ->
//                Log.e(TAG, "Clicked on student at $index")
//                selectedIndex = index
//            }
            .setMultiChoiceItems(students, studentsTicked) { _, index, isChecked ->
                Log.e(TAG, "OnChecked = $index, isChecked = $isChecked")
                studentsTicked[index] = isChecked
            }
            .show()
    }

    private fun openCustomAlertDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_custom, null, false)
        val tvTitle: TextView = view.findViewById(R.id.title)
        val tvSubtitle: TextView = view.findViewById(R.id.subtitle)
        val btnClose: TextView = view.findViewById(R.id.closeButton)

        tvTitle.text = "Custom Title"
        tvSubtitle.text = "Custom Subtitle"
        val alertDialog = AlertDialog.Builder(this)
            .setView(view)
            .show()


        btnClose.setOnClickListener { alertDialog.dismiss() }
    }

    private fun openFragmentDialog() {
        val dialogFragment = CustomDialogFragment()
        dialogFragment.setOnDismissListener {
            Log.e(TAG, "Dialog has been dismissed")
        }
        dialogFragment.show(supportFragmentManager, null)


    }

}