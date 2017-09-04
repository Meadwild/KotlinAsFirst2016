@file:Suppress("UNUSED_PARAMETER", "unused")
package lesson7.task1

import java.util.*

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E
    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)
    operator fun set(cell: Cell, value: E)
}

/**
 * Простая
 *
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> = if ((height <= 0) || (width <= 0)) throw  IllegalArgumentException("")
else MatrixImpl<E>(height, width, e)
/**
 * Средняя сложность
 *
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(override val height: Int, override val width: Int, e: E) : Matrix<E> {

    private var array: Array<Array<Any>> = Array(height, { index -> Array(width, { it -> e as Any }) })

    override fun get(row: Int, column: Int): E = array[row][column] as E

    override fun get(cell: Cell): E = array[cell.row][cell.column] as E

    override fun set(row: Int, column: Int, value: E) {
        array[row][column] = value as Any
    }

    override fun set(cell: Cell, value: E) {
        array[cell.row][cell.column] = value as Any
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + width
        result = 31 * result + Arrays.hashCode(array)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MatrixImpl<*>

        if (height != other.height) return false
        if (width != other.width) return false

        for (i in 0 until height) {
            for (k in 0 until width) {

                if (array[i][k] != other.array[i][k]) return false

            }
        }

        return true
    }

    override fun toString(): String {
        var stb = StringBuilder()

        stb.append("[")

        for (i in 0 until height) {
            stb.append("${array[i].asList()}")
        }

        stb.append("]")

        return stb.toString()
    }

}

