package kz.singularity.activity1.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.GONE
import android.view.View.INVISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import butterknife.BindView
import butterknife.ButterKnife
import kz.singularity.activity1.R

class ConstraintLayoutActivity : AppCompatActivity() {

    @BindView(R.id.group)
    lateinit var group: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        ButterKnife.bind(this)
    }
}