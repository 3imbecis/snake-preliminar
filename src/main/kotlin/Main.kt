import pt.isel.canvas.Canvas
import pt.isel.canvas.onStart
import pt.isel.canvas.onFinish
import visual.*

fun main(){

    onStart {

        val canvas = Canvas(WIDTH * GRID_SIZE, HEIGHT * GRID_SIZE, BACKGROUND);

        canvas.onTimeProgress(250) { time: Long ->

        }

    }

    onFinish {  }

}

