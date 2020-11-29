package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;

public class PlayerInputManager implements InputManager {
    protected List<Integer> keyDown;
    protected List<Integer> keyUp;
    protected List<Integer> keyPress;
    public static PlayerInputManager instance;

    private PlayerInputManager() {
        keyUp = new ArrayList<>();
        keyDown = new ArrayList<>();
        keyPress = new ArrayList<>();
    }

    public static PlayerInputManager getInstance() {
        if (PlayerInputManager.instance == null) {
            PlayerInputManager.instance = new PlayerInputManager();
        }
        return PlayerInputManager.instance;
    }

    @Override
    public List<Integer> getKeyDown() {
        return this.keyDown;
    }

    @Override
    public List<Integer> getKeyUp() {
        return this.keyUp;
    }

    @Override
    public List<Integer> getKeyPress() {
        return this.keyPress;
    }

    @Override
    public void clear() {
        this.keyDown.clear();
        this.keyUp.clear();
    }
}
