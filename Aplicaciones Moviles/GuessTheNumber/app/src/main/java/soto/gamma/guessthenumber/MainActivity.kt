package soto.gamma.guessthenumber

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import soto.gamma.guessthenumber.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue= 0
    var maxValue= 100
    var num: Int =0
    var won= false


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessing: TextView = findViewById<TextView>(R.id.guessings)

        val down: Button = findViewById<Button>(R.id.down)
        val up: Button = findViewById<Button>(R.id.up)
        val generate: Button = findViewById<Button>(R.id.generate)
        val guessed: Button = findViewById<Button>(R.id.guessed)

        generate.setOnClickListener {
            num= Random.nextInt(minValue,maxValue)
            guessing.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility =View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if (checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede serrrrrr AAHHHH GANASTE")
            }
        }

        down.setOnClickListener {
            maxValue = num
            if (checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede serrrrrr AAHHHH GANASTE")
            }
        }

        guessed.setOnClickListener {
            if (won){
                guessing.setText("Adiviné, tu numero es el"+num)
                guessed.setText("Volver a jugar")
                won= true
            }else{
                generate.visibility = View.VISIBLE
                guessing.setText("Tap on generate to start")
                guessed.visibility= View.GONE
                resetValue()
            }

        }



    }

    fun resetValue(){
        minValue=0
        maxValue=100
        num=0
        won=false
    }



    fun checkingLimits(): Boolean{
        return minValue !=maxValue
    }

}