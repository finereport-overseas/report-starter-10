package com.fr.plugin.widget.demo.para;

import com.fr.design.Exception.ValidationException;
import com.fr.design.gui.ibutton.UIColorButton;
import com.fr.design.mainframe.widget.editors.AbstractPropertyEditor;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Component;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class StyleColorAttrEditor extends AbstractPropertyEditor {
    /**
     * A button to set font color.
     */
    private UIColorButton colorButton = new UIColorButton();

    public StyleColorAttrEditor() {
        super();
        /**
         * Add a change listener to the color select button.
         * The color change will modify the propertyChangeEvent of the property pane.
         */
        colorButton.addColorChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                firePropertyChanged();
            }
        });
    }

    /**
     * Set value for the current property.
     * @param value
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Color){
            this.colorButton.setColor((Color) value);
            this.colorButton.repaint();
        }
    }

    /**
     * This method will be called to return property value when firePropertyChanged() is invoked.
     * @return
     */
    @Override
    public Object getValue() {
        return this.colorButton.getColor();
    }

    /**
     * The actual component shown on the property pane.
     * @return
     */
    @Override
    public Component getCustomEditor() {
        return colorButton;
    }

    /**
     * Value validation method.
     * @throws ValidationException
     */
    @Override
    public void validateValue() throws ValidationException {

    }
}
