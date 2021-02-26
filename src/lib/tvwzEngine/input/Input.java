package lib.tvwzEngine.input;

import lib.tvwzEngine.Window;
import lib.tvwzEngine.math.Vector2;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.ArrayList;

public class Input {

    public static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    public static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private static ArrayList<KeyListener> keyListeners;
    private static ArrayList<MouseListener> mouseListeners;
    private static ArrayList<MousePosListener> mousePosListeners;
    public static Vector2 mousePos;
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWMouseButtonCallback buttonCallback;
    private static GLFWKeyCallback keyCallback;


    static {
        mousePos = new Vector2();
        keyListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
        mousePosListeners = new ArrayList<>();


        cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke (long windowID, double xpos, double ypos) {
                int[] width = new int[2], height = new int[2];
                GLFW.glfwGetWindowSize(windowID, width, height);
                mousePos.x = ((float) (xpos)) / width[0];
                mousePos.y = ((float) (height[0] - ypos)) / height[0];
                for (MousePosListener mousePosListener : mousePosListeners) {
                    mousePosListener.onMouseMove(mousePos);
                }
            }
        };


        keyCallback = new GLFWKeyCallback() {

            @Override
            public void invoke (long windowID, int key, int scancode, int action, int mods) {
                keys[key] = action != GLFW.GLFW_RELEASE;
                for (KeyListener keyListener : keyListeners) {
                    if (action == GLFW.GLFW_RELEASE) {
                        keyListener.onKeyRelease(key);
                    } else if (action == GLFW.GLFW_PRESS) {
                        keyListener.onKeyPress(key);
                    } else if (action == GLFW.GLFW_REPEAT) {
                        keyListener.onKeyRepeat(key);
                    }
                }
            }
        };

        buttonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke (long windowID, int button, int action, int mods) {
                buttons[button] = action != GLFW.GLFW_RELEASE;
                for (MouseListener mouseListener : mouseListeners) {
                    if (action == GLFW.GLFW_RELEASE) {
                        mouseListener.onButtonRelease(button);
                    } else if (action == GLFW.GLFW_PRESS) {
                        mouseListener.onButtonPress(button);
                    } else if (action == GLFW.GLFW_REPEAT) {
                        mouseListener.onButtonRepeat(button);
                    }
                }
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

    /**
     *
     * @return The mouse position, between 0 and 1 for width and height
     */
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

    public static void addKeyListener (KeyListener listener) {
        keyListeners.add(listener);
    }

    public static void addMouseListener (MouseListener mouseListener) {
        mouseListeners.add(mouseListener);
    }

    public static void addMousePosListener (MousePosListener mousePosListener) {
        mousePosListeners.add(mousePosListener);
    }

    public static void removeKeyListener (KeyListener listener) {
        keyListeners.remove(listener);
    }

    public static void removeMouseListener (MouseListener mouseListener) {
        mouseListeners.remove(mouseListener);
    }

    public static void removeMousePosListener (MousePosListener mousePosListener) {
        mousePosListeners.remove(mousePosListener);
    }


}
