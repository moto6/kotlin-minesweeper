package minesweeper.model.board

import minesweeper.model.point.Horizontal
import minesweeper.model.point.Vertical

data class BoardLimit(
    val verticalLimit: Vertical,
    val horizontalLimit: Horizontal,
) {
    fun area(): Int {
        return this.verticalLimit.value * this.horizontalLimit.value
    }

    fun verticalRange(): IntRange {
        return this.verticalLimit.range()
    }

    fun horizontalRange(): IntRange {
        return this.horizontalLimit.range()
    }

    fun toVisited(): Array<Array<Boolean>> {
        return Array(horizontalLimit.value + 1) {
            Array(verticalLimit.value + 1) { false }
        }
    }
}

fun Pair<Int, Int>.toBoardLimit(): BoardLimit {
    return BoardLimit(
        Vertical(this.first),
        Horizontal(this.second)
    )
}
