package lib.tvwzEngine.graphics.simple;

import lib.tvwzEngine.graphics.interfaces.Renderable;
import lib.tvwzEngine.graphics.interfaces.RenderableBase;

import java.util.ArrayList;

public class SimpleGroup extends RenderableBase {

    public ArrayList<Renderable> renderables;

    public SimpleGroup (float startDepth) {
        this.depth = startDepth;
        renderables = new ArrayList<>();
    }


    @Override
    public void render (float startDepth) {
        for (Renderable renderable : renderables) {
            renderable.render(startDepth + depth);
        }
    }
}
