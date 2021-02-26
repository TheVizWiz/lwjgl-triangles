package lib.tvwzEngine;

import lib.tvwzEngine.graphics.interfaces.Renderable;
import lib.tvwzEngine.graphics.interfaces.Updatable;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFWVidMode;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL12.*;

public class Window {

    public long id;
    public int width, height;
    public int framesPerUpdate;
    public final int startWidth, startHeight;
    public String title;

    public ArrayList<Renderable> renderableList;
    public ArrayList<Updatable> updatableList;

    private Vector3 bgColor;

    private int currentFrameUpdate;

    public Window (int width, int height, String title) {
        bgColor = Vector3.white();
        this.width = width;
        this.title = title;
        this.startHeight = height;
        this.startWidth = width;
        this.height = height;
        renderableList = new ArrayList<>();
        updatableList = new ArrayList<>();
        framesPerUpdate = 1;
        currentFrameUpdate = 0;
        System.out.println("initialized with id " + id);
    }

    public void setResizable (boolean resizable) {
        if (id == 0) {
            glfwWindowHint(GLFW_RESIZABLE, resizable ? 1 : 0);
        }

    }

    public void create () {
        if (!glfwInit()) return;
        id = glfwCreateWindow(width, height, title, 0, 0);
        if (id == 0) return;
        glfwMakeContextCurrent(id);
        createCapabilities();
        glfwSwapInterval(1);
//        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glEnable(GL_LINE_SMOOTH);
        glEnable(GL_POINT_SMOOTH);
        glEnable(GL_DEPTH_TEST);
        glMatrixMode(GL_PROJECTION);
        glOrtho(0, width, 0, height, -1000, 1000);
        glMatrixMode(GL_MODELVIEW);
        glfwSetWindowSizeCallback(id, (window, width, height) -> {
            resizeCallback(width, height);
        });

    }

    public void step () {
        currentFrameUpdate = (currentFrameUpdate + 1) % framesPerUpdate;
        if (currentFrameUpdate == 0) update();
        render();
    }

    public void update () {
        Time.Step();
        glfwPollEvents();
        for (Updatable updatable : updatableList) {
            updatable.update();
        }
    }


    public void render () {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(bgColor.x, bgColor.y, bgColor.z, 0);

        for (Renderable renderable : renderableList) {
            renderable.render(0);
        }

        glfwSwapBuffers(id);
    }

    public boolean shouldClose () {
        return glfwWindowShouldClose(id);
    }

    private void resizeCallback (int width, int height) {
        this.width = width;
        this.height = height;
        glViewport(0, 0, width, height);
    }

    /**
     * scales a point using the original dimensions, useful for finding positions of scaled objects in relation to
     * start size of the window, such as for Cursor positions.
     *
     * @param point the point, normalized for each component to be between 0-1.
     * @return the scaled version of the normalized point vector.
     */
    public Vector2 startScaleNormalizedPoint (Vector2 point) {
        return new Vector2(point.x * startWidth, point.y * startHeight);
    }

    public void show () {
        glfwShowWindow(id);
    }

    public void hide () {
        glfwHideWindow(id);
    }

    public void setBackgroundColor (Vector3 color) {
        this.bgColor = color;
    }

    public void setTitle (String title) {
        glfwSetWindowTitle(id, title);
        this.title = title;
    }

    public String getTitle () {
        return title;
    }

    public void setPosition (Vector2 pos) {
        glfwSetWindowPos(id, (int) pos.x, (int) pos.y);
    }

    public void setPosition (int x, int y) {
        glfwSetWindowPos(id, x, y);
    }

    public void centerWithinMonitor () {
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        setPosition((vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
    }

    public void setAntiAlias (boolean point, boolean line) {
        if (point) {
            glEnable(GL_POINT_SMOOTH);
        } else {
            glDisable(GL_POINT_SMOOTH);
        }

        if (line) {
            glEnable(GL_LINE_SMOOTH);
        } else {
            glDisable(GL_LINE_SMOOTH);
        }
    }

    public void destroy () {
        glfwDestroyWindow(id);
    }


}
