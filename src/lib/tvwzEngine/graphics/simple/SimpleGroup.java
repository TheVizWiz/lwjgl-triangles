package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.Renderable;

import java.util.ArrayList;

public class SimpleGroup extends Renderable {

    public ArrayList<Renderable> renderables;

    public SimpleGroup (float startDepth) {
        this.depth = startDepth;
    }


    @Override
    public void render (float startDepth) {
        for (Renderable renderable : renderables) {
            renderable.render(startDepth + depth);
        }
    }
}
