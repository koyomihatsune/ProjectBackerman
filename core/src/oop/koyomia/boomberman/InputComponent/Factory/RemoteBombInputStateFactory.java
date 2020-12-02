package oop.koyomia.boomberman.InputComponent.Factory;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.DefaultBombExplode;
import oop.koyomia.boomberman.Command.RemoteBombExplode;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.RemoteBombInputManager;
import oop.koyomia.boomberman.InputComponent.InputManagement.TimerBombInputManager;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.State.InputStateDefault;

public class RemoteBombInputStateFactory implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState ipS = new InputStateDefault(self);
        ipS.setInputManager(new RemoteBombInputManager());
        return ipS;
    }
}
