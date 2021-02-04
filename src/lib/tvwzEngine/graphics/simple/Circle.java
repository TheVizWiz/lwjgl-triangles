package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.interfaces.Shape;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Shape {

    private Vertex[] vertices;
    public Vertex center;

    public Circle (Vertex center, float radius) {
        this(center, radius, 50);
    }

    public Circle (Vertex center, float radius, int numTriangles) {
        makeFan(center, radius, numTriangles);
    }

    public Circle (Vertex center, float radius, int numTriangles, Vector3[] colors) {
        makeFan(center, radius, numTriangles);
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].color = colors[i];
        }
    }

    public Circle (Vertex center, float radius, int numTriangles, Vector3 outerColor) {
        makeFan(center, radius, numTriangles);
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].color = outerColor;
        }
    }

    private void makeFan (Vertex center, float radius, int numTriangles) {
        this.center = center;
        float degreesPerTriangle = 360f / numTriangles;
        vertices = new Vertex[numTriangles];
        for (int i = 0; i < numTriangles; i++) {
            vertices[i] =
                    new Vertex(Vector2.fromAngle((float) Math.toRadians(i * degreesPerTriangle)).multiply(radius).add(center.position)
                    );
        }
    }


    @Override
    public void render (float startDepth) {
        glBegin(GL_TRIANGLE_FAN);
        center.render(startDepth + depth);
        for (Vertex vertex : vertices) {
            vertex.render(startDepth + depth);
        }
        vertices[0].render(startDepth + depth);
        glEnd();
    }

    @Override
    public void rotateAround (Vector2 pivot, float degrees) {
        center.position = center.position.rotateAround(pivot, degrees);
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.rotateAround(pivot, degrees);
        }
    }

    public void rotateAroundCenter (float degrees) {
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.rotateAround(center.position, degrees);
        }
    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.scale(pivot, scaleAmount);
        }
    }

    public void scaleCenter (float scaleAmount) {
        scale(center.position, scaleAmount);
    }

    public void moveCenterTo (float x, float y) {
        float dx = x - center.position.x;
        float dy = y - center.position.y;
        translate(dx, dy);
    }

    public void moveCenterTo (Vector2 pos) {
        moveCenterTo(pos.x, pos.y);
    }

    @Override
    public void translate (float dx, float dy) {
        center.translate(dx, dy);
        for (Vertex vertex : vertices) {
            vertex.translate(dx, dy);
        }
    }
}
