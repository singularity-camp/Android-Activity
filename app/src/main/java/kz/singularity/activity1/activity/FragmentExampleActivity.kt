package kz.singularity.activity1.activity

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kz.singularity.activity1.R
import kz.singularity.activity1.fragments.MainFragment
import kz.singularity.activity1.fragments.SecondFragment

class FragmentExampleActivity : AppCompatActivity() {

    val TAG = FragmentExampleActivity::class.java.simpleName

    lateinit var btnAdd: Button
    lateinit var btnRemove: Button
    lateinit var btnReplace: Button

    lateinit var cbBackStack: CheckBox

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)
        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        btnAdd = findViewById(R.id.btn_add)
        btnRemove = findViewById(R.id.btn_remove)
        btnReplace = findViewById(R.id.btn_replace)
        cbBackStack = findViewById(R.id.cb_backStack)
    }

    private fun setupClickListeners() {
        btnAdd.setOnClickListener {
            Log.d(TAG, "Fragments backstackCount = ${supportFragmentManager.backStackEntryCount}")
            Log.d(TAG, "Fragments count = ${supportFragmentManager.fragments.size}")

            val fragmentToPut = MainFragment.newInstance(2)
            val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragmentToPut, null)

            if (cbBackStack.isChecked) {
                transaction.addToBackStack(null)
            }

            transaction.commit()
        }

        btnRemove.setOnClickListener {

            val fragmentToRemove = supportFragmentManager.fragments.getOrNull(0) ?: return@setOnClickListener
            supportFragmentManager.beginTransaction()
                .remove(fragmentToRemove)
                .commit()
        }

        btnReplace.setOnClickListener {
            val fragmentToPut = SecondFragment()
            val transaction = supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentToPut, null)


            if (cbBackStack.isChecked) {
                transaction.addToBackStack(null)
            }

            transaction.commit()
        }
    }
}