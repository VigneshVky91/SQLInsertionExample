package com.example.kamal.sqlinsertionexample

class User
{
    var id: Int  = 0
    var name: String = ""
    var age: Int = 0
    constructor()
    {
    }
    constructor(name: String, age: Int)
    {
        this.name = name
        this.age = age
    }
}