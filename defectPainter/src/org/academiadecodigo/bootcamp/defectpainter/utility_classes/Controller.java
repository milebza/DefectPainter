package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Controller implements KeyboardHandler {

    private Queue<KeyboardEvent> queue;
    private Keyboard k;

    public Controller() {
        this.queue = new LinkedList<>();
        this.k = new Keyboard(this);
        configKeys();
    }

    public Queue<KeyboardEvent> getQueue() {
        return queue;
    }

    public void configKeys() {

        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyUp);

        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyRight);

        KeyboardEvent keyLoad = new KeyboardEvent();
        keyLoad.setKey(KeyboardEvent.KEY_L);
        keyLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyLoad);

        KeyboardEvent keySave = new KeyboardEvent();
        keySave.setKey(KeyboardEvent.KEY_S);
        keySave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keySave);

        KeyboardEvent keySpacePress = new KeyboardEvent();
        keySpacePress.setKey(KeyboardEvent.KEY_SPACE);
        keySpacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keySpacePress);

        KeyboardEvent keySpaceRel = new KeyboardEvent();
        keySpaceRel.setKey(KeyboardEvent.KEY_SPACE);
        keySpaceRel.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(keySpaceRel);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        queue.offer(e);
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        queue.offer(e);

    }


}
