package pelajaran1;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import org.jdesktop.animation.timing.Animator;
//import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author usu
 */
public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Animation animationShow = Animation.NO_ANIMATION;
    private Animation animationHide = Animation.NO_ANIMATION;
    private int animationTime = 1000;
  //  private Animator animator;
    private Point targetLocation;
    private Point startLocation;

    public Frame() {
        super();
        setAnimationShow(Animation.NO_ANIMATION);
        setAnimationHide(Animation.NO_ANIMATION);
        setAnimationTime(1000);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(int miliSecond) throws IllegalArgumentException {
        if (miliSecond < 0) {
            throw new IllegalArgumentException("Time can not negative");
        }
        firePropertyChange("animationTime", getAnimationTime(), miliSecond);
        this.animationTime = miliSecond;
    }

    public Animation getAnimationShow() {
        return animationShow;
    }

    public void setAnimationShow(Animation animation) {
        firePropertyChange("animation", getAnimationShow(), animation);
        this.animationShow = animation;
    }

    public Animation getAnimationHide() {
        return animationHide;
    }

    public void setAnimationHide(Animation animationHide) {
        firePropertyChange("animationHide", getAnimationHide(), animationHide);
        this.animationHide = animationHide;
    }

   // @Override
    //public void setVisible(boolean b) {
       /*  / if (animator != null) {
      //      if (animator.isRunning()) {
                return;
            }
        }
       // if (b) {
            if (isVisible()) {
                return;
            }
            if (getAnimationShow() == Animation.NO_ANIMATION) {
                if (targetLocation != null) {
                    setLocation(targetLocation);
                }
                super.setVisible(b);
            } else {
                final Dimension screenDimention = Toolkit.getDefaultToolkit().getScreenSize();
                if (targetLocation == null) {
                    targetLocation = new Point(getLocation());
                }
                if (getAnimationShow() == Animation.SHOW_FROM_BOTTOM) {
                    startLocation = new Point(targetLocation.x, targetLocation.y + screenDimention.height);
                    if (startLocation.y <= screenDimention.height) {
                        startLocation.y = screenDimention.height - 1;
                    }
                    setLocation(startLocation);
                    super.setVisible(b);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "y", targetLocation.y));
                    animator.start();
                } else if (getAnimationShow() == Animation.SHOW_FROM_LEFT) {
                    startLocation = new Point(targetLocation.x - screenDimention.width, targetLocation.y);
                    if (startLocation.x + getWidth() > 0) {
                        startLocation.x = 0 - getWidth() - 1;
                    }
                    setLocation(startLocation);
                    super.setVisible(b);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "x", targetLocation.x));
                    animator.start();
                } else if (getAnimationShow() == Animation.SHOW_FROM_RIGHT) {
                    startLocation = new Point(targetLocation.x + screenDimention.width, targetLocation.y);
                    if (startLocation.x <= screenDimention.width) {
                        startLocation.x = screenDimention.width + 1;
                    }
                    setLocation(startLocation);
                    super.setVisible(b);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "x", targetLocation.x));
                    animator.start();
                } else if (getAnimationShow() == Animation.SHOW_FROM_TOP) {
                    startLocation = new Point(targetLocation.x, targetLocation.y - screenDimention.height);
                    if (startLocation.y + getHeight() > 0) {
                        startLocation.y = 0 - getHeight() - 1;
                    }
                    setLocation(startLocation);
                    super.setVisible(b);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "y", targetLocation.y));
                    animator.start();
                } else {
                    super.setVisible(b);
                }
            }
        } else {
            if (!isVisible()) {
                return;
            }
            if (getAnimationHide() == Animation.NO_ANIMATION) {
                super.setVisible(b);
            } else {
                final Dimension screenDimention = Toolkit.getDefaultToolkit().getScreenSize();
                targetLocation = new Point(getLocation());
                if (getAnimationHide() == Animation.HIDE_TO_BOTTOM) {
                    startLocation = new Point(targetLocation.x, targetLocation.y + screenDimention.height + getHeight());
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "y", startLocation.y));
                    animator.start();
                    new Thread(new Runnable() {

                        public void run() {
                            try {
                                while (getY() <= screenDimention.height) {
                                    Thread.sleep(100);
                                }
                            } catch (InterruptedException e) {
                            // ERROR
                            } finally {
                                Frame.super.setVisible(false);
                            }
                        }
                    }).start();
                } else if (getAnimationHide() == Animation.HIDE_TO_LEFT) {
                    startLocation = new Point(targetLocation.x - screenDimention.width - getWidth(), targetLocation.y);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "x", startLocation.x));
                    animator.start();
                    new Thread(new Runnable() {

                        public void run() {
                            try {
                                while (getX() + getWidth() >= 0) {
                                    Thread.sleep(100);
                                }
                            } catch (InterruptedException e) {
                            // ERROR
                            } finally {
                                Frame.super.setVisible(false);
                            }
                        }
                    }).start();
                } else if (getAnimationHide() == Animation.HIDE_TO_RIGHT) {
                    startLocation = new Point(targetLocation.x + screenDimention.width + getWidth(), targetLocation.y);
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "x", startLocation.x));
                    animator.start();
                    new Thread(new Runnable() {

                        public void run() {
                            try {
                                while (getX() <= screenDimention.width) {
                                    Thread.sleep(100);
                                }
                            } catch (InterruptedException e) {
                            // ERROR
                            } finally {
                                Frame.super.setVisible(false);
                            }
                        }
                    }).start();
                } else if (getAnimationHide() == Animation.HIDE_TO_TOP) {
                    startLocation = new Point(targetLocation.x, targetLocation.y - screenDimention.height - getHeight());
                    animator = new Animator(getAnimationTime());
                    animator.setAcceleration(0.2F);
                    animator.setDeceleration(0.5F);
                    animator.addTarget(new PropertySetter(this, "y", startLocation.y));
                    animator.start();
                    new Thread(new Runnable() {

                        public void run() {
                            try {
                                while (getY() + getHeight() >= 0) {
                                    Thread.sleep(100);
                                }
                            } catch (InterruptedException e) {
                            // ERROR
                            } finally {
                                Frame.super.setVisible(false);
                            }
                        }
                    }).start();
                } else {
                    super.setVisible(b);
                }
            }
        }
    }*/

    public void exit() {
        setVisible(false);
        new Thread(new Runnable() {

            public void run() {
                try {
                    while (isVisible()) {
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                // Error
                } finally {
                    System.exit(0);
                }
            }
        }).start();
    }

    public void setX(int x) {
        Point location = getLocation();
        location.x = x;
        super.setLocation(location);
    }

    public void setY(int y) {
        Point location = getLocation();
        location.y = y;
        super.setLocation(location);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
