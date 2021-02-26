package main;

import lib.tvwzEngine.input.Input;
import lib.tvwzEngine.graphics.interfaces.RenderableBase;
import lib.tvwzEngine.graphics.interfaces.Updatable;
import lib.tvwzEngine.graphics.simple.Line;
import lib.tvwzEngine.graphics.simple.Point;
import lib.tvwzEngine.graphics.simple.Vertex;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFW;

public class TestClass extends RenderableBase implements Updatable {


    public Point[][] points;
    public float speed = 100f;
    private Vertex rotateAroundPoint;


    public TestClass (int width, int height, int numPoints) {
        numPoints = 1;
        points = new Point[numPoints][numPoints];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point();
                points[i][j].pos = new Vertex(
                        new Vector2(
                                (i + 1) * ((float) width / (numPoints + 1)),
                                (j + 1) * ((float) height / (numPoints + 1))
                        ),
                        new Vector3((i + 1) * ((float) width / (numPoints + 1)) / width,
                                (j + 1) * ((float) height / (numPoints + 1)) / height
                                , 1)
                );
                points[i][j].size = 20;
            }
        }
        rotateAroundPoint = new Vertex();
        rotateAroundPoint.position = new Vector2(width / 2f, height / 2f);
    }

    @Override
    public void render (float startDepth) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j].render(startDepth + depth);
                Vertex midVertex = new Vertex(
                        new Vector2(points[i][j].pos.position.x, rotateAroundPoint.position.y), Vector3.cyan()
                );
                Line.drawLine(rotateAroundPoint, midVertex, 5,startDepth +  depth);
                Line.drawLine(midVertex, points[i][j].pos, 5, startDepth + depth);
            }
        }
    }

    @Override
    public void update () {

        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_1)) {
            rotateAroundPoint.position = Input.getMousePos();
        }

        for (Point[] pointArray : points) {
            for (Point point : pointArray) {

                if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE) )
                    point.pos.position = point.pos.position.rotateAround(rotateAroundPoint.position, speed * Time.deltaTime());

            }
        }
    }
}
