package logic
import visual.*

data class Position(var x: Int, var y : Int);

fun Position.setX(x: Int){
    if(x < 0)
        this.x = x + WIDTH;
    else if(x >= WIDTH)
        this.x = x - WIDTH;
    else
        this.x = x;
}

fun Position.setY(y: Int){
    if(y < 0)
        this.y = y + HEIGHT;
    else if(y >= HEIGHT)
        this.y = y - HEIGHT;
    else
        this.y = y;
}




