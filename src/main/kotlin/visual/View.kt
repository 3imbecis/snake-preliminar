package visual

import logic.*
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

const val GRID_SIZE = 32;
const val WIDTH = 20;
const val HEIGHT = 16;
const val BACKGROUND = BLACK;

// Cabeça da cobra
const val SPRITE_HEAD_NORTH = "snake|192,0,64,64";
const val SPRITE_HEAD_SOUTH = "snake|256,64,64,64";
const val SPRITE_HEAD_WEST = "snake|192,64,64,64";
const val SPRITE_HEAD_EAST = "snake|256,0,64,64";

// Corpo dobrado da cobra
const val SPRITE_BODY_NORTH_WEST = "snake|0,64,64,64";
const val SPRITE_BODY_NORTH_EAST = "snake|128,128,64,64";
const val SPRITE_BODY_SOUTH_WEST = "snake|0,0,64,64";
const val SPRITE_BODY_SOUTH_EAST = "snake|128,0,64,64";

// Corpo da cobra
const val SPRITE_BODY_HORIZONTAL = "snake|64,0,64,64";
const val SPRITE_BODY_VERTICAL = "snake|128,64,64,64";

// Cauda da cobra
const val SPRITE_TAIL_NORTH = "snake|192,128,64,64";
const val SPRITE_TAIL_SOUTH = "snake|256,192,64,64";
const val SPRITE_TAIL_WEST = "snake|192,192,64,64";
const val SPRITE_TAIL_EAST = "snake|256,128,64,64";

// Objetos
const val SPRITE_APPLE = "snake|0,192,64,64";
const val SPRITE_BRICK = "bricks";

fun Canvas.draw(game: Game){

    this.erase();

    // Desenhar todas as paredes
    for(wall in game.walls)
        drawSprite(SPRITE_BRICK, wall.x, wall.y);

    // Desenhar a cobra
    val x = game.snake.position.x;
    val y = game.snake.position.y;
    when(game.snake.direction){
        NORTH -> {
            drawSprite(SPRITE_HEAD_NORTH, x, y);
            drawSprite(SPRITE_TAIL_NORTH, x, y + 1);
        }
        SOUTH -> {
            drawSprite(SPRITE_HEAD_SOUTH, x, y);
            drawSprite(SPRITE_TAIL_SOUTH, x, y - 1);
        }
        WEST -> {
            drawSprite(SPRITE_HEAD_WEST, x, y);
            drawSprite(SPRITE_TAIL_WEST, x + 1, y);
        }
        EAST -> {
            drawSprite(SPRITE_HEAD_EAST, x, y);
            drawSprite(SPRITE_TAIL_EAST, x - 1, y);
        }
    }

}

fun Canvas.drawSprite(sprite: String, x: Int, y: Int){
    this.drawImage(sprite, x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
}

fun Canvas.testAllSprites(){

    // Cobra para cima
    drawSprite(SPRITE_HEAD_NORTH, 1, 1);
    drawSprite(SPRITE_BODY_VERTICAL, 1, 2);
    drawSprite(SPRITE_TAIL_NORTH, 1, 3);

    // Cobra para baixo
    drawSprite(SPRITE_TAIL_SOUTH, 3, 1);
    drawSprite(SPRITE_BODY_VERTICAL, 3, 2);
    drawSprite(SPRITE_HEAD_SOUTH, 3, 3);

    // Cobra para a esquerda
    drawSprite(SPRITE_HEAD_WEST, 5, 1);
    drawSprite(SPRITE_BODY_HORIZONTAL, 6, 1);
    drawSprite(SPRITE_TAIL_WEST, 7, 1);

    // Cobra para a direira
    drawSprite(SPRITE_TAIL_EAST, 5, 3);
    drawSprite(SPRITE_BODY_HORIZONTAL, 6, 3);
    drawSprite(SPRITE_HEAD_EAST, 7, 3);

    // Círculo de cobra
    drawSprite(SPRITE_BODY_SOUTH_WEST, 1, 5);
    drawSprite(SPRITE_BODY_SOUTH_EAST, 2, 5);
    drawSprite(SPRITE_BODY_NORTH_WEST, 1, 6);
    drawSprite(SPRITE_BODY_NORTH_EAST, 2, 6);

    // Objetos
    drawSprite(SPRITE_APPLE, 4, 5);
    drawSprite(SPRITE_BRICK, 6, 5);

}