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
                val factory: SQLiteDatabase.CursorFactory,
                val version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            it.execSQL(context.getString(R.string.initDatabase))
        }
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
}