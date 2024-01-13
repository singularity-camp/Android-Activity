package kz.singularity.activity1.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.singularity.activity1.ParcelableUser
import kz.singularity.activity1.R
import timber.log.Timber

class MainFragment : Fragment() {

    val TAG = "MainFragment"

    var numberToShow: Int = 0
    var parcelableUser: ParcelableUser? = null

    companion object {

        const val ARG_NUMBER = "arg_number"
        const val ARG_USER = "parcelTest"

        fun newInstance(numberToPut: Int): MainFragment {
            val args = Bundle()
            args.putInt(ARG_NUMBER, numberToPut)
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    private fun initValuesFromArg() {
        val currentArgs = arguments ?: return
        numberToShow = currentArgs.getInt(ARG_NUMBER)
        parcelableUser =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            currentArgs.getParcelable(ARG_USER, ParcelableUser::class.java)
        } else {
            currentArgs.getParcelable(ARG_USER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contentView = inflater.inflate(R.layout.fragment_main, container, false)

        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValuesFromArg()

        initViews(view)
        Timber.e("Current User = $parcelableUser")
    }

    private fun initViews(contentView: View) {
        tvName = contentView.findViewById(R.id.tv_name)
        tvName.text = numberToShow.toString()
    }
}