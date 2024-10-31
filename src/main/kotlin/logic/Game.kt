package logic

import pt.isel.canvas.Canvas
import pt.isel.canvas.KeyEvent
import kotlin.random.Random
import visual.*

data class Game(val snake : Snake, val walls : List<Position>)

fun Game.tick(createWall : Boolean): Game {
    val rand: Random = Random(System.currentTimeMillis());

    // Mover cobra
    val newSnake = Snake(this.snake.move(), this.snake.direction);
    if(createWall) {
        val x = rand.nextInt(0, WIDTH);
        val y = rand.nextInt(0, HEIGHT);
        val newWalls = this.addWall(Position(x, y));
        return Game(newSnake, newWalls);
    }

    return Game(newSnake, this.walls)
}




fun Game.addWall(pos : Position) : List<Position>{
    if(this.walls.size >= 5){
        return listOf(this.walls[1], this.walls[2], this.walls[3], this.walls[4], pos);
    }
    if(this.walls.isEmpty()){
        return listOf(pos);
    }
    return this.walls + pos;
}