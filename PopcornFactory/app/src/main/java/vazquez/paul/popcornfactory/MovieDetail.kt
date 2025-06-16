package vazquez.paul.popcornfactory

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val detalle = intent.extras

        if (detalle != null) {
            findViewById<TextView>(R.id.movie_title_detail).text = detalle.getString("titulo")
            findViewById<TextView>(R.id.movie_desc).text = detalle.getString("sinopsis")
            findViewById<TextView>(R.id.movie_desc).movementMethod = ScrollingMovementMethod()
            findViewById<ImageView>(R.id.image_movie_detail).setImageResource(detalle.getInt("header"))
        }
    }
}