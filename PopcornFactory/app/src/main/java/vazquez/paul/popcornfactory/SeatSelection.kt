package vazquez.paul.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {
    private var selectedSeat: String = ""
    private lateinit var movieName: String
    private lateinit var cliente: String
    private var movieImage: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        // Obtener datos de la película
        val title: TextView = findViewById(R.id.titleSeats)
        val bundle = intent.extras

        if (bundle != null) {
            movieName = bundle.getString("name") ?: ""
            movieImage = bundle.getInt("id", -1)
            cliente = bundle.getString("cliente_nombre") ?: ""
            title.text = movieName
        }

        // Configurar RadioGroups
        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        // Listener para los asientos
        val seatSelectionListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                val radioButton = findViewById<RadioButton>(checkedId)
                selectedSeat = radioButton.text.toString()

                // Desmarcar otros grupos
                when (group.id) {
                    R.id.row1 -> { row2.clearCheck(); row3.clearCheck(); row4.clearCheck() }
                    R.id.row2 -> { row1.clearCheck(); row3.clearCheck(); row4.clearCheck() }
                    R.id.row3 -> { row1.clearCheck(); row2.clearCheck(); row4.clearCheck() }
                    R.id.row4 -> { row1.clearCheck(); row2.clearCheck(); row3.clearCheck() }
                }
            }
        }

        row1.setOnCheckedChangeListener(seatSelectionListener)
        row2.setOnCheckedChangeListener(seatSelectionListener)
        row3.setOnCheckedChangeListener(seatSelectionListener)
        row4.setOnCheckedChangeListener(seatSelectionListener)

        // Botón de confirmación
        val confirm: Button = findViewById(R.id.confirm)
        confirm.setOnClickListener {
            if (selectedSeat.isEmpty()) {
                Toast.makeText(this, "Please select a seat", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResumeActivity::class.java).apply {
                putExtra("cliente_nombre", cliente)
                putExtra("cliente_asiento", selectedSeat)
                putExtra("pelicula", movieName)
                putExtra("pelicula_imagen", movieImage)
            }

            startActivity(intent)
            Toast.makeText(this, "Enjoy the movie!", Toast.LENGTH_LONG).show()
        }
    }
}
