package com.fr.plugin.resource.replace.demo;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.fun.impl.AbstractResourcePathTransformer;

/**
 * @author Joe
 * Created by Joe on 7/30/2020
 */
@FunctionRecorder
public class ResourceReplace extends AbstractResourcePathTransformer {

    private final static String LOGIN_PAGE = "/com/fr/web/controller/decision/entrance/resources/login.html";

    @Override
    public boolean accept(String oldPath) {
        return LOGIN_PAGE.equals(oldPath);
    }

    @Override
    @ExecuteFunctionRecord
    public String transform(String oldPath) {
        return "/com/fr/plugin/resource/replace/demo/web/login.html";
    }
}
