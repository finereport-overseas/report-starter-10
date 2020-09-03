package com.fr.plugin.project.http;

import com.fr.base.PropertiesUtils;
import com.fr.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class ExtendAttrHandler extends AbstractHttpHandler {
    private static final String PROPERTY_NAME = "extendAttr";
    public  static final String URL_PATH = "/demo/extend/attr";

    @Override
    public String urlPath() {
        return URL_PATH;
    }

    @Override
    public void deal(HttpServletRequest req, HttpServletResponse res, JSONObject para, JSONObject result) throws Exception {
        Properties pro = PropertiesUtils.getProperties(PROPERTY_NAME);
        String address = pro.getProperty("address");
        String companyPhone = pro.getProperty("companyPhone");
        String companyEmail = pro.getProperty("companyEmail");
        JSONObject data = JSONObject.create().put("address", address).put("companyPhone", companyPhone).put("companyEmail", companyEmail);
        result.put(AbstractHttpHandler.STATE_NAME, true).put("data", data);
    }
}
