package logic

import visual.HEIGHT
import visual.WIDTH

const val WEST: Int = 0  // LEFT
const val NORTH: Int = 1 // UP
const val EAST: Int = 2  // RIGHT
const val SOUTH: Int = 3 // DOWN

data class Snake(val position: Position, val direction: Int)

fun Snake.setDirection(direction: Int) : Int {
    require(!(direction > SOUTH || direction < WEST)) { "Invalid direction: $direction" }

    if(this.direction == NORTH && direction == SOUTH) return this.direction
    if(this.direction == SOUTH && direction == NORTH) return this.direction
    if(this.direction == WEST && direction == EAST) return this.direction
    if(this.direction == EAST && direction == WEST) return this.direction

    return direction
}

fun Snake.move() : Position {
    check(this.direction in WEST..SOUTH) {"Invalid direction: $this.direction"}
    val newPos = when(this.direction){
        WEST -> Position(if(this.position.x - 1 < 0) WIDTH + (this.position.x - 1) else (this.position.x - 1) ,this.position.y)
        NORTH -> Position(this.position.x, if(this.position.y - 1 < 0) HEIGHT + (this.position.y - 1) else (this.position.y - 1))
        EAST -> Position(if(this.position.x + 1 >= WIDTH) (this.position.x + 1) - WIDTH else (this.position.x + 1) ,this.position.y)
        SOUTH -> Position(this.position.x, if(this.position.y + 1 >= HEIGHT) (this.position.y + 1) - HEIGHT else (this.position.y + 1))
        else -> this.position
    }
    return newPos
}