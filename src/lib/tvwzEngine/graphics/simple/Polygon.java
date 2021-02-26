package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;

public class Polygon extends Shape {

    public ArrayList<Vertex> vertices;

    private Vertex[] pointsBuffer;

    public Polygon (Vertex[] vertices) {
        this.vertices = new ArrayList<>();
        this.vertices.addAll(Arrays.asList(vertices));
        pointsBuffer = new Vertex[10];
    }

    public Polygon () {
        this.vertices = new ArrayList<>();
    }


    @Override
    public void render (float startDepth) {
        if (renderFill) {
            glBegin(GL_POLYGON);
            for (Vertex vertex : vertices) {
                vertex.render(startDepth + depth);
            }
            glEnd();
        }

        if (renderOutline) {
            glLineWidth(outlineWidth);
            glBegin(GL_LINE_LOOP);
            Vertex.renderVertexOutlineList(vertices.toArray(pointsBuffer), outlineColor, startDepth + depth);
            glEnd();
        }
    }

    @Override
    public void setColor (Vector3 color) {
        for (Vertex vertex : vertices) {
            vertex.color = color;
        }
    }

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
        for (Vertex v : vertices) {
            v.position = v.position.scale(pivot, scaleAmount);
        }
    }

    
}
