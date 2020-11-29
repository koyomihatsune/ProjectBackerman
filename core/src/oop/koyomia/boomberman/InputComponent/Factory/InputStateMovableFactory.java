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
        ipS.addCommand(Input.Keys.W, new MoveUp());
        ipS.addCommand(Input.Keys.S, new MoveDown());
        ipS.addCommand(Input.Keys.A, new MoveLeft());
        ipS.addCommand(Input.Keys.D, new MoveRight());
        ipS.addCommand(Input.Keys.SPACE, new PutBomb());
        return ipS;
    }
}
