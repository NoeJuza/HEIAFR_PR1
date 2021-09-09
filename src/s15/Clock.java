//==============================================================================
// HEIA-FR
//==============================================================================
package s15;

import java.awt.*;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * An analogous clock display. GUI test class for the clockwork class from the
 * exercise.
 */
public class Clock extends JPanel implements Runnable {
  
  private static int acceleration = 1;        //                           [BPS]

  /**
   * useful for getting a math-like coordinate system (flip y)
   */
  private static final AffineTransform AFFINE_TRANSFORM = new AffineTransform(
                                                                1., 0., 0., -1.,
                                                                0., 0.);

  /** debug flag */
  private static boolean  debug_ = System.getProperty("debug") != null;

  /** the Clockwork to be implemented in the exercise */
  private Clockwork aClockwork_;

  /** constructs a new clock for the current time */
  public Clock() {
    GregorianCalendar _aGregorianCalendar = new GregorianCalendar();
    int h = _aGregorianCalendar.get(Calendar.HOUR);
    int m = _aGregorianCalendar.get(Calendar.MINUTE);
    int s = _aGregorianCalendar.get(Calendar.SECOND);

    aClockwork_     = new Clockwork(h, m, s);

    /**
     * thread for updating the clock
     *
     * @see #run()
     */
    Thread anUpdateThread_ = new Thread((Runnable) this, "clock updater");
    anUpdateThread_.start();
  }

  /**
   * draws a clock needle, clocks center is supposed to be at (0,0)
   * 
   * @param g
   *          the 2D graphics object to draw with
   * @param l
   *          the length of the needle
   * @param angle
   *          the angle of the needle, from 0.0 to 1.0, zero and correspond to
   *          the 12 o'clock position, parameter is going counterclockwise
   */
  private void drawNeedle(Graphics2D g, double l, double angle) {
    Graphics2D _aGraphics2D = (Graphics2D) (g.create());
    // make the coordinate system math-like (swap y)
    _aGraphics2D.transform(AFFINE_TRANSFORM);
    // make it a math angle (in radians):
    double alpha = (1.0 - angle) - 0.75;
    if (alpha < 0.0)
      alpha += 1.0;
    alpha *= 2 * Math.PI;
    if (debug_)
      System.out.println("- alpha = " + alpha);
    _aGraphics2D.rotate(alpha);
    _aGraphics2D.draw(new Line2D.Double(0., 0., l, 0));
    _aGraphics2D.dispose();
  }

  private void drawHourMarks(Graphics2D g) {
    Graphics2D _aGraphics2D = (Graphics2D) (g.create());
    int r = Math.min(getSize().width, getSize().height)/2;

    // make the coordinate system math-like (swap y)
    _aGraphics2D.transform(AFFINE_TRANSFORM);
    
    _aGraphics2D.setPaint(Color.BLUE);
    _aGraphics2D.setStroke(new BasicStroke(r/20));

    for (int a=0; a<5; a++) {
      double alpha = a*0.25 * 2*Math.PI;
      _aGraphics2D.rotate(alpha);
      _aGraphics2D.draw(new Line2D.Double(r-r/8, 0., 0.95*r, 0));
    }
    _aGraphics2D.dispose();
  }

  /**
   * paints a very simple analogous clock for the time given be the clockwork
   */
  public void paintComponent(Graphics g) {
    Graphics2D _aGraphics2D = (Graphics2D) g;
    _aGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                  RenderingHints.VALUE_ANTIALIAS_ON);

    Dimension _aDimension = getSize();
    _aGraphics2D.setColor(Color.GRAY);
    g.fillRect(0, 0, _aDimension.width, _aDimension.height);
    int diam = Math.min(_aDimension.width, _aDimension.height);
    double r = diam / 2. - 1.;
    _aGraphics2D.translate(_aDimension.width / 2, _aDimension.height / 2);
    Ellipse2D _ellipse2D = new Ellipse2D.Double(-diam / 2, -diam / 2, diam - 1,
        diam - 1);
    _aGraphics2D.setColor(Color.white);
    _aGraphics2D.fill(_ellipse2D);
    _aGraphics2D.setStroke(new BasicStroke(diam/100));
    _aGraphics2D.setColor(Color.BLUE);
    _aGraphics2D.draw(_ellipse2D);
    
    drawHourMarks(_aGraphics2D);
    
    double h, m, s;

    //--- Check h, m s  value range (randomize if invalid)                 [BPS]
    int ih = aClockwork_.getHours();
    if (ih<0 || ih>11) h = Math.random()*12.0;
    else               h = (double)ih;
    int im = aClockwork_.getMinutes();
    if (im<0 || im>59) m = Math.random()*60.0;
    else               m = (double)im;
    int is = aClockwork_.getSeconds();
    if (is<0 || is>59) s = Math.random()*60.0;
    else               s = (double)is;

    if (debug_)
      System.out.println(((h < 10.) ? "0" : "") + ((int) h)
          + ((m < 10.) ? ":0" : ":") + ((int) m) + ((s < 10.) ? ":0" : ":")
          + ((int) s));
    _aGraphics2D.setColor(Color.black);

    // draw hours needle:
    _aGraphics2D.setStroke(new BasicStroke(diam/25, BasicStroke.CAP_ROUND, //[BPS]
                                                    BasicStroke.JOIN_ROUND));
    drawNeedle(_aGraphics2D, 0.6 * r, (h+(m/60.)) / 12.);    //            [BPS]
    // draw minutes needle:
    _aGraphics2D.setStroke(new BasicStroke(diam/50, BasicStroke.CAP_ROUND,
                                                    BasicStroke.JOIN_ROUND));
    drawNeedle(_aGraphics2D, 0.85 * r, m / 60.);
    // draw seconds needle:
    _aGraphics2D = (Graphics2D) (g.create());
    _aGraphics2D.setColor(Color.red);
    _aGraphics2D.setStroke(new BasicStroke(diam/80, BasicStroke.CAP_ROUND,
                                                    BasicStroke.JOIN_ROUND));
    drawNeedle(_aGraphics2D, 0.9 * r, s / 60.);
  }

  /**
   * make sure we haven't got a size of zero times zero pixels
   */
  public Dimension getPreferredSize() {
    return new Dimension(250, 250);
  }

  /**
   * make sure we haven't got a size of zero times zero pixels
   */
  public Dimension getMinimumSize() {
    return new Dimension(100, 100);
  }

  /**
   * the run of the updating thread: makes the clockwork to advance every second
   * and triggers a clock repaint
   */
  public void run() {
    long tw = 1000/acceleration;                   //                      [BPS]
    for (long ts = System.currentTimeMillis(); true; ts += tw) {
      long _sleeptime = ts + tw - System.currentTimeMillis();
      if (_sleeptime > 0) {
        try {
          Thread.sleep(_sleeptime);
        } catch (InterruptedException e) {
          System.err.println("aborting due to interrupt");
          return;
        }
      }
      aClockwork_.stepSecond();
      if (isVisible())
        repaint();
    }
  }
  //----------------------------------------------------------------------------
  public static void centerOnScreen(JFrame frame) {               //       [BPS]
    
    int       width       = frame.getSize().width;
    int       height      = frame.getSize().height;
    Dimension screenSize;

    //--- Recherche de la dimension de l'écran
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    //--- Evite que la fenêtre ne déborde de l'écran
    if (height > screenSize.height) height = screenSize.height;
    if (width > screenSize.width)   width  = screenSize.width;
    frame.setSize(width, height);
    
    //--- Centrage de la fenêtre de l'application
    frame.setLocation((screenSize.width  - width)  / 2,
                      (screenSize.height - height) / 2);
  }

  /** launches a framed clock */
  public static void main(String[] argv) {
    if (argv.length > 0) {
      try {
        acceleration = Integer.parseInt(argv[0]);                    //    [BPS]
      } catch (NumberFormatException e) {
        System.err.println("Parameter error: must be an integer");
        acceleration = 1;
      }
    }
    Clock _aClock = new Clock();
    JFrame _aJFrame = new JFrame("Clock");
    _aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _aJFrame.getContentPane().add(_aClock);
    _aJFrame.pack();
    centerOnScreen(_aJFrame);
    _aJFrame.setVisible(true);
  }
}