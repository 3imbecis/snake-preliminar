package logic
import visual.*

data class Position(var x: Int, var y : Int)

fun Position.setX(x:Int){
    var newX = x;
    newX = if(x < 0) (WIDTH  + x) else newX
    newX = if(x >= WIDTH) (x - WIDTH) else newX;
    this.x = newX;
}

fun Position.setY(y:Int){
    var newY = y;
    newY = if(y < 0) (HEIGHT  + y) else newY
    newY = if(y >= HEIGHT) (y - HEIGHT) else newY;
    this.y = newY;
}




