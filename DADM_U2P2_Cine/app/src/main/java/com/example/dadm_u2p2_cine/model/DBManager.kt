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
                rating INT NOT NULL
            );
            
            CREATE TABLE fechaspeliculas (
                id_pelicula INTEGER, 
                id_fecha INTEGER, 
                PRIMARY KEY (id_pelicula, id_fecha), 
                FOREIGN KEY (id_pelicula) REFERENCES peliculas(id_pelicula) ON UPDATE CASCADE ON DELETE CASCADE, 
                FOREIGN KEY (id_fecha) REFERENCES fechas(id_fecha) ON UPDATE CASCADE ON DELETE CASCADE
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
        var values = ContentValues()
        values.put()
        db.insert("""INSERT INTO peliculas VALUES (
            |'${pelicula.titulo}', 
            |'${pelicula.imagen}', 
            |'${pelicula.cover}', 
            |${pelicula.rating})""".trimMargin())
        db.close()
        val cursor: Cursor =
    }
}