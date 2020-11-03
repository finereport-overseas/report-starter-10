package com.fr.plugin.chart.demo.ui;

import com.fr.design.gui.icombobox.UIComboBox;
import com.fr.extended.chart.AbstractExtendedChartTableDataPane;
import com.fr.plugin.chart.demo.fun.DemoDataConfig;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
public class DemoTableDataPane extends AbstractExtendedChartTableDataPane<DemoDataConfig> {
    private UIComboBox xComboBox;
    private UIComboBox yComboBox;
    private UIComboBox zComboBox;

    @Override
    protected String[] fieldLabels() {
        return new String[]{
                "X-Axis",
                "Y-Axis",
                "Z-Axis"
        };
    }

    @Override
    protected UIComboBox[] filedComboBoxes() {
        if (xComboBox == null) {
            xComboBox = new UIComboBox();
            yComboBox = new UIComboBox();
            zComboBox = new UIComboBox();
        }
        return new UIComboBox[]{
                xComboBox,
                yComboBox,
                zComboBox
        };
    }

    @Override
    protected void populate(DemoDataConfig dataConf) {
        populateField(xComboBox, dataConf.getX());
        populateField(yComboBox, dataConf.getY());
        populateField(zComboBox, dataConf.getZ());
    }

    @Override
    protected DemoDataConfig update() {
        DemoDataConfig dataConfig = new DemoDataConfig();

        updateField(xComboBox, dataConfig.getX());
        updateField(yComboBox, dataConfig.getY());
        updateField(zComboBox, dataConfig.getZ());

        return dataConfig;
    }
}
