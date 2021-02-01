package lib.tvwzEngine;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.graphics.Updateable;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import org.lwjgl.glfw.GLFWVidMode;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL12.*;

public class Window {

    public long id;
    public int width, height;
    public String title;

    public ArrayList<Renderable> renderableList;
    public ArrayList<Updateable> updateableList;

    static {
        glfwInit();
    }

    public Window (int width, int height, String title) {
        this.width = width;
        this.title = title;
        this.height = height;
        renderableList = new ArrayList<>();
        updateableList = new ArrayList<>();
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
        glEnable(GL_LINE_SMOOTH);
        glEnable(GL_POINT_SMOOTH);
        glEnable(GL_DEPTH_TEST);
        glMatrixMode(GL_PROJECTION);
        glOrtho(0, width, height, 0, 1000, -1000);
        glMatrixMode(GL_MODELVIEW);
        glfwSetWindowSizeCallback(id, (window, width, height) -> {
                resizeCallback(width, height);
        });


    }


    public void update () {
        Time.Step();
        glfwPollEvents();
        for (Updateable updateable : updateableList) {
            updateable.update();
        }
    }


    public void render () {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(1f, 0.9f, 0.5f, 1);

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

    public void show () {
        glfwShowWindow(id);
    }

    public void hide () {
        glfwHideWindow(id);
    }

    public void setPosition (Vector2 pos) {
        glfwSetWindowPos(id, (int) pos.x, (int) pos.y);
    }

    public void setPosition (int x, int y) {
        glfwSetWindowPos(id, x, y);
    }


    public void destroy () {
        glfwDestroyWindow(id);
    }
}
