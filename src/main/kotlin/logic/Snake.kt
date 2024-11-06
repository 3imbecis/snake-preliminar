package logic

import visual.HEIGHT
import visual.WIDTH

const val WEST: Int = 0  // LEFT
const val NORTH: Int = 1 // UP
const val EAST: Int = 2  // RIGHT
const val SOUTH: Int = 3 // DOWN

data class Snake(val position: Position, val direction: Int)

// Validar nova direção pedida pelo utilizador
fun Snake.setDirection(direction: Int): Int {
    require(direction in WEST..SOUTH) { "Invalid direction: $direction" }

    // Não mudar direção quando o jogador tenta fazer um 180
    if(this.direction == NORTH && direction == SOUTH) return this.direction
    if(this.direction == SOUTH && direction == NORTH) return this.direction
    if(this.direction == WEST && direction == EAST) return this.direction
    if(this.direction == EAST && direction == WEST) return this.direction

    return direction
}

fun Snake.move(): Position {

    var x = this.position.x
    var y = this.position.y

    when(this.direction){
        WEST -> {
            x--
            if(x < 0){
                x += WIDTH
            }
        }
        NORTH -> {
            y--
            if(y < 0){
                y += HEIGHT
            }
        }
        EAST -> {
            x++
            if(x >= WIDTH){
                x -= WIDTH
            }
        }
        SOUTH -> {
            y++
            if(y >= HEIGHT){
                y -= HEIGHT
            }
        }
    }

    return Position(x, y)
}