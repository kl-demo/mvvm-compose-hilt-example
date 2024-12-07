package kldemo.mvvmcomposehiltexample.domain.counter

interface CounterManager {
    fun getNumberOfClicks(): Int
    fun incrementNumberOfClicks()
}