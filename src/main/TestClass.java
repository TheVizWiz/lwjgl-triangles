package main;

import lib.tvwzEngine.Input;
import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Updateable;
import lib.tvwzEngine.graphics.simple.Point;
import lib.tvwzEngine.graphics.simple.Vertex;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFW;

public class TestClass extends Renderable implements Updateable {


    public Point[][] points;
    public float speed = 500f;
    private Vector2 rotateAroundPoint;


    public TestClass (int width, int height, int numPoints) {
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
        rotateAroundPoint = new Vector2(width / 2f, height / 2f);
    }

    @Override
    public void render (float startDepth) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j].render(startDepth);
            }
        }
    }

    @Override
    public void update () {

        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_1)) {
            rotateAroundPoint = Input.getMousePos();
        }

        for (Point[] pointArray : points) {
            for (Point point : pointArray) {
//                Vector2 angle =
//                        Vector2.fromDegrees((float) Math.random() * 360).multiply(speed * Time.deltaTime());
//                point.pos.position = point.pos.position.add(angle);
                if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE) )
                point.pos.position = point.pos.position.rotateAround(rotateAroundPoint, speed * Time.deltaTime());

            }
        }
    }
}
