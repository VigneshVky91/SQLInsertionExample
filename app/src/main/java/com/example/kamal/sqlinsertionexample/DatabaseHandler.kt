package com.example.kamal.sqlinsertionexample

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.ArrayList

val DATABASE_NAME = "MyDb"
val TABLE_NAME = "users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        val createTable = "CREATE TABLE "+ TABLE_NAME+ " ("+ COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_NAME+
                " VARCHAR(256), "+ COL_AGE+
                " INTEGER)";

        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun insertData(user:User)
    {
        var db = writableDatabase
        var cv = ContentValues()

        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE, user.age)

        db.insert(TABLE_NAME,null,cv)
    }
    fun readData():ArrayList<User>
    {
        var userlist = ArrayList<User>()
        var db = readableDatabase

        var query = "select * from "+ TABLE_NAME

        var result = db.rawQuery(query,null)

        result.moveToFirst()
        do
        {
            var user = User()
            user.id = result.getString(0).toString().toInt()
            user.name = result.getString(1)
            user.age = result.getString(2).toString().toInt()

            userlist.add(user)
        }while(result.moveToNext())
       // result.close()
        //db.close()
        return userlist
    }
}