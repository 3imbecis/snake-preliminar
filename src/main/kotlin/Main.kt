import logic.Game
import pt.isel.canvas.Canvas
import pt.isel.canvas.onStart
import pt.isel.canvas.onFinish
import visual.*
import logic.*

const val KEY_W = 87
const val KEY_A = 65
const val KEY_S = 83
const val KEY_D = 68
const val KEY_UP = 38
const val KEY_DOWN = 40
const val KEY_LEFT = 37
const val KEY_RIGHT = 39

fun main(){

    onStart {

        val canvas = Canvas(WIDTH * GRID_SIZE, HEIGHT * GRID_SIZE, BACKGROUND)
        var game = Game(
            Snake(Position(WIDTH/2, HEIGHT/2), EAST),
            listOf()
        )

        canvas.onTimeProgress(250) { time :Long ->

            // Arrendorar time
            val ctime: Long = 250 * (time / 250)
            // Criar parede a cada 5 segundos
            val createWall = (ctime % 5000 == 0L)

            game = game.tick(createWall)

            canvas.draw(game)
        }

        canvas.onKeyPressed {e -> game = Game(handleInput(e.code, game), game.walls)}

    }

    onFinish {  }

}

fun handleInput(code: Int, game: Game): Snake {
    return Snake(game.snake.position, game.snake.setDirection(when(code){
        KEY_W, KEY_UP    -> NORTH
        KEY_S, KEY_DOWN  -> SOUTH
        KEY_A, KEY_LEFT  -> WEST
        KEY_D, KEY_RIGHT -> EAST
        else -> game.snake.direction
    }))
}


