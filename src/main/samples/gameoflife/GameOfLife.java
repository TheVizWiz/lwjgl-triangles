package main.samples.gameoflife;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.interfaces.Updateable;
import lib.tvwzEngine.graphics.simple.Point;

public class GameOfLife extends Renderable implements Updateable {


    private Point[][] points;

    public GameOfLife (int width, int height, int numSquares) {
        points = new Point[numSquares][numSquares];
    }



    public void checkSquares () {

    }

    public void replace () {

    }

    @Override
    public void render (float startDepth) {
        for (Point[] points1 : points) {
            for (Point point : points1) {
                point.render(startDepth + depth);
            }
        }
    }

    @Override
    public void update () {

    }
}
