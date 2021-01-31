package lib.tvwzEngine.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL11.*;

public abstract class Renderable {

    protected float depth = 0;


    public abstract void render ();

    public float getDepth () {
        return depth;
    }

    public void setDepth (float depth) {
        this.depth = depth;
    }
}
