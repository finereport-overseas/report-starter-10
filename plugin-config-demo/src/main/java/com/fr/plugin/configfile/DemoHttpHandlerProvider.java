package com.fr.plugin.configfile;

import com.fr.decision.fun.HttpHandler;
import com.fr.decision.fun.impl.AbstractHttpHandlerProvider;

/**
 * @author Joe
 * Created by Joe on 8/26/2020
 */
public class DemoHttpHandlerProvider extends AbstractHttpHandlerProvider {
    @Override
    public HttpHandler[] registerHandlers() {
        return new HttpHandler[] {
                new DemoHandler()
        };
    }
}
