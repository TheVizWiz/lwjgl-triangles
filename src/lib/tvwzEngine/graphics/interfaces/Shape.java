package lib.tvwzEngine.graphics.interfaces;

import lib.tvwzEngine.graphics.Renderable;
import lib.tvwzEngine.math.Vector2;

public abstract class Shape extends Renderable implements Translatable, Rotatable, Scalable {

    public final void translateRelative (Vector2 startPos, Vector2 endPos) {
        Vector2 d = Vector2.directionVector(startPos, endPos);
        translate(d.x, d.y);
    }
}
