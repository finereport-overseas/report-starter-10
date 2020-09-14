package com.fr.plugin.widget.demo.para;

import com.fr.design.fun.FormWidgetOptionProvider;
import com.fr.design.fun.impl.AbstractParameterWidgetOptionProvider;
import com.fr.form.ui.Widget;
import com.fr.plugin.widget.demo.DemoWidget;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class DemoParaFormWidgetProvider extends AbstractParameterWidgetOptionProvider implements FormWidgetOptionProvider {
    /**
     * Method required in FormWidgetOptionProvider.
     * @return true if the widget is a container
     */
    @Override
    public boolean isContainer() {
        return false;
    }

    @Override
    public <T> void paste2Container(T t) {

    }

    @Override
    public Class<? extends Widget> classForWidget() {
        return DemoWidget.class;
    }

    @Override
    public Class<?> appearanceForWidget() {
        return XStyleTextEditor.class;
    }

    @Override
    public String iconPathForWidget() {
        return "/com/fr/plugin/widget/demo/images/text_field_16.png";
    }

    @Override
    public String nameForWidget() {
        return "Style Text Editor";
    }
}
