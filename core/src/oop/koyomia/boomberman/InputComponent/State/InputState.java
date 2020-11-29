package oop.koyomia.boomberman.InputComponent.State;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.Command.Command;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.InputManagement.InputManager;

import java.util.List;

public interface InputState {
    void addCommand(Integer key, Command command);
    Command getCommand(Integer key);
    void deleteCommand(Integer key);
    void setInputManager(InputManager inputManager);
    InputManager getInputManager();
}
