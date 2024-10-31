package logic

import pt.isel.canvas.Canvas
import pt.isel.canvas.KeyEvent
import kotlin.random.Random
import visual.*

data class Game(val snake : Snake, val walls : MutableList<Position>)

fun Game.tick(time: Long) {
    val rand: Random = Random(System.currentTimeMillis());

    // Mover cobra
    snake.move();

    // Adicionar parede no 5º segundo
    if(time % 5000 == 0L){
        val x = rand.nextInt(0, WIDTH);
        val y = rand.nextInt(0, HEIGHT);
        this.addWall(Position(x,y));
    }
    println(snake.position);
    println(snake.direction);
    println(walls);
    println(time);
}

const val KEY_W = 87;
const val KEY_A = 65;
const val KEY_S = 83;
const val KEY_D = 68;
const val KEY_UP = 38;
const val KEY_DOWN = 40;
const val KEY_LEFT = 37;
const val KEY_RIGHT = 39;

fun Game.handleInput(e: KeyEvent){
    this.snake.setDirection(when(e.code){
        KEY_W, KEY_UP    -> NORTH;
        KEY_S, KEY_DOWN  -> SOUTH;
        KEY_A, KEY_LEFT  -> WEST;
        KEY_D, KEY_RIGHT -> EAST;
        else -> this.snake.direction;
    });
}

fun Game.addWall(pos : Position){
    this.walls.add(pos);
    while(this.walls.size > 5){
        this.walls.removeAt(0);
    }
}