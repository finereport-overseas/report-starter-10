package com.fr.plugin.project;

import com.fr.decision.fun.HttpHandler;
import com.fr.decision.fun.impl.AbstractHttpHandlerProvider;
import com.fr.plugin.project.http.ExtendAttrHandler;
import com.fr.plugin.project.http.IPConfigGetHandler;
import com.fr.plugin.project.http.IPConfigSetHandler;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class HttpHandlerBridge extends AbstractHttpHandlerProvider {
    @Override
    public HttpHandler[] registerHandlers() {
        return new HttpHandler[] {
                new ExtendAttrHandler(),
                new IPConfigGetHandler(),
                new IPConfigSetHandler()
        };
    }
}
