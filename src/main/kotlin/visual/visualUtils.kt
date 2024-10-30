package visual

import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

const val GRID_SIZE = 32;
const val WIDTH = 20;
const val HEIGHT = 16;
const val BACKGROUND = BLACK;

// 1 - 64
// 2 - 128
// 3 - 192
// 4 - 256

const val SPRITE_HEAD_UP = "snake|192,0,64,64";
const val SPRITE_HEAD_DOWN = "snake|256,64,64,64";
const val SPRITE_HEAD_LEFT = "snake|192,64,64,64";
const val SPRITE_HEAD_RIGHT = "snake|256,0,64,64";

// body curving throught different directions
const val SPRITE_BODY_UP_LEFT = "snake|0,64,64,64";
const val SPRITE_BODY_UP_RIGHT = "snake|128,128,64,64";
const val SPRITE_BODY_DOWN_LEFT = "snake|0,0,64,64";
const val SPRITE_BODY_DOWN_RIGHT = "snake|128,0,64,64";

// straight vertically body and horizontally
const val SPRITE_BODY_HORIZONTAL = "snake|64,0,64,64";
const val SPRITE_BODY_VERTICAL = "snake|128,64,64,64";

const val SPRITE_TAIL_UP = "snake|192,128,64,64";
const val SPRITE_TAIL_DOWN = "snake|256,192,64,64";
const val SPRITE_TAIL_LEFT = "snake|192,192,64,64";
const val SPRITE_TAIL_RIGHT = "snake|256,128,64,64";

const val SPRITE_APPLE = "snake|0,192,64,64";

const val SPRITE_BRICK = "bricks";

fun drawSprite(canvas: Canvas, sprite: String, x: Int, y: Int){
    canvas.drawImage(sprite, x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
}

fun testAllSprites(canvas: Canvas){

    drawSprite(canvas, SPRITE_HEAD_UP, 1, 1);
    drawSprite(canvas, SPRITE_BODY_VERTICAL, 1, 2);
    drawSprite(canvas, SPRITE_TAIL_UP, 1, 3);

    drawSprite(canvas, SPRITE_TAIL_DOWN, 3, 1);
    drawSprite(canvas, SPRITE_BODY_VERTICAL, 3, 2);
    drawSprite(canvas, SPRITE_HEAD_DOWN, 3, 3);

    drawSprite(canvas, SPRITE_HEAD_LEFT, 5, 1);
    drawSprite(canvas, SPRITE_BODY_HORIZONTAL, 6, 1);
    drawSprite(canvas, SPRITE_TAIL_LEFT, 7, 1);

    drawSprite(canvas, SPRITE_TAIL_RIGHT, 5, 3);
    drawSprite(canvas, SPRITE_BODY_HORIZONTAL, 6, 3);
    drawSprite(canvas, SPRITE_HEAD_RIGHT, 7, 3);

    drawSprite(canvas, SPRITE_BODY_DOWN_LEFT, 1, 5);
    drawSprite(canvas, SPRITE_BODY_DOWN_RIGHT, 2, 5);
    drawSprite(canvas, SPRITE_BODY_UP_LEFT, 1, 6);
    drawSprite(canvas, SPRITE_BODY_UP_RIGHT, 2, 6);

    drawSprite(canvas, SPRITE_APPLE, 4, 5);
    drawSprite(canvas, SPRITE_BRICK, 6, 5);

}