package com.fr.plugin.theme.demo;

import com.fr.decision.fun.impl.AbstractThemeVariousProvider;
import com.fr.decision.web.MainComponent;
import com.fr.web.struct.Atom;

/**
 * @author Joe
 * Created by Joe on 9/23/2020
 */
public class DemoTheme extends AbstractThemeVariousProvider {
    @Override
    public String name() {
        return "demotheme";
    }

    @Override
    public String text() {
        return "demo";
    }

    @Override
    public String coverPath() {
        return null;
    }

    @Override
    public Atom attach() {
        return MainComponent.KEY;
    }

    @Override
    public Atom client() {
        return DemoThemeAtom.KEY;
    }
}
