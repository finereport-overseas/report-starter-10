package com.fr.plugin.chart.demo.ui;

import com.fr.design.formula.TinyFormulaPane;
import com.fr.extended.chart.AbstractExtendedChartReportDataPane;
import com.fr.plugin.chart.demo.fun.DemoDataConfig;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
public class DemoReportDataPane extends AbstractExtendedChartReportDataPane<DemoDataConfig> {
    private TinyFormulaPane xPane;
    private TinyFormulaPane yPane;
    private TinyFormulaPane zPane;

    @Override
    protected String[] fieldLabel() {
        return new String[]{
                "X-Axis",
                "Y-Axis",
                "Z-Axis"
        };
    }

    @Override
    protected TinyFormulaPane[] formulaPanes() {
        if (xPane == null) {
            xPane = new TinyFormulaPane();
            yPane = new TinyFormulaPane();
            zPane = new TinyFormulaPane();
        }
        return new TinyFormulaPane[]{
                xPane,
                yPane,
                zPane
        };
    }

    @Override
    protected void populate(DemoDataConfig dataConf) {
        populateField(xPane, dataConf.getX());
        populateField(yPane, dataConf.getY());
        populateField(zPane, dataConf.getZ());
    }

    @Override
    protected DemoDataConfig update() {
        DemoDataConfig dataConfig = new DemoDataConfig();

        updateField(xPane, dataConfig.getX());
        updateField(yPane, dataConfig.getY());
        updateField(zPane, dataConfig.getZ());

        return dataConfig;
    }
}
