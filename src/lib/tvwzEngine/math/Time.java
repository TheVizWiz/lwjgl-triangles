package lib.tvwzEngine.math;

public class Time {


    private static float deltaTime;
    private static long currentTime;
    private static float totalTime;
    private static long startTime;

    static {
        startTime = System.nanoTime();
        currentTime = System.nanoTime();
    }

    public static void Step () {
        deltaTime = (System.nanoTime() - currentTime) / 1000000000f;
        currentTime = System.nanoTime();
        totalTime = (System.nanoTime() - startTime) / 1000000000f;
    }


    public static float deltaTime () {
        return deltaTime;
    }

    public static float getTotalTime () {
        return totalTime;
    }
}
