package main;


import lib.tvwzEngine.input.Input;
import lib.tvwzEngine.Window;
import lib.tvwzEngine.math.Vector3;
import main.samples.gameoflife.GOLInputManager;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class Main {


    public static void main (String[] args) {
        Window window = new Window(900, 900, "test");
        {
            window.setResizable(false);
            window.create();
            Input.setGLFWCallBacks(window);
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            window.setPosition(vidMode.width() / 2 - window.width / 2, vidMode.height() / 2 - window.height / 2);
            window.setBackgroundColor(Vector3.rgb256(0, 255, 168));
            window.show();
        }
        TestClass2 class2 = new TestClass2(window.width, window.height, 10);
        class2.lowSpeed = 50;
        class2.highSpeed = 100;
        window.renderableList.add(class2);
        window.updatableList.add(class2);
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
