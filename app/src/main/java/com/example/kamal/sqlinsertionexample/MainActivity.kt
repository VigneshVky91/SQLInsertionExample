package com.example.kamal.sqlinsertionexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var context = this
        var db = DatabaseHandler(context)
        savedata.setOnClickListener({
            var user = User(etvName.text.toString(), etvAge.text.toString().toInt())
            db.insertData(user)
        })

        readdata.setOnClickListener({
            var userlist = db.readData()
            tv.text = ""
            for(i in 0..userlist.size-1)
            {
                tv.append(userlist.get(i).id.toString()+" "+
                userlist.get(i).name+" "+
                userlist.get(i).age+"\n")
            }
        })
    }
}
