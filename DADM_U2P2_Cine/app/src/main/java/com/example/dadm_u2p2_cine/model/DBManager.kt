package com.example.dadm_u2p2_cine.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dadm_u2p2_cine.R
import kotlin.jvm.Throws

class DBManager(val context: Context,
                val name: String,
                val factory: SQLiteDatabase.CursorFactory?,
                val version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val horarios = """
            CREATE TABLE horarios (
        	    id_horario INTEGER PRIMARY KEY  NOT NULL,
        	    horario TEXT NOT NULL
            );
        """.trimIndent()

        val fechas = """
            CREATE TABLE fechas (
        	    id_fecha INTEGER PRIMARY KEY NOT NULL,
        	    fecha TEXT NOT NULL
            );
        """.trimIndent()

        val fechashorarios = """
            CREATE TABLE fechashorarios (
        	    id_calendario INTEGER PRIMARY KEY NOT NULL,
        	    id_fecha INTEGER NOT NULL,
        	    id_horario INTEGER NOT NULL,
        	    FOREIGN KEY (id_fecha) REFERENCES fechas(id_fecha) ON UPDATE CASCADE ON DELETE CASCADE,
        	    FOREIGN KEY (id_horario) REFERENCES horarios(id_horario) ON UPDATE CASCADE ON DELETE CASCADE
            );
        """.trimIndent()

        val peliculas = """
            CREATE TABLE peliculas (
        	    id_pelicula INTEGER PRIMARY KEY NOT NULL,
        	    titulo TEXT NOT NULL,
        	    imagen TEXT NOT NULL,
        	    cover TEXT NOT NULL,
        	    rating INT NOT NULL,
        	    director TEXT NOT NULL,
        	    duracion TEXT NOT NULL,
        	    genero TEXT NOT NULL,
        	    sinopsis TEXT NOT NULL
            );
        """.trimIndent()

        val fechaspeliculas = """
            CREATE TABLE fechaspeliculas (
        	    id_pelicula INTEGER NOT NULL,
        	    id_calendario INTEGER NOT NULL,
        	    PRIMARY KEY (id_pelicula, id_calendario),
        	    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE,
        	    FOREIGN KEY (id_calendario) REFERENCES fechashorarios(id_calendario) ON UPDATE CASCADE ON DELETE CASCADE
            );
        """.trimIndent()

        val compras = """
            CREATE TABLE compras (
        	    id_compra INTEGER PRIMARY KEY NOT NULL,
        	    total REAL NOT NULL,
        	    noAsientos INTEGER,
        	    asientos TEXT,
        	    departamento TEXT NOT NULL,
        	    id_pelicula INTEGER,
        	    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE
            );
        """.trimIndent()

        val pelicula1 = """
            INSERT INTO peliculas VALUES (1,"Godzilla vs Kong",
            "https://upload.wikimedia.org/wikipedia/en/6/63/Godzilla_vs._Kong.png",
            "https://i.blogs.es/3a35be/godzilla-kong/1366_2000.jpeg",
            3.5, "Adam Wingard", "1h 53", "Accion",
            "Kong y sus protectores emprenden un peligroso viaje para encontrar su verdadero hogar. Junto al viaje está Jia, una niña huérfana
            que tiene un vínculo único y poderoso con la poderosa bestia. Sin embargo, pronto se encuentran en el camino de un Godzilla enfurecido
            mientras abre una franja de destrucción en todo el mundo.");
        """.trimIndent()

        val pelicula2 = """
            INSERT INTO peliculas VALUES (2,"John Wick 3: Parabellum",
            "https://upload.wikimedia.org/wikipedia/en/thumb/9/94/John_Wick_Chapter_3_Parabellum.png/220px-John_Wick_Chapter_3_Parabellum.png",
            "https://cinergiaonline.com/wp-content/uploads/2019/05/John-Wick-3-Parabellum.jpg", 4, "Chad Stahelski", "2h 23m", "Accion",
            "John Wick es declarado excomulgado y se otorga una gran recompensa por él después de que asesina a un señor del crimen internacional.
            Se propone buscar ayuda para salvarse de sicarios despiadados y cazarrecompensas.");
        """.trimIndent()

        val pelicula3 = """
            INSERT INTO peliculas VALUES (3,"Avengers Endgame",
            "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/9b/Avenger_Endgame_Poster_Oficial.png/revision/latest/scale-to-width-down/1000?cb=20190326185910&amp;path-prefix=es",
            "https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/04/hipertextual-mejores-trailers-semana-avengers-endgame-rey-leon-godzilla-2-2019907932.jpg?fit=1600%2C900&amp;ssl=1",
            4.0, "Joe Russo, Anthony Russo", "3h 2m", "Accion",
            "Después de que Thanos, un señor de la guerra intergaláctico, desintegra la mitad del universo, los Vengadores deben reunirse y reunirse
            nuevamente para revitalizar a sus aliados derrotados y restablecer el equilibrio.");
        """.trimIndent()

        val pelicula4 = """
            INSERT INTO peliculas VALUES (4,"Venom",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTvGNXRmC76GfZrgM7P_oY0nZqg00bsjC7E5zu4dZBReXiHD_kt",
            "https://arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/IQBLLU2NYNCBZHEAYSAQFEZM2M.jpg", 3.0, "Ruben Fleischer", "2h 20m", "Accion",
            "Mientras intenta derribar a Carlton, el director ejecutivo de Life Foundation, Eddie, un periodista, investiga experimentos de ensayos en humanos.
            Sin saberlo, se fusiona con un alienígena simbiótico con habilidades letales.");
        """.trimIndent()

        db?.let {
            it.execSQL(horarios)
            it.execSQL(fechas)
            it.execSQL(fechashorarios)
            it.execSQL(peliculas)
            it.execSQL(fechaspeliculas)
            it.execSQL(compras)
            it.execSQL(pelicula1)
            it.execSQL(pelicula2)
            it.execSQL(pelicula3)
            it.execSQL(pelicula4)
        }

        /*context.getString(R.string.initDatabase).lines().forEach { linea ->
            db?.let {
                it.execSQL(linea)
            }
        }*/
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    @Throws
    fun getPeliculas(): List<Pelicula> {
        val db = readableDatabase
        val result: MutableList<Pelicula> = mutableListOf()

        val cursor = db.rawQuery("SELECT * FROM peliculas", null)
        while (cursor.moveToNext()) {
            result.add(Pelicula(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getFloat(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(7),
                    null))
        }
        return result
    }

    @Throws
    fun getMovieDates(idPelicula: Int): List<String> {
        val db = readableDatabase
        val result: MutableList<String> = mutableListOf()

        val sql = """
            SELECT fecha FROM peliculas AS p 
            INNER JOIN fechaspeliculas AS fp ON fp.id_pelicula = ${idPelicula} 
            INNER JOIN fechashorarios as fh ON fh.id_calendario = fp.id_calendario 
            INNER JOIN fechas as f ON f.id_fecha = fh.id_fecha 
            WHERE p.id_pelicula = ${idPelicula};
        """.trimIndent()

        val cursor = db.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            result.add(cursor.getString(0))
        }

        return result
    }

    @Throws
    fun getMovieSchedulesOnDate(idPelicula: Int, date: String): List<String> {
        val db = readableDatabase
        val result: MutableList<String> = mutableListOf()

        val sql = """
            SELECT horario FROM peliculas AS p 
            INNER JOIN fechaspeliculas AS fp ON fp.id_pelicula = ${idPelicula} 
            INNER JOIN fechashorarios as fh ON fh.id_calendario = fp.id_calendario 
            INNER JOIN horarios as h ON h.id_horario = fh.id_horario 
            INNER JOIN fechas as f ON f.id_fecha = fh.id_fecha 
            WHERE p.id_pelicula = ${idPelicula} AND f.fecha IN ("${date}");
        """.trimIndent()

        val cursor = db.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            result.add(cursor.getString(0))
        }

        return result
    }

    @Throws
    fun deleteDatabase(context: Context, nombreDB: String){
        context.deleteDatabase(nombreDB)
    }
}