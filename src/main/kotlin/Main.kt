import logic.Game
import pt.isel.canvas.Canvas
import pt.isel.canvas.onStart
import pt.isel.canvas.onFinish
import visual.*
import logic.*
import java.io.PipedOutputStream

fun main(){

    onStart {

        val canvas = Canvas(WIDTH * GRID_SIZE, HEIGHT * GRID_SIZE, BACKGROUND)
        val game = Game(Snake(Position(WIDTH/2, HEIGHT/2), EAST), mutableListOf())

        canvas.onTimeProgress(250) { time :Long ->
            game.tick(time);
            canvas.draw(game);
        }

        canvas.onKeyPressed {e -> game.handleInput(e)}

    }

    onFinish {  }

}

