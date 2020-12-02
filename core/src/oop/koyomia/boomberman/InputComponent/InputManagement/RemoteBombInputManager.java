package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class RemoteBombInputManager extends BombInputManager {
    public RemoteBombInputManager() {
        super();
    }

    public void update() {
        if (PlayerInputManager.getInstance().getKeyDown().contains(Input.Keys.SPACE)) this.setActiveExplode(true);
    }
}
