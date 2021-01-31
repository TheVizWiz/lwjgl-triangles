package lib.tvwzEngine.math;

public class Vector2 {

    public float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
    }


    @Override
    public String toString () {
        return "[" + x + ", " + y + "]";
    }
}
