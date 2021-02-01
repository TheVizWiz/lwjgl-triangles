package main;


import lib.tvwzEngine.Input;
import lib.tvwzEngine.Window;
import lib.tvwzEngine.graphics.simple.*;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class Main {


    public static void main (String[] args) {
        Window window = new Window(900, 900, "test");
        window.setResizable(false);
        window.create();
        Input.setGLFWCallBacks(window);
        TestClass testClass = new TestClass(window.width, window.height, 20);
        window.renderableList.add(testClass);
        window.updateableList.add(testClass);
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        window.setPosition(vidMode.width() / 2 - window.width / 2, vidMode.height() / 2 - window.height / 2);
        window.show();
//        window.render();

        while (true) {


            window.update();
            window.render();

            if (window.shouldClose()) {
                window.destroy();
                glfwTerminate();
                return;
            }
        }
    }

}
