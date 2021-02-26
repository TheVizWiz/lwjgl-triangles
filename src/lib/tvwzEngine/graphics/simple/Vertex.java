package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.interfaces.RenderableBase;
import lib.tvwzEngine.graphics.interfaces.Scalable;
import lib.tvwzEngine.graphics.interfaces.Translatable;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

import static org.lwjgl.opengl.GL12.*;

public class Vertex extends RenderableBase implements Translatable, Scalable {

    public Vector2 position;
    public Vector3 color;
    public Vector3 normalColor = new Vector3(1, 1, 1);

    public Vertex (Vector3 backgroundColor) {
        normalColor = backgroundColor;
    }

    public Vertex (Vector2 position, Vector3 color) {
        this.position = position;
        this.color = color;
    }

    public Vertex (Vector2 pos) {
        this.position = pos;
    }

    public Vertex () {

    }

    @Override
    public void render (float startDepth) {
        if (color != null) {
            glColor3f(color.x, color.y, color.z);
        } else glColor3f(normalColor.x, normalColor.y, normalColor.z);
        glVertex3f(position.x, position.y, startDepth);
    }

    @Override
    public void translate (float dx, float dy) {
        position = position.add(dx, dy);
    }


    public static void renderVertexList (Vertex[] vertices, float startDepth) {
        for (Vertex vertex : vertices) {
            vertex.render(startDepth);
        }
    }

    public static void renderVertexOutlineList (Vertex[] vertices, Vector3 color, float startDepth) {
        glColor3f(color.x, color.y, color.z);
        for (Vertex vertex : vertices) {
            glVertex3f(vertex.position.x, vertex.position.y, startDepth);
        }
    }

    @Override
    public void scale (Vector2 pivot, float scaleAmount) {
        position = position.scale(pivot, scaleAmount);
    }
}
