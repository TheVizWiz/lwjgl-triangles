package lib.tvwzEngine.math;

import java.util.Objects;

public class Vector2 {

    public float x, y;

    public Vector2 (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 () {
    }


    @Override
    public String toString () {
        return "[" + x + ", " + y + "]";
    }

    public Vector2 add (float dx, float dy) {
        return new Vector2(x + dx, y + dy);
    }

    public Vector2 add (Vector2 b) {
        return new Vector2(x + b.x, y + b.y);
    }

    public Vector2 neg () {
        return multiply(-1);
    }

    public Vector2 multiply (float scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 normalize () {
        float magnitude = magnitude();
        return new Vector2(x / magnitude, y / magnitude);
    }

    public float magnitude () {
        return (float) Math.sqrt(sqrMagnitude());
    }

    public float sqrMagnitude () {
        return x * x + y * y;
    }

    public static Vector2 fromRadians (float rad) {
        return new Vector2((float) Math.cos(rad), (float) Math.sin(rad));
    }

    public Vector2 rotateAround (Vector2 rotateAround, float degrees) {
        float cos =(float) Math.cos(Math.toRadians(degrees));
        float sin =(float) Math.sin(Math.toRadians(degrees));
        float x = rotateAround.x - this.x;
        float y = rotateAround.y - this.y;
        float xNew = x * cos - y * sin;
        float yNew = x * sin + y * cos;
        return new Vector2(xNew + rotateAround.x, yNew + rotateAround.y);

    }

    public static Vector2 fromDegrees (float degrees) {
        return new Vector2((float) Math.cos(Math.toRadians(degrees)),
                (float) Math.sin(Math.toRadians(degrees)));
    }

    public Vector2 clone () {
        return new Vector2(x, y);
    }

    public static Vector2 lerp (Vector2 a, Vector2 b, float x) {
        return new Vector2(a.x + (b.x - a.x) * x, a.y + (b.y - a.y) * x);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Float.compare(vector2.x, x) == 0 && Float.compare(vector2.y, y) == 0;
    }

    @Override
    public int hashCode () {
        return Objects.hash(x, y);
    }
}
