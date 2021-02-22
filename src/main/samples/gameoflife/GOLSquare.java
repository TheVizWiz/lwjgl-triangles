package main.samples.gameoflife;

import lib.tvwzEngine.graphics.simple.Quad;
import lib.tvwzEngine.math.Vector3;

public class GOLSquare {

    public static Vector3 OCCUPIED = Vector3.black(), BLANK = Vector3.white();

    public Quad quad;

    public GOLSquare (float x, float y, float width, float height) {
        this.quad = new Quad(x, y, width, height);
    }
}
