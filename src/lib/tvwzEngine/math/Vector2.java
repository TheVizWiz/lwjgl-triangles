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
        return multiply(1 / magnitude);
    }

    public Vector2 rotateAround (Vector2 pivot, float degrees) {

        Vector2 tempVector = directionVector(pivot, this);
        float tempMag = tempVector.magnitude();
        double angle = tempVector.getAngle();
        angle += Math.toRadians(degrees);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        return new Vector2((float) (tempMag * cos), (float) (tempMag * sin)).add(pivot);

    }

    public Vector2 scale (Vector2 pivot, float scaleAmount) {
        return directionVector(pivot, this).multiply(scaleAmount).add(pivot);
    }

    public Vector2 clone () {
        return new Vector2(x, y);
    }

    public Vector2 clamp (float min, float max) {
        return new Vector2(Math.min(Math.max(min, x), x), Math.min(Math.max(min, y), y));
    }

    public Vector2 clamp1 () {
        return clamp(-1, 1);
    }

    public Vector3 toVector3 () {
        return new Vector3(x, y, 0);
    }

    public Vector4 toVector4 () {
        return new Vector4(x, y, 0, 0);
    }


    public float magnitude () {
        return (float) Math.sqrt(sqrMagnitude());
    }

    public float sqrMagnitude () {
        return x * x + y * y;
    }

    public float getAngle () {
        if (Float.compare(x, 0) == 0) {
            if (y > 0) return (float) Math.PI / 2;
            else return (float) Math.PI * 3 / 2;
        }
        double angle = Math.atan2(y, x);
        if (angle < 0) angle += Math.PI * 2;
        return (float) angle;
    }

    public float distance (Vector2 v) {
        return v.add(this.neg()).magnitude();
    }

    public float sqrDistance (Vector2 v) {
        return v.add(this.neg()).sqrMagnitude();
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Float.compare(vector2.x, x) == 0 && Float.compare(vector2.y, y) == 0;
    }

    public String toString () {
        return "[" + x + ", " + y + "]";
    }

    public int hashCode () {
        return Objects.hash(x, y);
    }


    public static Vector2 fromAngle (float rad) {
        return new Vector2((float) Math.cos(rad), (float) Math.sin(rad));
    }

    public static Vector2 directionVector (Vector2 start, Vector2 end) {
        return end.add(start.neg());
    }

    public static Vector2 lerp (Vector2 a, Vector2 b, float x) {
        return new Vector2(a.x + (b.x - a.x) * x, a.y + (b.y - a.y) * x);
    }

    public static Vector2 up () {
        return new Vector2(0, 1);
    }

    public static Vector2 left () {
        return new Vector2(-1, 0);
    }

    public static Vector2 right () {
        return new Vector2(1, 0);
    }

    public static Vector2 down () {
        return new Vector2(0, -1);
    }

    public static Vector2 zero () {
        return new Vector2(0, 0);
    }

}
