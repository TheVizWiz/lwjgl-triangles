package main.samples.gameoflife;

import lib.tvwzEngine.graphics.simple.Quad;

public class GOLSquare {

    public Quad quad;

    public GOLSquare (float x, float y, float width, float height) {
        this.quad = new Quad(x, y, width, height);
    }
}
