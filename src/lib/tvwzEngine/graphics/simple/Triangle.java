package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Translatable;
import lib.tvwzEngine.math.Vector2;

import static org.lwjgl.opengl.GL12.*;

public class Triangle extends Renderable implements Translatable {

    public Vertex[] vertices = new Vertex[3];


    public Triangle (Vertex[] vertices) {
        if (vertices.length == 3) {
            this.vertices = vertices;
        }
    }

    @Override
    public void render (float startDepth) {
        glBegin(GL_TRIANGLES);
        for (Vertex vertex : vertices) {
            vertex.render(startDepth + depth);
        }
        glEnd();
    }

    @Override
    public void translate (float dx, float dy) {
        for (Vertex vertex : vertices) {
            vertex.translate(dx, dy);
        }
    }

    public void SetVertexPositions (Vector2[] positions) {

    }
}
