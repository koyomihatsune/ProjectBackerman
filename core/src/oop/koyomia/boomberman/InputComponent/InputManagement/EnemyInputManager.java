package oop.koyomia.boomberman.InputComponent.InputManagement;

import com.badlogic.gdx.Input;
import oop.koyomia.boomberman.GameObject.GameObject;
import oop.koyomia.boomberman.InputComponent.System.InputSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import static oop.koyomia.boomberman.GameConfig.CHARACTER_VELOCITY;

public class EnemyInputManager implements InputManager {
    protected List<Integer> keyPress;
    protected List<Integer> keyDown;
    protected List<GameObject> world;
    protected Stack<Integer> movementStack;
    GameObject self;
    float oldX;
    float oldY;
    Random rant;

    public EnemyInputManager(GameObject self) {
        this.self = self;
        keyPress = new ArrayList<>();
        keyDown = new ArrayList<>();
        movementStack = new Stack<>();
        movementStack.push(2);
        movementStack.push(3);
        rant = new Random();
    }

    @Override
    public List<Integer> getKeyPress() {
        return this.keyPress;
    }

    @Override
    public List<Integer> getKeyDown() {
        return this.keyDown;
    }

    public void updateWorld(List<GameObject> world){
        System.out.println("World updated.");
        this.world = world;
        int rand = rant.nextInt(6);
        System.out.println(rand);
        move(rand);

        for (int i = 0; i< movementStack.size(); i++)
        System.out.print( movementStack.get(i) + " " );
        System.out.println();

        if (movementStack.size() >= 4){
            movementStack.remove(0);
        }

        oldX = self.getPhysicsState().getPhysicsBody().getX();
        oldY = self.getPhysicsState().getPhysicsBody().getY();

    }

    public void move(int input){
        switch (input) {
            case 0:
                keyPress.clear();
                keyPress.add(Input.Keys.S);
                System.out.println("Bot " + self.getProperties().hashCode() + " go down");
                if (movementStack.peek() != 2) movementStack.push(2);

                if (self.getPhysicsState().getPhysicsBody().getY()!= oldY)
                    break;
            case 2:
                keyPress.clear();
                keyPress.add(Input.Keys.W);
                System.out.println("Bot " + self.getProperties().hashCode() + " go up");
                if (movementStack.peek() != 0) movementStack.push(0);
                break;

            case 1:
                keyPress.clear();
                keyPress.add(Input.Keys.A);
                System.out.println("Bot " + self.getProperties().hashCode() + " go left");
                if (movementStack.peek() != 3) movementStack.push(3);
                if (self.getPhysicsState().getPhysicsBody().getX()!= oldX)
                    break;
            case 3:
                keyPress.clear();
                keyPress.add(Input.Keys.D);
                System.out.println("Bot " + self.getProperties().hashCode() + " go right");
                if (movementStack.peek() != 1) movementStack.push(1);
                break;
            case 4:
                keyPress.clear();
                if (movementStack.size()>=2) {
                    keyDown.add(Input.Keys.SPACE);
                    move(movementStack.pop());
                    move(movementStack.pop());
                }
        }
    }

}
