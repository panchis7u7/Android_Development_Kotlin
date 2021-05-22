package com.example.dadm_u2p2_cine.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(context: Context,
                name: String,
                factory: SQLiteDatabase.CursorFactory,
                version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE compras (
            id_pelicula INTEGER PRIMARY KEY NOT NULL, 
            asientos TEXT NOT NULL, 
            fecha TEXT NOT NULL, 
            hora TEXT NOT NULL, 
            precio INT NOT NULL
            )""".trimIndent()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}