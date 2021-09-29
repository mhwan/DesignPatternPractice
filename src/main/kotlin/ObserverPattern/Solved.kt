package ObserverPattern

fun main() {
    val weatherData = WeatherData()
    val currentConditionDisplay = CurrentConditionDisplay(weatherData)
    val statisticsDisplay = StatisticDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)

    weatherData.setMeasurements(80.0f, 65.0f, 32.5f)
    weatherData.setMeasurements(88.0f, 60.0f, 39.5f)
    weatherData.setMeasurements(72.0f, 50.0f, 48.1f)
}

/*
주체가 될 클래스 WeatherData는 Subject라는 주제 클래스를 상속받음
Subject클래스에서는 객체에서 옵저버를 등록하거나 해제하는 역할, notify는 하위 클래스에서 실제 구상 클래스에서 구현하도록 함

해당 데이터를 관찰할 클래스는 Observer인터페이스만 구현하면 됨.
주체의 상태가 바뀌면 모든 Observer의 update메소드가 호출되서 업데이트된 데이터를 연락받을 수 있음

옵저버 패턴 : 주제와 옵저버 객체간의 의존성을 느슨하게 만듬
주제 클래스는 오직 옵저버가 해당 옵저버 인터페이스를 구현하는 것만 알기 때문에

-> 언제든지 옵저버를 새로 추가, 제거 가능 (새로 옵저버를 추가할 때도 주제를 변경할 필요가 전혀 없음)
-> 주제와 옵저버는 서로 독립적으로 재사용 가능함
-> 주제나 옵저버가 바뀌어도 서로한테 영향을 미치지 않음
 */
abstract class Subject {
    protected val observers: MutableList<Observer> = mutableListOf()

    fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    abstract fun notifyObservers()
}

class WeatherData: Subject() {
    var temperature = 0.0f
        private set
    var humidity = 0.0f
        private set
    var pressure = 0.0f
        private set

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }
}

interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}

class CurrentConditionDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature = 0.0f
    private var humidity = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("current conditions : $temperature, $humidity")
    }
}

class StatisticDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature = 0.0f
    private var humidity = 0.0f
    private var pressure = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("statistic conditions : $temperature, $humidity, $pressure")
    }
}

class ForecastDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature = 0.0f
    private var humidity = 0.0f
    private var pressure = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("forecast conditions : $temperature, $humidity, $pressure")
    }
}