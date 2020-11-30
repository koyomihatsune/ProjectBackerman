package oop.koyomia.boomberman.InputComponent.InputManagement;

import java.util.ArrayList;
import java.util.List;

public class BombInputManager implements InputManager{
    protected List<Integer> keyDown;
    protected List<Integer> keyUp;

    private BombInputManager() {

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
    public void clear() {
        this.keyDown.clear();
        this.keyUp.clear();
    }
}
