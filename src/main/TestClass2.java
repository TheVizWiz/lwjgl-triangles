package main;

import lib.tvwzEngine.Input;
import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.interfaces.Updateable;
import lib.tvwzEngine.graphics.simple.Circle;
import lib.tvwzEngine.graphics.simple.Point;
import lib.tvwzEngine.graphics.simple.Triangle;
import lib.tvwzEngine.graphics.simple.Vertex;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;


public class TestClass2 extends Renderable implements Updateable {

    private ArrayList<Vertex> vertices;
    private ArrayList<Vector2> directions;
    private ArrayList<ArrayList<Integer>> closestPoints;
    private int width, height;
    public float lowSpeed, highSpeed;

    public TestClass2 (int width, int height, int numPoints) {
        this.width = width;
        this.height = height;
        closestPoints = new ArrayList<>();
        vertices = new ArrayList<>();
        directions = new ArrayList<>();
        for (int i = 0; i < numPoints; i++) {
            for (int j = 0; j < numPoints; j++) {
                float random = (float) Math.random();
                vertices.add(new Vertex(
                        new Vector2(width / (float) numPoints * i, height / (float) numPoints * j),
                        new Vector3(random, random, random)
                ));
                directions.add(new Vector2(
                        (float) Math.random(), (float) Math.random()
                ).normalize());
                closestPoints.add(new ArrayList<>());
            }
        }
    }

    @Override
    public void render (float startDepth) {
        glPointSize(10);
        glBegin(GL_POINTS);
        for (Vertex vertex : vertices) {
            vertex.render(startDepth + depth);
        }
        glEnd();
    }

    @Override
    public void update () {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            v.position =
                    v.position.add(directions.get(i).multiply((highSpeed - lowSpeed) * (float) Math.random() + lowSpeed).multiply(Time.deltaTime()));
            if (v.position.x < 0 || v.position.x > width) v.position.x = v.position.x % width;
            if (v.position.y < 0 || v.position.y > width) v.position.y = v.position.y % width;
        }
    }
}
