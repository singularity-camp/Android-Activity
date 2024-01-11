package kz.singularity.activity1.fragments

import android.content.Context
import android.os.Bundle
import android.text.style.TtsSpan.ARG_NUMBER
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers.Main
import kz.singularity.activity1.R

class MainFragment : Fragment() {

    val TAG = "MainFragment"

    var numberToShow: Int = 0

    companion object {

        const val ARG_NUMBER = "arg_number"

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
    }

    private fun initViews(contentView: View) {
        tvName = contentView.findViewById(R.id.tv_name)
        tvName.text = numberToShow.toString()
    }
}