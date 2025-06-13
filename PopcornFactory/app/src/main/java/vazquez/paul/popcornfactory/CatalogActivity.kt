package vazquez.paul.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class CatalogActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter?= null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        cargarPeliculas()
        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)

        var gridPelis: GridView = findViewById(R.id.movies_catalog)
        var gridSeries: GridView = findViewById(R.id.series_catalog)

    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the\n" +
                "midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go\n" +
                "Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to\n" +
                "uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called\n"))
        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader, "AAAA"))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "AAAA"))
        peliculas.add(Pelicula("1917", R.drawable.milnovescientosdiezsiete, R.drawable.milnovescientosdiezsieteheader, "AAAA"))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "AAAA"))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "AAAA"))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "AAAA"))
        series.add(Pelicula("Dr. House", R.drawable.drwho, R.drawable.drwhoheader, "AAAA"))
        series.add(Pelicula("SmallVille", R.drawable.smallville, R.drawable.smallvilleheader, "AAAA"))
    }

    class PeliculaAdapter: BaseAdapter {
        var contexto: Context? = null
        var peliculas = ArrayList<Pelicula>()

        constructor(contexto: Context, peliculas: ArrayList<Pelicula>) {
            this.contexto = contexto
            this.peliculas = peliculas
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula = peliculas[position]
            var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.cell_movie, null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell)
            var title: TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener {
                var intento = Intent(contexto, MovieDetail::class.java)
                intento.putExtra("titulo", pelicula.titulo)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("image", pelicula.image)

                contexto!!.startActivity(intento)
            }

            return vista
        }


    }

}