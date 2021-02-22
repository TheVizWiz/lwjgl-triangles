package main.samples.gameoflife;

import lib.tvwzEngine.Window;
import lib.tvwzEngine.input.Input;
import lib.tvwzEngine.input.KeyListener;
import lib.tvwzEngine.input.MouseListener;
import lib.tvwzEngine.input.MousePosListener;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;

public class GOLInputManager implements KeyListener, MouseListener, MousePosListener {

    private Window window;

    public GOLInputManager (Window window) {
        this.window = window;
        Input.addKeyListener(this);
    }

    @Override
    public void onKeyPress (int key) {
        window.setBackgroundColor(Vector3.yellow());
    }

    @Override
    public void onKeyRelease (int key) {
        window.setBackgroundColor(Vector3.magenta());
    }

    @Override
    public void onKeyRepeat (int key) {

    }

    @Override
    public void onButtonPress (int button) {

    }

    @Override
    public void onButtonRelease (int button) {

    }

    @Override
    public void onButtonRepeat (int button) {

    }

    @Override
    public void onMouseMove (Vector2 pos) {

    }
}
