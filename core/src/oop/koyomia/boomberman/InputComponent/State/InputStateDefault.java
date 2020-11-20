package oop.koyomia.boomberman.InputComponent.State;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;

import java.util.HashMap;

public class InputStateDefault implements InputState {
    HashMap<Integer, Command> listCommand;
    GameObject self;

    public InputStateDefault(GameObject self) {
        this.self = self;
    }
    @Override
    public void addCommand(Integer key, Command command) {
        this.listCommand.put(key, command);
    }

    @Override
    public Command getCommand(Integer key) {
        return this.listCommand.get(key);
    }

    @Override
    public void deleteCommand(Integer key) {
        this.listCommand.remove(key);
    }
}
