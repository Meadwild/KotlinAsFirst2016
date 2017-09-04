package lesson7.games

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class firstClassGameTest {

    @Test
    fun greetGamer() {

        var justGame = firstClassGame("chess", 0, Date())

        Assertions.assertEquals("Hello in chess, dearest John", justGame.greetGamer("John"))

        justGame.count = 5

        justGame.testFuncReturn()

        println(justGame.sayCount())

        Assertions.assertEquals(6, justGame.count)


    }


}