package kz.singularity.activity1.threads

class CustomLooperThread : Thread() {

    var active: Boolean = false

    val actionList: MutableList<Runnable> = mutableListOf()

    fun launch() {
        active = true
        start()
    }

    fun cancel() {
        active = false
    }

    fun doThis(runnable: Runnable) {
        actionList.add(runnable)
    }

    override fun start() {
        super.start()
        while (active) {
            val action = actionList.getOrNull(0) ?: continue
            action.run()
            actionList.removeAt(0)
        }
    }

}