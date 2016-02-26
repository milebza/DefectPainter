package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Controller implements KeyboardHandler, MouseHandler {

    private Queue<KeyboardEvent> queueKeyboard;
    private Queue<MouseEvent> queueMouse;
    private Keyboard keyboard;
    private Mouse mouse;

    public Controller() {
        this.queueKeyboard = new LinkedList<>();
        this.queueMouse = new LinkedList<>();
        this.keyboard = new Keyboard(this);
        this.mouse = new Mouse(this);
        configKeys();
        configMouse();
    }

    public Queue<KeyboardEvent> getQueueKeyboard() {
        return queueKeyboard;
    }

    public Queue<MouseEvent> getQueueMouse() {
        return queueMouse;
    }

    public void configMouse() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
    }

    public void configKeys() {


        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyUp);

        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyRight);

        KeyboardEvent keyLoad = new KeyboardEvent();
        keyLoad.setKey(KeyboardEvent.KEY_L);
        keyLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyLoad);

        KeyboardEvent keySave = new KeyboardEvent();
        keySave.setKey(KeyboardEvent.KEY_S);
        keySave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keySave);

        KeyboardEvent keyCursor = new KeyboardEvent();
        keyCursor.setKey(KeyboardEvent.KEY_C);
        keyCursor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyCursor);

        KeyboardEvent keyExit = new KeyboardEvent();
        keyExit.setKey(KeyboardEvent.KEY_X);
        keyExit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyExit);

        KeyboardEvent keyReset = new KeyboardEvent();
        keyReset.setKey(KeyboardEvent.KEY_R);
        keyReset.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyReset);

        KeyboardEvent keySpacePress = new KeyboardEvent();
        keySpacePress.setKey(KeyboardEvent.KEY_SPACE);
        keySpacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keySpacePress);

        KeyboardEvent keySpaceRel = new KeyboardEvent();
        keySpaceRel.setKey(KeyboardEvent.KEY_SPACE);
        keySpaceRel.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keySpaceRel);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        queueKeyboard.offer(e);
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        queueKeyboard.offer(e);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        queueMouse.offer(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}
