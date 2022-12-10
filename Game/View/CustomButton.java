/**
 * Template for button alterations and to change the overall look of the buttons in MyFarmGUI
 */
package Game.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomButton extends BasicButtonUI {

    /**
     * Configures the look and feel of the overall component
     * @param component the component where this UI delegate is being installed
     *
     */
    @Override
    public void installUI (JComponent component) {
        super.installUI(component);
        AbstractButton button = (AbstractButton) component;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    /**
     * sets or paints the graphics in the button
     * @param graphics the <code>Graphics</code> context in which to paint
     * @param component the component being painted;
     *          this argument is often ignored,
     *          but might be used if the UI object is stateless
     *          and shared by multiple components
     *
     */
    @Override
    public void paint (Graphics graphics, JComponent component) {
        AbstractButton button = (AbstractButton) component;
        paintBackground(graphics, button, button.getModel().isPressed() ? 2 : 0);
        super.paint(graphics, component);
    }

    private void paintBackground (Graphics graphics, JComponent component, int yOffset) {
        Dimension size = component.getSize();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(component.getBackground().darker());
        graphics.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        graphics.setColor(component.getBackground());
        graphics.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
}
