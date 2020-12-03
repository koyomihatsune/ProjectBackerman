package oop.koyomia.boomberman.InputComponent.Factory;

import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.PlayerInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;

public class MainCharInputStateFactory2 implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState newInputState = new InputStateMovableFactory2().createInstance(self);
        newInputState.setInputManager(PlayerInputManager.getInstance());
        return newInputState;
    }
}
