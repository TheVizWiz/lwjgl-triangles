package main.samples.gameoflife;

import lib.tvwzEngine.Window;
import lib.tvwzEngine.input.Input;
import lib.tvwzEngine.input.KeyListener;
import lib.tvwzEngine.input.MouseListener;
import lib.tvwzEngine.input.MousePosListener;
import lib.tvwzEngine.math.Vector2;
import lib.tvwzEngine.math.Vector3;
import org.lwjgl.glfw.GLFW;

public class GOLInputManager implements KeyListener, MouseListener, MousePosListener {

    private GameOfLife gameOfLife;

    public GOLInputManager (GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        Input.addKeyListener(this);
        Input.addMouseListener(this);
    }

    @Override
    public void onKeyPress (int key) {
        if (key == GLFW.GLFW_KEY_SPACE) {
            if (gameOfLife.isRunning()) gameOfLife.pause();
            else gameOfLife.play();
        } else if (key == GLFW.GLFW_KEY_RIGHT) {
            gameOfLife.updateSingleFrame();
        }
    }

    @Override
    public void onKeyRelease (int key) {
    }

    @Override
    public void onKeyRepeat (int key) {

    }

    @Override
    public void onButtonPress (int button) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_1) {
            gameOfLife.clickSquare(Input.getMousePos());
        }
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
