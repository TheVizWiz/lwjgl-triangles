package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

import static org.lwjgl.opengl.GL12.*;

public class Line extends Shape {

    public Vertex startPos, endPos;
    public float lineWidth = 1;

    public Line (Vertex startPos, Vertex endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Line () {

    }

    @Override
    public void render (float startDepth) {
        glLineWidth(lineWidth);
        glBegin(GL_LINES);
        startPos.render(startDepth + depth);
        endPos.render(startDepth + depth);
        glEnd();
    }

    @Override
    public void setColor (Vector3 color) {
        startPos.color = color;
        endPos.color = color;
    }

    @Override
    public void translate (float dx, float dy) {
        startPos.translate(dx, dy);
        endPos.translate(dx, dy);
    }

    @Override
    public void rotateAround (Vector2 pivot, float degrees) {
        startPos.position = startPos.position.rotateAround(pivot, degrees);
        endPos.position = endPos.position.rotateAround(pivot, degrees);
    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {
        startPos.scale(pivot, scaleAmount);
        endPos.scale(pivot, scaleAmount);
    }

    public static void drawLine (Vertex a, Vertex b, float width, float depth) {
        glLineWidth(width);
        glBegin(GL_LINES);
        a.render(depth);
        b.render(depth);
        glEnd();
    }
}
