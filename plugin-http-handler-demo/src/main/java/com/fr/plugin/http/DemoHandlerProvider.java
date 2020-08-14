package com.fr.plugin.http;

import com.fr.decision.fun.HttpHandler;
import com.fr.decision.fun.impl.AbstractHttpHandlerProvider;

/**
 * @author Joe
 * Created by Joe on 8/14/2020
 */
public class DemoHandlerProvider extends AbstractHttpHandlerProvider {
    @Override
    public HttpHandler[] registerHandlers() {
        return new HttpHandler[] {
                new TestHandler()
        };
    }
}
