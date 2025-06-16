package vazquez.paul.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button: Button = findViewById<Button>(R.id.boton)
        button.setOnClickListener {
            var intento = Intent(this, CatalogActivity::class.java)
            this.startActivity(intento)
        }
    }
}