package ObserverPattern

/**
 * data의 measurementsChanged()가 바뀔때마다 이를 보여줄 3개의 디스플레이에
 * 매번 업데이트를 해야한다.
 *
 * 다른 디스플레이를 추가 제거하려면 프로그램을 수정해야함.
 * update부분도 바뀔 수 있으므로 캡슐화 해야한다.
 */
class ProblemWeatherData {
    lateinit var conditionDisplay: ProblemConditionDisplay
    lateinit var statisticsDisplay: ProblemStatisticsDisplay
    lateinit var forecastDisplay: ProblemForecastDisplay

    private fun getTemperature(): Float = 0.0f

    private fun getHumidity(): Float = 0.0f

    private fun getPressure(): Float = 0.0f

    public fun measurementsChanged() {
        val temp = getTemperature()
        val humidity = getHumidity()
        val pressure = getPressure()

        conditionDisplay.update(temp, humidity, pressure)
        statisticsDisplay.update(temp, humidity, pressure)
        forecastDisplay.update(temp, humidity, pressure)
    }
}

interface ProblemDisplay {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

class ProblemConditionDisplay: ProblemDisplay {
    override fun update(temp: Float, humidity: Float, pressure: Float) {
        TODO("Not yet implemented")
    }
}

class ProblemStatisticsDisplay: ProblemDisplay {
    override fun update(temp: Float, humidity: Float, pressure: Float) {
        TODO("Not yet implemented")
    }
}

class ProblemForecastDisplay: ProblemDisplay {
    override fun update(temp: Float, humidity: Float, pressure: Float) {
        TODO("Not yet implemented")
    }
}