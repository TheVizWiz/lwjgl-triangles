package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

import static org.lwjgl.opengl.GL12.*;

public class Triangle extends Shape {

    public Vertex[] vertices = new Vertex[3];

    public static final int CENTROID = 0, CIRCUMCENTER = 1, INCENTER = 2, ORTHOCENTER = 3;


    public Triangle (Vertex[] vertices) {
        if (vertices.length == 3) {
            this.vertices = vertices;
        }
    }

    public Vector2 getCenter (int centerType) {
        Vector2 returnVector = new Vector2();
        switch (centerType) {
            case CENTROID:
                returnVector.x = (vertices[0].position.x + vertices[1].position.x + vertices[2].position.x) / 3f;
                returnVector.y = (vertices[0].position.y + vertices[1].position.y + vertices[2].position.y) / 3f;
                break;

            case CIRCUMCENTER:

                break;

            case INCENTER:

                break;

            case ORTHOCENTER:

                break;

            default:
                System.out.println("Unknown center type");
        }
        return returnVector;
    }

    @Override
    public void setColor (Vector3 color) {
        for (Vertex vertex : vertices) {
            vertex.color = color;
        }
    }

    @Override
    public void render (float startDepth) {
        if (renderFill) {
            glBegin(GL_TRIANGLES);
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

    public void SetVertexPositions (Vector2[] positions) {
        for (int i = 0;  i < vertices.length; i++) {
            vertices[i].position = positions[i];
        }
    }

    public void setVertexPositions (Vector2 pos1, Vector2 pos2, Vector2 pos3) {
        vertices[0].position = pos1;
        vertices[1].position = pos2;
        vertices[2].position = pos3;
    }

    @Override
    public void translate (float dx, float dy) {
        for (Vertex vertex : vertices) {
            vertex.translate(dx, dy);
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
            vertex.scale(pivot, scaleAmount);
        }
    }


}
