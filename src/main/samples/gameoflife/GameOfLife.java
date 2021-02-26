package main.samples.gameoflife;

import lib.tvwzEngine.Window;
import lib.tvwzEngine.graphics.interfaces.RenderableBase;
import lib.tvwzEngine.graphics.interfaces.Updatable;
import lib.tvwzEngine.math.Vector2;

import java.util.Arrays;

public class GameOfLife extends RenderableBase implements Updatable {


    private GOLSquare[][] squares;
    private Window window;
    private boolean[][] nextMatrix;
    private boolean isRunning;

    public GameOfLife (int width, int height, int numSquares, Window window) {
        squares = new GOLSquare[numSquares][numSquares];
        nextMatrix = new boolean[numSquares][numSquares];
        this.window = window;
        float sWidth = (float) width / numSquares;
        float sHeight = (float) height / numSquares;

        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {
                squares[i][j] = new GOLSquare(sWidth * i, sHeight * j, sWidth, sHeight);
//                squares[i][j].quad.setColor(Vector3.lerp(Vector3.white(), Vector3.black(),
//                        (i + j + 2) / 2f / numSquares));
                squares[i][j].quad.setRenderOutline(true);
//                squares[i][j].quad.setRenderFill(false);
                squares[i][j].quad.setOutlineWidth(1f);
            }
        }

        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {
                nextMatrix[i][j] = false;
            }
        }
        pause();
    }



    public void checkSquares () {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                int counter = 0;
                int xFirst = -1, yFirst = -1, xLast = 1, yLast = 1;
                if (i < 1) xFirst = 0;
                if (j < 1) yFirst = 0;
                if (i == squares.length - 1) xLast = 0;
                if (j == squares.length - 1) yLast = 0;
                for (int k = xFirst + i; k <= xLast + i; k++) {
                    for (int l = yFirst + j; l <= yLast + j; l++) {
                        if (squares[k][l].isOccupied() && !(k == i && l== j)) counter++;
                    }
                }

                if (squares[i][j].isOccupied()) {
                    nextMatrix[i][j] = counter >= 2 && counter <= 3;

                } else {
                    nextMatrix[i][j] = counter == 3;
                }
            }
        }
    }


    public void switchSquares () {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (nextMatrix[i][j]) squares[i][j].occupy();
                else squares[i][j].unOccupy();
            }
        }

        for (boolean[] matrix : nextMatrix) {
            Arrays.fill(matrix, false);
        }
    }

    @Override
    public void render (float startDepth) {
        for (GOLSquare[] squares1 : squares) {
            for (GOLSquare square : squares1) {
                square.render(startDepth + depth);
            }
        }
    }

    @Override
    public void update () {
        if (!isRunning) return;

        checkSquares();
        switchSquares();
//        isRunning = false;
    }

    public void updateSingleFrame () {
        if (isRunning) return;
        checkSquares();
        switchSquares();
    }

    public void play () {
        isRunning = true;
        window.setTitle("Game Of Life Simulation - Playing");
    }

    public void pause () {
        isRunning = false;
        window.setTitle("Game Of Life Simulation - Paused");
    }

    public boolean isRunning () {
        return isRunning;
    }

    public void clickSquare (Vector2 pos) {
        if (isRunning) return;

        pos = window.startScaleNormalizedPoint(pos);
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j].checkCollision(pos)) squares[i][j].switchOccupy();
            }
        }
    }
}
