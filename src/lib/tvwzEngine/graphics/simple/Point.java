package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.interfaces.Shape;
import lib.tvwzEngine.graphics.interfaces.Translatable;
import lib.tvwzEngine.math.Vector2;

import static org.lwjgl.opengl.GL11.*;

public class Point extends Shape {

    public Vertex pos;
    public float size;

    public Point ()  {
        pos = new Vertex();
    }

    public Point (Vertex pos) {
        this.pos = pos;
    }

    @Override
    public void render (float startDepth) {
        glPointSize(size);
        glBegin(GL_POINTS);
            pos.render(startDepth + depth);
        glEnd();
    }

    @Override
    public void translate (float dx, float dy) {
        pos.translate(dx, dy);
    }

    @Override
    public void rotateAround (Vector2 pivot, float degrees) {
        pos.position = pos.position.rotateAround(pivot, degrees);
    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {
        pos.position = pos.position.scale(pivot, scaleAmount);
    }

    public static void renderPoint (Vertex vertex, float size, float depth) {
        glPointSize(size);
        glBegin(GL_POINTS);
        vertex.render(depth);
        glEnd();
    }
}
