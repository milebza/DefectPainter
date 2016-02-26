package org.academiadecodigo.bootcamp.defectpainter.mouse;

/**
 * Interface to be implemented by all classes that want to receive mouse events
 *
 * @see MouseEvent
 */
public interface MouseHandler {

    /**
     * @param e the event
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    public void mouseClicked(MouseEvent e);

    /**
     * @param e
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e);

    /**
     * @param e
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e);

}
