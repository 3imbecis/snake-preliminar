package logic

const val WEST: Int = 0  // LEFT
const val NORTH: Int = 1 // UP
const val EAST: Int = 2  // RIGHT
const val SOUTH: Int = 3 // DOWN

data class Snake(val position: Position, var direction: Int);

fun Snake.setDirection(direction: Int) {
    require(!(direction > SOUTH || direction < WEST)) { "Invalid direction: $direction" }

    if(this.direction == NORTH && direction == SOUTH) return;
    if(this.direction == SOUTH && direction == NORTH) return;
    if(this.direction == WEST && direction == EAST) return;
    if(this.direction == EAST && direction == WEST) return;

    this.direction = direction;
}

fun Snake.move() {
    check(this.direction in WEST..SOUTH) {"Invalid direction: $this.direction"};
    when(this.direction){
        WEST -> this.position.setX(this.position.x - 1);
        NORTH -> this.position.setY(this.position.y - 1);
        EAST -> this.position.setX(this.position.x + 1);
        SOUTH -> this.position.setY(this.position.y + 1);
    }
}