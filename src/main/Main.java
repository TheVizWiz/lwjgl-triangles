package main;


import lib.tvwzEngine.Input;
import lib.tvwzEngine.Window;
import lib.tvwzEngine.graphics.simple.Rectangle;
import lib.tvwzEngine.math.Time;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Main {


    public static void main(String[] args) {
        Window window = new Window(500, 500, "test");
        window.create();
        Input.setGLFWCallBacks(window);
        Rectangle rectangle = new Rectangle();
        rectangle.position = new Vector2(5, 5);
        rectangle.dimensions = new Vector2(50, 50);
        rectangle.colors[1] = new Vector3(1, 1, 0);
        rectangle.colors[2] = new Vector3(0, 0, 0);
        rectangle.colors[3] = new Vector3(0, 1, 0);
        window.renderableList.add(rectangle);

        while (true) {

            if (Input.isKeyDown(GLFW_KEY_ESCAPE)) {
                glfwSetWindowShouldClose(window.id, true);
            }

            if (Input.isButtonDown(GLFW_MOUSE_BUTTON_1)) {
                rectangle.position.x += Time.getDeltaTime() * 50;
                rectangle.position.y += Time.getDeltaTime() * 50;

//                rectangle.position.y++;
            }


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
