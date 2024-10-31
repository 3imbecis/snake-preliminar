package logic

import kotlin.random.Random
import visual.*

data class Game(val snake : Snake, val walls : List<Position>)

fun Game.tick(createWall : Boolean): Game {
    val rand = Random(System.currentTimeMillis())

    // Mover cobra
    val currPos = this.snake.position
    val newSnake = Snake(this.snake.move(), this.snake.direction)
    if(createWall) {
        val x = rand.nextInt(0, WIDTH)
        val y = rand.nextInt(0, HEIGHT)
        val newWalls = this.addWall(Position(x, y))
        return if(checkCollision(newSnake, newWalls)) Game(Snake(currPos, this.snake.direction), newWalls) else Game(newSnake, newWalls)
    }

    return if(checkCollision(newSnake, this.walls)) Game(Snake(currPos, this.snake.direction), this.walls) else Game(newSnake, this.walls)
}




fun Game.addWall(pos : Position) : List<Position>{
    if(this.walls.size >= 5){
        return listOf(this.walls[1], this.walls[2], this.walls[3], this.walls[4], pos)
    }
    if(this.walls.isEmpty()){
        return listOf(pos)
    }
    return this.walls + pos
}

fun checkCollision(collsnake : Snake, walls: List<Position>) : Boolean {
    for(wall in walls) {
        if (collsnake.position.x == wall.x && collsnake.position.y == wall.y) {
            return true
        }
    }
    return false
}