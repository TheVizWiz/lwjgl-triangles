package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Translatable;

import java.util.Arrays;

import static org.lwjgl.opengl.GL12.*;

public class Line extends Renderable implements Translatable {

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
    public void translate (float dx, float dy) {
        startPos.translate(dx, dy);
        endPos.translate(dx, dy);
    }
}
