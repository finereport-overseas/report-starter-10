package com.fr.plugin.http;

import com.fr.decision.fun.impl.BaseHttpHandler;
import com.fr.json.JSONObject;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.third.springframework.web.bind.annotation.RequestMethod;
import com.fr.web.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joe
 * Created by Joe on 8/14/2020
 */
@FunctionRecorder
public class TestHandler extends BaseHttpHandler {
    @Override
    public RequestMethod getMethod() {
        return null;
    }

    @Override
    public String getPath() {
        return "/test/jsonp";
    }

    @Override
    public boolean isPublic() {
        return true;
    }

    @Override
    @ExecuteFunctionRecord
    public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        JSONObject result = JSONObject.create().put("success",true);
        WebUtils.printAsJSON(res, result);
    }
}
