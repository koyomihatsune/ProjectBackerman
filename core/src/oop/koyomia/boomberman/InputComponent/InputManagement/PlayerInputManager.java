package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;

public class PlayerInputManager implements InputManager {
    protected List<Integer> keyPress;
    protected List<Integer> keyDown;
    public static PlayerInputManager instance;

    private PlayerInputManager() {
        keyPress = new ArrayList<>();
        keyDown = new ArrayList<>();
    }

    public static PlayerInputManager getInstance() {
        if (PlayerInputManager.instance == null) {
            PlayerInputManager.instance = new PlayerInputManager();
        }
        return PlayerInputManager.instance;
    }

    @Override
    public List<Integer> getKeyPress() {
        return this.keyPress;
    }

    @Override
    public List<Integer> getKeyDown() {
        return this.keyDown;
    }

}
