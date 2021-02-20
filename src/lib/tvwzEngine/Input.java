package lib.tvwzEngine;

import lib.tvwzEngine.math.Vector2;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class Input {

    public static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    public static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    public static Vector2 mousePos;
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWMouseButtonCallback buttonCallback;
    private static GLFWKeyCallback keyCallback;


    static {
        mousePos = new Vector2();
        cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke (long windowID, double xpos, double ypos) {
                int[] width = new int[2], height = new int[2];
                GLFW.glfwGetWindowSize(windowID, width, height);
                mousePos.x = (float) xpos;
                mousePos.y = (float) (height[0] - ypos);
            }
        };


        keyCallback = new GLFWKeyCallback() {

            @Override
            public void invoke (long windowID, int key, int scancode, int action, int mods) {
                keys[key] = action != GLFW.GLFW_RELEASE;
            }
        };

        buttonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke (long windowID, int button, int action, int mods) {
                buttons[button] = action != GLFW.GLFW_RELEASE;
            }
        };
    }

    public static void terminate () {
        keyCallback.free();
        buttonCallback.free();
        cursorPosCallback.free();
    }

    public static void setGLFWCallBacks (Window window) {
        GLFW.glfwSetKeyCallback(window.id, keyCallback);
        GLFW.glfwSetCursorPosCallback(window.id, cursorPosCallback);
        GLFW.glfwSetMouseButtonCallback(window.id, buttonCallback);
    }


    public static boolean isKeyDown (int keyCode) {
        return keys[keyCode];
    }

    public static boolean isButtonDown (int buttonCode) {
        return buttons[buttonCode];
    }

    public static Vector2 getMousePos () {
        return mousePos.clone();
    }


    public static GLFWCursorPosCallback getCursorPosCallback () {
        return cursorPosCallback;
    }

    public static GLFWMouseButtonCallback getButtonCallback () {
        return buttonCallback;
    }

    public static GLFWKeyCallback getKeyCallback () {
        return keyCallback;
    }
}
