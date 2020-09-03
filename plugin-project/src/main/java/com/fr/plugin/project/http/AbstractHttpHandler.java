package com.fr.plugin.project.http;

import com.fr.decision.fun.impl.BaseHttpHandler;
import com.fr.json.JSONObject;
import com.fr.third.springframework.web.bind.annotation.RequestMethod;
import com.fr.web.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public abstract class AbstractHttpHandler extends BaseHttpHandler {
    public static final String STATE_NAME = "success";

    @Override
    public RequestMethod getMethod() {
        return null;
    }

    @Override
    public String getPath() {
        return urlPath();
    }

    public abstract String urlPath();

    @Override
    public boolean isPublic() {
        return false;
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        JSONObject para = receiveJSONPara(req);
        JSONObject resultJson = JSONObject.create().put(STATE_NAME, false);
        deal(req, res, para, resultJson);
        WebUtils.printAsJSON(res, resultJson);
    }

    public abstract void deal(HttpServletRequest req, HttpServletResponse res, JSONObject para, JSONObject result) throws Exception;

    /**
     * Get parameters in JSON
     *
     * @param req
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public JSONObject receiveJSONPara(HttpServletRequest req) throws IOException, UnsupportedEncodingException {
        JSONObject result = JSONObject.create();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return new JSONObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
