package lib.tvwzEngine.math;

import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

public class Time {


    private static double deltaTime;
    private static double currentTime;
    private static double totalTime;
    private static final double startTime;

    static {
        startTime = glfwGetTime();
        currentTime = glfwGetTime();
    }

    public static void Step () {
        double current = glfwGetTime();
        deltaTime = glfwGetTime() - currentTime;
        currentTime = current;
        totalTime = current - startTime;
    }


    public static float deltaTime () {
        return (float) deltaTime;
    }

    public static float totalTime () {
        return (float) totalTime;
    }
}
