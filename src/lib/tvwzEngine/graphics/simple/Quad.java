package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

import static org.lwjgl.opengl.GL11.*;

public class Quad extends Shape {

    public Vertex[] vertices = new Vertex[4];

    public Quad () {
        for (Vertex vertex : vertices) {
            vertex = new Vertex();
        }
    }

    public Quad (Vertex[] vertices) {
        if (vertices.length == 4) {
            this.vertices = vertices;
        }
    }

    public Quad (float x, float y, float width, float height) {
        vertices[0] = new Vertex(new Vector2(x, y));
        vertices[1] = new Vertex(new Vector2(x, y + height));
        vertices[2] = new Vertex(new Vector2(x + width, y + height));
        vertices[3] = new Vertex(new Vector2(x + width, y));
    }


    @Override
    public void render (float startDepth) {
        if (renderFill) {
            glBegin(GL_QUADS);
            Vertex.renderVertexList(vertices, startDepth + depth);
            glEnd();
        }
        if (renderOutline) {
            glLineWidth(outlineWidth);
            glBegin(GL_LINE_LOOP);
            Vertex.renderVertexOutlineList(vertices, outlineColor, startDepth + depth);
            glEnd();
        }
    }

    @Override
    public void setColor (Vector3 color) {
        for (Vertex vertex : vertices) {
            vertex.color = color;
        }
    }

    @Override
    public void translate (float dx, float dy) {
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.add(dx, dy);
        }

    }

    @Override
    public void rotateAround (Vector2 pivot, float degrees) {
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.rotateAround(pivot, degrees);
        }
    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {
        for (Vertex vertex : vertices) {
            vertex.position = vertex.position.scale(pivot, scaleAmount);
        }

    }
}
