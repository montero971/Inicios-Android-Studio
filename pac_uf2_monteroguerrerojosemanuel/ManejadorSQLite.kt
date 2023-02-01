package com.example.pac_uf2_monteroguerrerojosemanuel

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper


class ManejadorSQLite (context: Context, name: String, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version){

   override fun onCreate(db: SQLiteDatabase) {
       db.execSQL("create table stock (nombre String primary key, cantidad int, precio int)")
   }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}
