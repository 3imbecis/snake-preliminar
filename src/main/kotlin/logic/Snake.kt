package logic

const val WEST: Int = 0  // LEFT
const val NORTH: Int = 1 // UP
const val EAST: Int = 2  // RIGHT
const val SOUTH: Int = 3 // DOWN

data class Snake(val position: Position, var direction: Int, )

fun Snake.setDirection(direction: Int) {
    if(direction > SOUTH || direction < WEST) {
        System.err.println("Invalid direction: $direction \n")
        return
    }
    this.direction = direction
}

