package lib.tvwzEngine.math;

public class Vector4 {

    public float x, y, z, a;

    public Vector4(float x, float y, float z, float a) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.a = a;
    }

    public Vector4() {
    }


    @Override
    public String toString () {
        return "[" + x + ", " + y + ", " + z + " +, " + a  + "]";
    }
}
