package soto.gamma.holamundo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val greetingLabel: TextView = findViewById<TextView>(R.id.tv_greetring)
        val textoEjemplo: TextView = findViewById<TextView>(R.id.textEjemploAbajo)

        val nameField: EditText = findViewById<EditText>(R.id.et_name)
        val buttonNext: Button = findViewById<Button>(R.id.btn_send)

        buttonNext.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("name", nameField.text)
            }

            startActivity(intent)
        }




    }
}