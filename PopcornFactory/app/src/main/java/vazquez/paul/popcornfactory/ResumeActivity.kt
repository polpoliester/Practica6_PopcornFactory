package vazquez.paul.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        val bundle = intent.extras

        if (bundle != null) {
            val cliente = bundle.getString("cliente_nombre", "")
            val asiento = bundle.getString("cliente_asiento", "")
            val pelicula = bundle.getString("pelicula", "")

            // Mostrar los datos en los TextView correspondientes
            findViewById<TextView>(R.id.tv_detalle_cliente).text = cliente
            findViewById<TextView>(R.id.tv_detalle_asiento).text = asiento
            findViewById<TextView>(R.id.tv_detalle_pelicula).text = pelicula

        }
    }
}