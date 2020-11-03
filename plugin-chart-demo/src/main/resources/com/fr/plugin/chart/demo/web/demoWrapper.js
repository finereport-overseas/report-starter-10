demoWrapper = ExtendedChart.extend({

    _init: function (dom, option) {
        var chart = echarts.init(dom);
        chart.setOption(option);
        return chart;
    }

});