package com.example.dadm_u2p2_cine.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.jvm.Throws

class DBManager(context: Context,
                name: String,
                factory: SQLiteDatabase.CursorFactory,
                version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE horarios (
                id_horario INTEGER PRIMARY KEY NOT NULL, 
                horario TEXT NOT NULL 
            );
            
            CREATE TABLE fechas (
                id_fecha INTEGER PRIMARY KEY NOT NULL, 
                fecha TEXT NOT NULL, 
                id_horario INTEGER NOT NULL, 
                FOREIGN KEY (id_horario) REFERENCES horarios(id_horario) ON UPDATE CASCADE ON DELETE CASCADE
            );
            
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
            
            CREATE TABLE fechaspeliculas (
                id_pelicula INTEGER NOT NULL, 
                id_fecha INTEGER NOT NULL, 
                PRIMARY KEY (id_pelicula, id_fecha), 
                FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE, 
                FOREIGN KEY (id_fecha) REFERENCES fechas(id_fecha) ON UPDATE CASCADE ON DELETE CASCADE
            );
            
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

        db?.let {
            it.execSQL(sql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    @Throws
    fun agregar(pelicula: Pelicula, horarios: List<List<String>>){
        val db = writableDatabase
        var peliculaValues = ContentValues()
        peliculaValues.put("titulo", pelicula.titulo)
        peliculaValues.put("imagen", pelicula.imagen)
        peliculaValues.put("cover", pelicula.cover)
        peliculaValues.put("rating", pelicula.rating)
        peliculaValues.put("director", pelicula.director)
        peliculaValues.put("duracion", pelicula.duracion)
        peliculaValues.put("genero", pelicula.genero)
        peliculaValues.put("sinopsis", pelicula.sinopsis)
        val id = db.insert("peliculas", "", peliculaValues)

        var horariosValues = ContentValues()
    }
}