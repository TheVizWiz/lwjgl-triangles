package lib.tvwzEngine.math;

import java.util.Objects;

public class Vector3 {

    public float x, y, z;


    public Vector3 (float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 () {
    }

    public Vector3 add (Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public Vector3 multiply (float scalar) {
        return new Vector3(x * scalar, y * scalar, z * scalar);
    }

    public float sqrMagnitude () {
        return x * x + y * y + z * z;
    }

    public float magnitude () {
        return (float) Math.sqrt(sqrMagnitude());
    }

    public float dot (Vector3 b) {
        return x * b.x + y * b.y + z * b.z;
    }

    public Vector3 neg () {
        return multiply(-1);
    }

    public Vector2 toVector2 () {
        return new Vector2(x, y);
    }

    public Vector3 normalize () {
        return multiply(1 / magnitude());
    }

    public static Vector3 lerp (Vector3 a, Vector3 b, float x) {
        return new Vector3(a.x + (b.x - a.x) * x, a.y + (b.y - a.y) * x, a.z + (b.z - a.z) * x);
    }

    public Vector3 clone () {
        return new Vector3(x, y, z);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return Float.compare(vector3.x, x) == 0 && Float.compare(vector3.y, y) == 0 && Float.compare(vector3.z, z) == 0;
    }

    @Override
    public int hashCode () {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString () {
        return "[" + x + ", " + y + ", " + z + "]";
    }


    public static Vector3 up () {
        return new Vector3(0, 1, 0);
    }

    public static Vector3 down () {
        return new Vector3(0, -1, 0);
    }

    public static Vector3 left () {
        return new Vector3(-1, 0, 0);
    }

    public static Vector3 right () {
        return new Vector3(1, 0, 0);
    }

    public static Vector3 white () {
        return new Vector3(1, 1, 1);
    }

    public static Vector3 black () {
        return new Vector3(0, 0, 0);
    }

    public static Vector3 red () {
        return new Vector3(1, 0, 0);
    }

    public static Vector3 green () {
        return new Vector3(0, 1, 0);
    }

    public static Vector3 blue () {
        return new Vector3(0, 0, 1);
    }

    public static Vector3 cyan () {
        return new Vector3(0, 1, 1);
    }

    public static Vector3 yellow () {
        return new Vector3(1, 1, 0);
    }

    public static Vector3 magenta () {
        return new Vector3(1, 0, 1);
    }

    public static Vector3 rgb256 (float x, float y, float z) {
        return new Vector3(x, y, z).multiply(1 / 256f);
    }
}
