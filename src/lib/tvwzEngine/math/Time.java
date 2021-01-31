package lib.tvwzEngine.math;

public class Time {


    private static float deltaTime;
    private static long currentTime;
    private static long totalTime;
    private static long startTime;

    static {
        startTime = System.nanoTime();
    }

    public static void Step () {
        deltaTime = (System.nanoTime() - currentTime) / 1000000000f;
        currentTime = System.nanoTime();
        totalTime = System.nanoTime() - startTime;
    }


    public static float getDeltaTime () {
        return deltaTime;
    }

    public static float GetTotalTime () {
        return totalTime;
    }
}
