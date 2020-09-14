package com.fr.plugin.widget.demo.cell;

import com.fr.design.beans.BasicBeanPane;
import com.fr.design.fun.impl.AbstractCellWidgetOptionProvider;
import com.fr.form.ui.Widget;
import com.fr.plugin.widget.demo.DemoWidget;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class DemoCellWidgetOptionProvider extends AbstractCellWidgetOptionProvider {
    @Override
    public Class<? extends Widget> classForWidget() {
        return DemoWidget.class;
    }

    @Override
    public Class<? extends BasicBeanPane<? extends Widget>> appearanceForWidget() {
        return StyleCellTextDefinePane.class;
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
