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
     * installUI configures the look and feel of the overall component
     * @param component the component where this UI delegate is being installed
     */
    @Override
    public void installUI (JComponent component) {
        super.installUI(component);
        AbstractButton button = (AbstractButton) component;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(4, 14, 4, 14));
    }

    /**
     * paint sets or paints the graphics in the button
     * @param graphics the <code>Graphics</code> context in which to paint
     * @param component the component being painted;
     *          this argument is often ignored,
     *          but might be used if the UI object is stateless
     *          and shared by multiple components
     */
    @Override
    public void paint (Graphics graphics, JComponent component) {
        AbstractButton button = (AbstractButton) component;
        createBackground(graphics, button, button.getModel().isPressed() ? 2 : 0);
        super.paint(graphics, component);
    }

    /**
     * paintBackground customizes the button to acquire a shadow effect.
     * @param graphics the <code>Graphics</code> context in which to paint
     * @param component the component being painted;
     *                 this argument is often ignored,
     *                 but might be used if the UI object is stateless
     *                 and shared by multiple components
     * @param yValue y-value for Round Rectangle method
     */
    private void createBackground (Graphics graphics, JComponent component, int yValue) {
        Graphics2D renderGraphics = (Graphics2D) graphics;
        renderGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(component.getBackground().darker());
        Dimension size = component.getSize();
        graphics.fillRoundRect(0, yValue, size.width, size.height - yValue, 9, 9);
        graphics.setColor(component.getBackground());

        // second Round Rectangle for shadow effect
        graphics.fillRoundRect(0, yValue, size.width, size.height + yValue - 4, 9, 9);
    }
}
