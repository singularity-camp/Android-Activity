package kz.singularity.activity1.threads

import android.os.AsyncTask
import android.widget.TextView
import timber.log.Timber

internal class MyTask(private val textView: TextView) : AsyncTask<Any?, Any?, Long>() {

    override fun onPreExecute() {
        super.onPreExecute()
        textView.text = "Started calculation"
    }

    override fun onProgressUpdate(vararg values: Any?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Long) {
        super.onPostExecute(result)
        textView.text = "$result"
    }

    override fun doInBackground(vararg params: Any?): Long? {
        var i = 0
        var sum = 0L
        for (i in 1..Int.MAX_VALUE) {
            sum += i
        }
        Timber.e("Sum is = $sum")

        return sum
    }
}