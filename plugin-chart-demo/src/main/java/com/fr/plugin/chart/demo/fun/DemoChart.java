package com.fr.plugin.chart.demo.fun;

import com.fr.extended.chart.AbstractChart;
import com.fr.extended.chart.HyperLinkPara;
import com.fr.extended.chart.StringFormula;
import com.fr.general.GeneralUtils;
import com.fr.json.JSON;
import com.fr.json.JSONArray;
import com.fr.json.JSONException;
import com.fr.json.JSONFactory;
import com.fr.json.JSONObject;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.web.Repository;

import java.util.List;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
@FunctionRecorder
public class DemoChart extends AbstractChart<DemoDataConfig> {
    private static final String ID = "DEMO_CHART";
    private static final String NAME = "Demo Chart";

    @Override
    protected String getChartID() {
        return ID;
    }

    @Override
    public String getChartName() {
        return NAME;
    }

    @Override
    protected String demoImagePath() {
        return "com/fr/plugin/extended/chart/demo/demo.png";
    }

    /**
     * Create a JSON Object when previewing. Use this object to pass parameters to the front end.
     * @param dataConfig
     * @param jsonObject
     * @param repo
     * @param para
     * @throws JSONException
     */
    @Override
    @ExecuteFunctionRecord
    protected void addJSON(DemoDataConfig dataConfig, JSONObject jsonObject, Repository repo, JSONPara para) throws JSONException {

        JSONArray array = JSONFactory.createJSON(JSON.ARRAY);

        List<Object> xValues = dataConfig.getX().getValues();
        List<Object> yValues = dataConfig.getY().getValues();
        List<Object> zValues = dataConfig.getZ().getValues();

        double maxValue = Double.MIN_VALUE;
        for (int i = 0, len = xValues.size(); i < len; i++) {
            maxValue = Math.max(GeneralUtils.objectToNumber(zValues.get(i)).doubleValue(), maxValue);

            array.put(JSONFactory.createJSON(JSON.ARRAY).put(xValues.get(i)).put(yValues.get(i)).put(zValues.get(i)));
        }

        jsonObject.put("series", JSONFactory.createJSON(JSON.OBJECT).put("type", "bar3D").put("data", array)
                .put("bevelSize", 0.2).put("bevelSmoothness", 2).put("shading", "color"));

        jsonObject.put("xAxis3D", JSONFactory.createJSON(JSON.OBJECT).put("type", "category"))
                .put("yAxis3D", JSONFactory.createJSON(JSON.OBJECT).put("type", "category"))
                .put("zAxis3D", JSONFactory.createJSON(JSON.OBJECT).put("type", "value"));

        jsonObject.put("grid3D", JSONFactory.createJSON(JSON.OBJECT).put("boxWidth", 200).put("boxDepth", 80));

        jsonObject.put("visualMap", JSONFactory.createJSON(JSON.OBJECT)
                .put("max", maxValue)
                .put("color", JSONFactory.createJSON(JSON.ARRAY).put("#d94e5d").put("#eac736").put("#50a3ba")));
    }

    @Override
    protected String[] requiredJS() {
        return new String[]{
                "com/fr/plugin/chart/demo/web/demoWrapper.js",
                "com/fr/plugin/chart/demo/web/echarts.js",
                "com/fr/plugin/chart/demo/web/echarts-gl.js"
        };
    }

    /**
     * the same as the front-end object name
     * @return
     */
    @Override
    protected String wrapperName() {
        return "demoWrapper";
    }

    @Override
    protected HyperLinkPara[] hyperLinkParas() {
        return new HyperLinkPara[0];
    }

    @Override
    protected List<StringFormula> formulas() {
        return null;
    }

}
