package com.fr.plugin.widget.demo.para;

import com.fr.design.designer.creator.CRPropertyDescriptor;
import com.fr.design.designer.creator.XTextEditor;
import com.fr.form.ui.TextEditor;
import com.fr.stable.ArrayUtils;

import java.awt.Dimension;
import java.beans.IntrospectionException;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class XStyleTextEditor extends XTextEditor {
    public XStyleTextEditor(TextEditor textEditor, Dimension dimension) {
        super(textEditor, dimension);
    }

    /**
     * Since the widget add a new property fontColor, we need to rewrite the property pane.
     *
     * @return
     * @throws IntrospectionException
     */
    @Override
    public CRPropertyDescriptor[] supportedDescriptor() throws IntrospectionException {
        CRPropertyDescriptor[] sup = super.supportedDescriptor();
        /**
         * "fontColor" is the new property name.
         * this.data.getClass() is the widget class.
         * getFontColor and setFontColor are the getter and setter for the property. That's why we should define them in DemoWidget.
         * setI18NName returns the label name. We are supposed to use Locale Finder in real development.
         * setEditorClass is to set the editing pane of the property. StyleColorAttrEditor is what we implemented to edit color.
         * putKeyValue("category", "Fine-Design_Report_Advanced") is to set the parent pane for the current property.
         */
        CRPropertyDescriptor styleAttr = new CRPropertyDescriptor("fontColor", this.data.getClass(),"getFontColor","setFontColor").setI18NName("Font Color")
                .setEditorClass(StyleColorAttrEditor.class).putKeyValue("category", "Fine-Design_Report_Advanced");
        return ArrayUtils.addAll(sup,new CRPropertyDescriptor[]{styleAttr});
    }
}
