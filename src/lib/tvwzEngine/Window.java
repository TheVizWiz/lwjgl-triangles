package lib.tvwzEngine;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.math.Time;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLXARBCreateContext;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    public long id;
    public int width, height;
    public String title;

    public ArrayList<Renderable> renderableList;

    static {
        glfwInit();
    }

    public Window (int width, int height, String title) {
        this.width = width;
        this.title = title;
        this.height = height;
        renderableList = new ArrayList<>();
    }

    public void create () {
        if (!glfwInit()) return;
        id = glfwCreateWindow(width, height, title, 0, 0);
        if (id == 0) return;

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(id, vidMode.width() / 2, vidMode.height() / 2);
        glfwMakeContextCurrent(id);
        glfwShowWindow(id);

        createCapabilities();
        glfwSwapInterval(1);
        glEnable(GL_DEPTH_TEST);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, 0, height, -1000, 1000);
        glMatrixMode(GL_MODELVIEW);

        glfwSetWindowSizeCallback(id, new GLFWWindowSizeCallback() {
            @Override
            public void invoke (long window, int width, int height) {
                resizeCallback(width, height);
            }
        });


    }


    public void update () {
        Time.Step();
        glfwPollEvents();
    }


    public void render () {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(1f, 0.9f, 0.5f, 1);

        for (Renderable renderable : renderableList) {
            renderable.render();
        }

        glfwSwapBuffers(id);
    }

    public boolean shouldClose () {
        return glfwWindowShouldClose(id);
    }

    private void resizeCallback (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void destroy () {
        glfwDestroyWindow(id);
    }


}
