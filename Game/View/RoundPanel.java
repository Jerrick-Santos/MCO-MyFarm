/**
 * Template for a Rounded Panel template to be applied on the MYFarmGUI
 */
package Game.View;

import javax.swing.*;
import java.awt.*;

public class RoundPanel extends JPanel {
    protected Dimension arcs = new Dimension(10, 10);
    protected int strokeSize = 1;
    protected boolean shade = true;
    protected Color shadowColor = Color.black;
    protected boolean quality = true;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 150;
    protected int shadowGap = 5;

    public RoundPanel() {
        super();
        setOpaque(false);
    }

    /**
     * Overall mechanics to create a rounded panel look
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(),
                shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        if (quality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }

        if (shade) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// x position
                    shadowOffset,// y position
                    width - strokeSize - shadowOffset,
                    height - strokeSize - shadowOffset,
                    arcs.width, arcs.height);
        } else {
            shadowGap = 1;
        }

        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap,
                height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
                height - shadowGap, arcs.width, arcs.height);

        graphics.setStroke(new BasicStroke());
    }

}

