package Game.View;

import javax.swing.*;
import java.awt.*;

/**
 * Template for a Rounded Panel template to be applied on the MYFarmGUI
 */
public class RoundPanel extends JPanel {
    private Dimension dimension = new Dimension(10, 10);
    private int strokeSize = 3;
    private boolean shade = true;
    private Color shadowColor = Color.DARK_GRAY;
    private boolean quality = true;
    private int shadowUnder = 9;
    private int shadowOver = 150;
    private int gap = 5;

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
        int shadowGap = this.gap;
        Color shadowColorA = new Color(this.shadowColor.getRed(),
                this.shadowColor.getGreen(), this.shadowColor.getBlue(), this.shadowOver);
        Graphics2D graphics = (Graphics2D) g;

        if (quality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }

        if (shade) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    this.shadowUnder,// x position
                    this.shadowUnder,// y position
                    width - this.strokeSize - this.shadowUnder,
                    height - this.strokeSize - this.shadowUnder,
                    this.dimension.width, this.dimension.height);
        } else {
            shadowGap = 1;
        }


        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
                height - shadowGap, this.dimension.width, this.dimension.height);

        graphics.setStroke(new BasicStroke());
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap,
                height - shadowGap, this.dimension.width, this.dimension.height);
        graphics.setColor(getForeground());
    }

}

