package com.fr.plugin.configfile;

import com.fr.decision.fun.impl.BaseHttpHandler;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.third.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joe
 * Created by Joe on 8/26/2020
 */
@FunctionRecorder
public class DemoHandler extends BaseHttpHandler {
    @Override
    public RequestMethod getMethod() {
        return null;
    }

    @Override
    public String getPath() {
        return "/demo/test";
    }

    @Override
    public boolean isPublic() {
        return true;
    }

    @Override
    @ExecuteFunctionRecord
    public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // Basic data type
        Config config = Config.getInstance();
        config.setDemoString("Demo String");

        // Custom data model
        CustomConfig demoConfig = new CustomConfig("Data Model");
        config.setDemocusConfig(demoConfig);

        // Collection of basic type
        List<String> stringValues = new ArrayList<>();
        stringValues.add("Data 1");
        stringValues.add("Data 2");
        config.setStringList(stringValues);

        // Collection of data model
        List<CustomConfig> customList=new ArrayList<>();
        customList.add(new CustomConfig("Data Model 1"));
        customList.add(new CustomConfig("Data Model 2"));
        config.setCustomConfigList(customList);

        // Map of basic type
        Map<String,Integer> stringMap=new HashMap<>();
        stringMap.put("Basic test 1",1);
        stringMap.put("Basic test 2",2);
        config.setStringMap(stringMap);

        // Map of data model
        Map<String,CustomConfig> customConfigMap=new HashMap<>();
        customConfigMap.put("Custom test 1",new CustomConfig("Custom test 1"));
        customConfigMap.put("Custom test 2",new CustomConfig("Custom test 2"));
        config.setCustomconfigMap(customConfigMap);
    }
}
