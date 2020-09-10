package com.fr.plugin.passport.demo;

import com.fr.decision.fun.impl.AbstractWebResourceProvider;
import com.fr.decision.web.MainComponent;
import com.fr.web.struct.Atom;


/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
public class DemoJSBridge extends AbstractWebResourceProvider {
    @Override
    public Atom attach() {
        return MainComponent.KEY;
    }

    @Override
    public Atom client() {
        return FileDef.KEY;
    }
}
