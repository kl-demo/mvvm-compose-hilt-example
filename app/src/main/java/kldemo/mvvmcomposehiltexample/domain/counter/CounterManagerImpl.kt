package kldemo.mvvmcomposehiltexample.domain.counter

import android.util.Log
import kldemo.mvvmcomposehiltexample.data.counter.CounterDataSource
import javax.inject.Inject

class CounterManagerImpl @Inject constructor(private val counterDataSource: CounterDataSource)  : CounterManager {
    init {
        Log.i("TEST2", "init  CounterManagerImpl")
    }

    override fun getNumberOfClicks(): Int = counterDataSource.getNumberOfClicks()

    override fun incrementNumberOfClicks() {
        counterDataSource.setNumberOfClicks(counterDataSource.getNumberOfClicks()+1)
    }
}