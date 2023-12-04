package kz.singularity.activity1.fragments

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kz.singularity.activity1.R

class CustomDialogFragment : DialogFragment() {

    private var onDismissListener: OnDismissListener? = null

    private companion object {
        private const val TAG = "CustomDialogFragment"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "OnAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "onCreateView")
        val view = layoutInflater.inflate(R.layout.dialog_custom, null, false)
        val tvTitle: TextView = view.findViewById(R.id.title)
        val tvSubtitle: TextView = view.findViewById(R.id.subtitle)
        val btnClose: TextView = view.findViewById(R.id.closeButton)

        tvTitle.text = "Custom Title"
        tvSubtitle.text = "Custom Subtitle"

        btnClose.setOnClickListener { dismiss() }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        Log.e(TAG, "OnCreateDialog")
        val view = layoutInflater.inflate(R.layout.dialog_custom, null, false)
        val tvTitle: TextView = view.findViewById(R.id.title)
        val tvSubtitle: TextView = view.findViewById(R.id.subtitle)
        val btnClose: TextView = view.findViewById(R.id.closeButton)

        tvTitle.text = "Custom Title"
        tvSubtitle.text = "Custom Subtitle"
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(view)
            .create()
        isCancelable = false
        btnClose.setOnClickListener { dismiss() }
        return alertDialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissListener?.onDismissHappened()
        Log.e(TAG, "onDismiss")
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.e(TAG, "onCancel")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "onDetach")
    }

    fun setOnDismissListener(onDismissListener: OnDismissListener) {
        this.onDismissListener = onDismissListener
    }
}

fun interface OnDismissListener {
    fun onDismissHappened()
}