package org.academiadecodigo.bootcamp.defectpainter.mouse;

import org.academiadecodigo.simplegraphics.graphics.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Instantiate a Mouse for obtaining mouse handling capability
 */
public class Mouse implements MouseListener, MouseMotionListener {

    MouseHandler handler;
    List<MouseEventType> mouseEventArrayList;

    /**
     * @param handler the mouse handler
     */
    public Mouse(MouseHandler handler) {
        Canvas.getInstance().addMouseListener(this);
        Canvas.getInstance().addMouseMotionListener(this);

        this.handler = handler;
        mouseEventArrayList = new ArrayList<>();
    }

    /**
     * Add a new mouse event type listener
     *
     * @param eventType the event type to add
     */
    public void addEventListener(MouseEventType eventType) {
        mouseEventArrayList.add(eventType);
    }

    /**
     * Removes a mouse event type listener
     *
     * @param eventType the event type to remove
     */
    public void removeEventListener(MouseEventType eventType) {
        mouseEventArrayList.remove(eventType);
    }

    /**
     * @param e the event
     * @see MouseHandler#mouseClicked(org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent);
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_CLICKED) {
                handler.mouseClicked(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_CLICKED));
            }

        }

    }

    /**
     * @param e the event
     * @see MouseHandler#mouseMoved(org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent);
     */
    @Override
    public void mouseMoved(MouseEvent e) {

        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_MOVED) {
                handler.mouseMoved(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_MOVED));
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_PRESSED) {
                handler.mousePressed(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_PRESSED));
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_RELEASED) {
                handler.mouseReleased(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_RELEASED));
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_ENTERED) {
                handler.mouseEntered(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_ENTERED));
            }

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_EXITED) {
                handler.mouseExited(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_EXITED));
            }

        }
    }


    /**
     * @param e the event
     * @see MouseHandler#mouseDragged(org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent) (org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent);
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (handler == null) {
            return;
        }

        Iterator<MouseEventType> iterator = mouseEventArrayList.iterator();
        while (iterator.hasNext()) {
            MouseEventType et = iterator.next();
            if (et == MouseEventType.MOUSE_DRAGGED) {
                handler.mouseDragged(new org.academiadecodigo.bootcamp.defectpainter.mouse.MouseEvent(e.getX(), e.getY(), MouseEventType.MOUSE_DRAGGED));
            }

        }
    }

}
