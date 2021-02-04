package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.interfaces.Shape;
import lib.tvwzEngine.graphics.interfaces.Translatable;
import lib.tvwzEngine.math.Vector2;

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

    @Override
    public void rotateAround (Vector2 pivot, float degrees) {

    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {

    }
}
