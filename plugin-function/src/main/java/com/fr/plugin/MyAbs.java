package com.fr.plugin;

import com.fr.general.FArray;
import com.fr.general.GeneralUtils;
import com.fr.intelli.record.Focus;
import com.fr.intelli.record.Original;
import com.fr.plugin.context.PluginContexts;
import com.fr.record.analyzer.EnableMetrics;
import com.fr.script.AbstractFunction;
import com.fr.stable.ArrayUtils;
import com.fr.stable.Primitive;
import com.fr.stable.fun.Authorize;

@EnableMetrics
@Authorize(callSignKey = MyFunctionConstants.PLUGIN_ID)
public class MyAbs extends AbstractFunction  {

    @Focus(id = "com.fr.plugin.function.test", text = "Plugin-Test_Function_Abs", source = Original.PLUGIN)
    public Object run(Object[] args) {
        if (!PluginContexts.currentContext().isAvailable()) {
            return "Error:authorization is expired.";
        }
        int len = ArrayUtils.getLength(args);
        if (len == 0) {
            return Primitive.ERROR_VALUE;
        } else if (len == 1) {
            Object one = args[0];
            if (one instanceof FArray) {
                FArray data = (FArray)one;
                FArray<Double> result = new FArray<Double>();
                for (Object el : data) {
                    result.add(Math.abs(GeneralUtils.objectToNumber(el).doubleValue()));
                }
                return result;
            } else {
                return Math.abs(GeneralUtils.objectToNumber(one).doubleValue());
            }
        } else {
            FArray<Double> result = new FArray<Double>();
            for (Object arg : args) {
                result.add(Math.abs(GeneralUtils.objectToNumber(arg).doubleValue()));
            }
            return result;
        }

    }
}
