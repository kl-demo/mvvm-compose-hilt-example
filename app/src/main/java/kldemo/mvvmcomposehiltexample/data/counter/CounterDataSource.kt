package kldemo.mvvmcomposehiltexample.data.counter

interface CounterDataSource {
    fun getNumberOfClicks(): Int
    fun setNumberOfClicks(numberOfClicks: Int)
}