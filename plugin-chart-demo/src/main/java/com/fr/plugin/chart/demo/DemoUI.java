package com.fr.plugin.chart.demo;

import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.extended.chart.AbstractExtendedChartTableDataPane;
import com.fr.extended.chart.AbstractExtendedChartUIProvider;
import com.fr.extended.chart.ExtendedOtherPane;
import com.fr.plugin.chart.demo.ui.DemoReportDataPane;
import com.fr.plugin.chart.demo.ui.DemoTableDataPane;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
public class DemoUI extends AbstractExtendedChartUIProvider {

    @Override
    protected AbstractExtendedChartTableDataPane getTableDataSourcePane() {
        return new DemoTableDataPane();
    }

    @Override
    protected AbstractReportDataContentPane getReportDataSourcePane() {
        return new DemoReportDataPane();
    }

    @Override
    public String[] getDemoImagePath() {
        return new String[] {
                "com/fr/plugin/chart/demo/images/demo.png"
        };
    }

    @Override
    public String getIconPath() {
        return "com/fr/plugin/chart/demo/images/icon.png";
    }
}
