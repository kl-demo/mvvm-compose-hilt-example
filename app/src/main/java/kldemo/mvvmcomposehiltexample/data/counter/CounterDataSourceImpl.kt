package kldemo.mvvmcomposehiltexample.data.counter

class CounterDataSourceImpl : CounterDataSource {
    private var numberOfClicks: Int = 0

    override fun getNumberOfClicks(): Int = numberOfClicks

    override fun setNumberOfClicks(numberOfClicks: Int) {
        this.numberOfClicks = numberOfClicks
    }
}