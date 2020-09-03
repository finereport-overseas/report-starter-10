package com.fr.plugin.project.http;

import com.fr.json.JSONObject;
import com.fr.plugin.project.config.IPConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class IPConfigGetHandler extends AbstractHttpHandler {
    public static final String URL_PATH = "/demo/ip/get";

    @Override
    public String urlPath() {
        return URL_PATH;
    }

    @Override
    public void deal(HttpServletRequest req, HttpServletResponse res, JSONObject para, JSONObject result) throws Exception {
        String startIP = IPConfig.getInstance().getStartIP();
        String endIP = IPConfig.getInstance().getEndIP();
        JSONObject data = JSONObject.create().put("startIP",startIP).put("endIP",endIP);
        result.put(AbstractHttpHandler.STATE_NAME,true).put("data",data);
    }
}
