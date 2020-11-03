package com.fr.plugin.chart.demo;

import com.fr.extended.chart.AbstractChart;
import com.fr.extended.chart.AbstractExtentChartProvider;
import com.fr.plugin.chart.demo.fun.DemoChart;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
public class Demo extends AbstractExtentChartProvider {
    @Override
    protected AbstractChart createChart() {
        return new DemoChart();
    }
}
