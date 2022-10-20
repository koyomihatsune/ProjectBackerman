package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
//import sun.jvm.hotspot.gc.shared.Space;

public class RemoteBombInputManager extends BombInputManager {
    public RemoteBombInputManager() {
        super();
    }

    public void update() {
        if (PlayerInputManager.getInstance().getKeyDown().equals(Input.Keys.SPACE)) this.setActiveExplode(true);
    }
}
