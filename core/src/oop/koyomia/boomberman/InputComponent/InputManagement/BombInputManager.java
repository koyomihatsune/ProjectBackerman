package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class BombInputManager implements InputManager {
    protected boolean activeExplode = false;
    List<Integer> keyPress;
    public BombInputManager() {
        keyPress = new ArrayList<>();
    }

    @Override
    public List<Integer> getKeyPress() {
        update();
        if (activeExplode)
            keyPress.add(Input.Keys.SPACE);
        return keyPress;
    }

    public abstract void update();

    public boolean isActiveExplode() {
        return activeExplode;
    }

    public void setActiveExplode(boolean activeExplode) {
        this.activeExplode = activeExplode;
    }
}
