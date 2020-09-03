package com.fr.plugin.project.http;

import com.fr.json.JSONObject;
import com.fr.plugin.project.config.IPConfig;
import com.fr.stable.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class IPConfigSetHandler extends AbstractHttpHandler{
    public static final String URL_PATH = "/demo/ip/set";

    @Override
    public String urlPath() {
        return URL_PATH;
    }

    @Override
    public void deal(HttpServletRequest req, HttpServletResponse res, JSONObject para, JSONObject result) throws Exception {
        String startIP = para.getString("startIP", StringUtils.EMPTY);
        String endIP = para.getString("endIP", StringUtils.EMPTY);
        IPConfig.getInstance().setStartIP(startIP);
        IPConfig.getInstance().setEndIP(endIP);
        result.put(AbstractHttpHandler.STATE_NAME, true);
    }
}
