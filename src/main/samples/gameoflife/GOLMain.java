package main.samples.gameoflife;

import lib.tvwzEngine.Window;
import lib.tvwzEngine.input.Input;
import lib.tvwzEngine.math.Vector3;
import main.TestClass2;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class GOLMain {

    public static void main (String[] args) {
        GLFW.glfwInit();
        ;
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        int size = Math.min(vidMode.width(), vidMode.height()) / 2;
        Window window = new Window(size, size, "Game Of Life Simulation");
//        window.setResizable(false);
        window.create();
        Input.setGLFWCallBacks(window);
        window.centerWithinMonitor();
        GameOfLife gol = new GameOfLife(window.width, window.height, 40, window);
        GOLInputManager inputManager = new GOLInputManager(gol);
        window.updatableList.add(gol);
        window.renderableList.add(gol);
        window.framesPerUpdate = 10;

        while (true) {

            window.step();
            if (window.shouldClose()) {
                window.destroy();
                glfwTerminate();
                Input.terminate();
                return;
            }
        }
    }
}
