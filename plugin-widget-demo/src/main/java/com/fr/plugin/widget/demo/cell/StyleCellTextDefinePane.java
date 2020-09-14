package com.fr.plugin.widget.demo.cell;

import com.fr.design.widget.ui.TextFieldEditorDefinePane;
import com.fr.form.ui.TextEditor;
import com.fr.plugin.widget.demo.DemoWidget;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class StyleCellTextDefinePane extends TextFieldEditorDefinePane {
    private ColorSelectPane colorSelectPane;

    /**
     * Add a custom-defined color select pane.
     * @return
     */
    @Override
    protected JPanel setFirstContentPane() {
        JPanel supPane = super.setFirstContentPane();
        colorSelectPane = new ColorSelectPane();
        supPane.add(colorSelectPane, BorderLayout.CENTER);
        return supPane;
    }

    /**
     * Set value for the color select pane.
     * @param textEditor
     */
    @Override
    protected void populateSubFieldEditorBean(TextEditor textEditor) {
        super.populateSubFieldEditorBean(textEditor);
        if(textEditor instanceof DemoWidget){
            this.colorSelectPane.setColor(((DemoWidget) textEditor).getFontColor());
        }
    }

    /**
     * Put the value from the color select pane to the widget object.
     * @return
     */
    @Override
    protected TextEditor updateSubFieldEditorBean() {
        TextEditor supEditor = super.updateSubFieldEditorBean();
        if (supEditor instanceof DemoWidget){
            ((DemoWidget) supEditor).setFontColor(this.colorSelectPane.getColor());
        }
        return supEditor;
    }

    /**
     * @return a custom widget object.
     */
    @Override
    protected TextEditor newTextEditorInstance() {
        return new DemoWidget();
    }
}
