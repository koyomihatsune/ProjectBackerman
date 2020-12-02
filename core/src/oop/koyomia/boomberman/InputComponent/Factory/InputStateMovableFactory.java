package oop.koyomia.boomberman.InputComponent.Factory;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.*;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.State.InputStateDefault;

public class InputStateMovableFactory implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState ipS = new InputStateDefault(self);
        ipS.addPressCommand(Input.Keys.W, new MoveUp());
        ipS.addPressCommand(Input.Keys.S, new MoveDown());
        ipS.addPressCommand(Input.Keys.A, new MoveLeft());
        ipS.addPressCommand(Input.Keys.D, new MoveRight());
        ipS.addKeyDownCommand(Input.Keys.SPACE, new Fire());

        return ipS;
    }
}
