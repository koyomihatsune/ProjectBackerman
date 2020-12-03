package oop.koyomia.boomberman.InputComponent.Factory;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.*;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.State.InputState;
import oop.koyomia.boomberman.InputComponent.State.InputStateDefault;

public class InputStateMovableFactory2 implements InputStateFactory {
    @Override
    public InputState createInstance(GameObject self) {
        InputState ipS = new InputStateDefault(self);
        ipS.addPressCommand(Input.Keys.UP, new MoveUp());
        ipS.addPressCommand(Input.Keys.DOWN, new MoveDown());
        ipS.addPressCommand(Input.Keys.LEFT, new MoveLeft());
        ipS.addPressCommand(Input.Keys.RIGHT, new MoveRight());
        ipS.addKeyDownCommand(Input.Keys.ENTER, new Fire());

        return ipS;
    }


}
