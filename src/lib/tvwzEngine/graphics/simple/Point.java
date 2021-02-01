package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Translatable;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;

public class Point extends Renderable implements Translatable {

    public Vertex pos;
    public float size;

    public Point ()  {

    }

    public Point (Vertex pos) {
        this.pos = pos;
    }

    @Override
    public void render (float startDepth) {
        glPointSize(size);
        glBegin(GL_POINTS);
            pos.render(startDepth + depth);
        glEnd();
//        float[] array = new float[2];
//        glGetFloatv(GL_LINE_WIDTH_RANGE, array);
//        System.out.println(Arrays.toString(array));
    }

    @Override
    public void translate (float dx, float dy) {
        pos.translate(dx, dy);
    }
}
