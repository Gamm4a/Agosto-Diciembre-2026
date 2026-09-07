package soto.gamma.miniweather_soto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import soto.gamma.miniweather_soto.domain.Weather
import soto.gamma.miniweather_soto.utilities.WeatherService
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_save_city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ivWeather = findViewById<TextView>(R.id.ivWeather)
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvCity = findViewById<TextView>(R.id.tvCity)
        val imageWeather = findViewById<ImageView>(R.id.idWeather)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvWeather = findViewById<TextView>(R.id.tvWeather)

        tvGreeting.text = "Buenas viejón"
        tvCity.text = "Obregon"
        tvTemperature.text = "49°"
        tvWeather.text = "Tirando lumbre"

        val citySelected = intent.getStringExtra("city") ?: "Ciudad Obregón"
        val time = LocalTime.now().hour

        tvGreeting.text = when (time) {
            in 5..11 -> getString(R.string.good_morning)
            in 12..18 -> getString(R.string.good_afternoon)
            else -> getString(R.string.good_evening)
        }

        tvCity.text = citySelected

        val service = WeatherService(this)
        val info = service.getWeather(citySelected)

        tvTemperature.text = "${info.temperature}°"
        tvWeather.text = info.weather

        when (info.weather) {
            getString(R.string.snowy) -> imageWeather.setImageResource(R.drawable.ic_snowy)
            getString(R.string.windy) -> imageWeather.setImageResource(R.drawable.ic_windy)
            getString(R.string.stormy) -> imageWeather.setImageResource(R.drawable.ic_stormy)
            getString(R.string.rainy) -> imageWeather.setImageResource(R.drawable.ic_rainy)
            getString(R.string.clody) -> imageWeather.setImageResource(R.drawable.ic_cloudy)
            getString(R.string.sunny) -> imageWeather.setImageResource(R.drawable.ic_sunny)
        }
    }
}