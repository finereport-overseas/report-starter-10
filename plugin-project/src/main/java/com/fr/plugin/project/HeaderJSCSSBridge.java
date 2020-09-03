package com.fr.plugin.project;

import com.fr.decision.fun.impl.AbstractWebResourceProvider;
import com.fr.decision.web.MainComponent;
import com.fr.plugin.project.component.HeaderComponent;
import com.fr.web.struct.Atom;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class HeaderJSCSSBridge extends AbstractWebResourceProvider {
    @Override
    public Atom attach() {
        return MainComponent.KEY;
    }

    @Override
    public Atom client() {
        return HeaderComponent.KEY;
    }
}
