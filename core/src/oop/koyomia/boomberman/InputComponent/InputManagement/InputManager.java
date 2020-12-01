package oop.koyomia.boomberman.InputComponent.InputManagement;

import java.util.List;

public interface InputManager {
    List<Integer> getKeyDown();
    List<Integer> getKeyUp();
    List<Integer> getKeyPress();
    void clear();
}
