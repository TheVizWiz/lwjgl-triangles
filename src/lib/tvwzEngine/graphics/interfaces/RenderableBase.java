package lib.tvwzEngine.graphics.interfaces;


public abstract class RenderableBase implements Renderable {

    protected float depth = 0;

    public abstract void render (float startDepth);

    public float getDepth () {
        return depth;
    }

    public void setDepth (float depth) {
        this.depth = depth;
    }
}
