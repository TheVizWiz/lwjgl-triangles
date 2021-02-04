package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.interfaces.Shape;
import lib.tvwzEngine.graphics.interfaces.Translatable;
import lib.tvwzEngine.math.Vector2;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Shape {

    public ArrayList<Vertex> vertices;

    public Polygon (Vertex[] vertices) {
        this.vertices = new ArrayList<>();
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public Polygon () {
        this.vertices = new ArrayList<>();
    }


    @Override
    public void render (float startDepth) {
        Vertex.renderVertexList(vertices.toArray(new Vertex[0]), depth + startDepth);
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
