package logic

import kotlin.random.Random
import visual.*

data class Game(val snake: Snake, val walls: List<Position>)

fun Game.tick(createWall: Boolean): Game {

    var position = this.snake.position
    var walls = this.walls

    // Mover cobra
    val newPosition = this.snake.move()
    if(!this.checkCollision(newPosition)) position = newPosition

    // Adicionar parede
    if(createWall) {
        walls = this.addWall()
    }

    return Game(
        Snake(position, this.snake.direction),
        walls
    )
}

fun Game.addWall(): List<Position> {

    val rand = Random(System.currentTimeMillis())
    var position: Position

    do{
        position = Position(
            rand.nextInt(0, WIDTH),
            rand.nextInt(0, HEIGHT)
        )
    }while(checkCollision(position) || this.snake.position == position)

    return this.walls + position
}

// Retorna true se a position for igual a uma das paredes
fun Game.checkCollision(position: Position): Boolean {
    for(wall in walls){
        if(wall == position){
            return true
        }
    }
    return false
}