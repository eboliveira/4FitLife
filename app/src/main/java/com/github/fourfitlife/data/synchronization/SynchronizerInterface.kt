package com.github.fourfitlife.data.synchronization

interface SynchronizerInterface {
    companion object {
        private val watchers = mutableSetOf<SynchronizerInterface>()
        var loading = true

        fun subscribe(k: SynchronizerInterface) {
            watchers.add(k)
        }

        fun unsubscribe(k: SynchronizerInterface) {
            watchers.remove(k)
        }

        fun notify(success: Boolean) {
            loading = false
            watchers.forEach { watcher ->
                watcher.onResult(success)
            }
        }
    }

    fun onResult(success: Boolean)
}
