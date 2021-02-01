package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Translatable;

import java.util.ArrayList;

public class Polygon extends Renderable implements Translatable {

    public ArrayList<Vertex> vertices;

    public Polygon () {

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
}
