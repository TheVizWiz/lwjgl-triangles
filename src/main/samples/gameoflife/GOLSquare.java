package main.samples.gameoflife;

import lib.tvwzEngine.graphics.interfaces.Renderable;
import lib.tvwzEngine.graphics.simple.Quad;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

public class GOLSquare implements Renderable {

    public static Vector3 OCCUPIED = Vector3.black(), BLANK = Vector3.white();

    public Quad quad;
    private boolean isOccupied;

    public GOLSquare (float x, float y, float width, float height) {
        this.quad = new Quad(x, y, width, height);
    }

    @Override
    public void render (float startDepth) {
        quad.render(startDepth);
    }

    public boolean isOccupied () {
        return isOccupied;
    }

    public void occupy () {
        isOccupied = true;
        quad.setColor(OCCUPIED);
    }

    public void unOccupy () {
        isOccupied = false;
        quad.setColor(BLANK);
    }

    public void switchOccupy () {
        if (isOccupied) unOccupy();
        else occupy();
    }

    public boolean checkCollision (Vector2 point) {
        if (quad.vertices[0].position.x > point.x) return false;
//        System.out.println("test 1 passed");
        if (quad.vertices[2].position.x < point.x) return false;
//        System.out.println("test 2 passed");
        if (quad.vertices[0].position.y > point.y) return false;
//        System.out.println("test 3 passed");
        if (quad.vertices[2].position.y < point.y) return false;
//        System.out.println("hit");
        return true;
    }
}
