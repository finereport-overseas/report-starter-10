package com.fr.plugin.project;

import com.fr.decision.fun.impl.AbstractURLAliasProvider;
import com.fr.decision.webservice.url.alias.URLAlias;
import com.fr.decision.webservice.url.alias.URLAliasFactory;
import com.fr.plugin.project.http.ExtendAttrHandler;
import com.fr.plugin.project.http.IPConfigGetHandler;
import com.fr.plugin.project.http.IPConfigSetHandler;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class URLAliasBridge extends AbstractURLAliasProvider {
    @Override
    public URLAlias[] registerAlias() {
        return new URLAlias[] {
                URLAliasFactory.createPluginAlias("/demo/extend/attr", ExtendAttrHandler.URL_PATH, false),
                URLAliasFactory.createPluginAlias("/demo/ip/get", IPConfigGetHandler.URL_PATH, false),
                URLAliasFactory.createPluginAlias("/demo/ip/set", IPConfigSetHandler.URL_PATH, false)
        };
    }
}
