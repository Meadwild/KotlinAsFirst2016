package lesson7.games

import java.util.*

interface EveryGame {

    var name: String
    var count: Int

    fun greetGamer(gamerName: String): String
    fun sayCount(): String {
        return "Nice!"
    }

    fun testBinaryOperation(x: Int, y: Int, lamb: (x: Int, y: Int) -> Int): Int
    fun testFuncReturn(): (x: Int) -> Int

}

interface Recipie {
    var name: String
    var date: Date

    fun sayCount(): String {
        return "Hay!"
    }
}

class firstClassGame constructor(override var name: String, count: Int, override var date: Date) : EveryGame, Recipie {

    override fun sayCount(): String {

        return super<EveryGame>.sayCount() + super<Recipie>.sayCount()
    }

    override fun testBinaryOperation(x: Int, y: Int, lamb: (x: Int, y: Int) -> Int): Int {

        return lamb(x, y)

    }

    constructor() : this("h", 4, Date()) {
        this.name = "Maggie"
    }

    override fun testFuncReturn(): (x: Int) -> Int {

        /*
        return (fun (x: Int):Int{
            return x*x
        })

*/
        comm@ println("Weather")


        var a = arrayOf(1, 0, 32).forEach(fun(value: Int) {
            if (value == 0) return
            print(value)
        })

        ex@ println("Hi!")

        return { x -> x * x + x; }
    }

    override var count: Int = 0
        get() = field + 1

    init {
        this.count = count
    }

    override fun greetGamer(gamerName: String): String = "Hello in ${name}, dearest ${gamerName}"


}