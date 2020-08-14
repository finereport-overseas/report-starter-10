package com.fr.plugin.http;

import com.fr.decision.fun.impl.AbstractURLAliasProvider;
import com.fr.decision.webservice.url.alias.URLAlias;
import com.fr.decision.webservice.url.alias.URLAliasFactory;

/**
 * @author Joe
 * Created by Joe on 8/14/2020
 */
public class DemoURLAliasProvider extends AbstractURLAliasProvider {
    @Override
    public URLAlias[] registerAlias() {
        return new URLAlias[] {
                URLAliasFactory.createPluginAlias("/demo", "/test/jsonp", true)
        };
    }
}
