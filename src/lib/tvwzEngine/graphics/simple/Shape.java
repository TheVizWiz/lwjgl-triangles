package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.interfaces.RenderableBase;
import lib.tvwzEngine.graphics.interfaces.Rotatable;
import lib.tvwzEngine.graphics.interfaces.Scalable;
import lib.tvwzEngine.graphics.interfaces.Translatable;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

public abstract class Shape extends RenderableBase implements Translatable, Rotatable, Scalable {

    protected boolean renderOutline = false, renderFill = true;
    protected Vector3 outlineColor = Vector3.black();
    protected float outlineWidth = 1f;

    public final void translateRelative (Vector2 startPos, Vector2 endPos) {
        Vector2 d = Vector2.directionVector(startPos, endPos);
        translate(d.x, d.y);
    }

    public abstract void setColor (Vector3 color);


    public final void setRenderOutline (boolean renderOutline) {
        this.renderOutline = renderOutline;
    }

    public final boolean isRenderOutline () {
        return renderOutline;
    }

    public final boolean isRenderFill () {
        return renderFill;
    }

    public final void setRenderFill (boolean renderFill) {
        this.renderFill = renderFill;
    }

    public final void setOutlineColor (Vector3 outlineColor) {
        this.outlineColor = outlineColor;
    }

    public final float getOutlineWidth () {
        return outlineWidth;
    }

    public final void setOutlineWidth (float outlineWidth) {
        this.outlineWidth = outlineWidth;
    }
}
