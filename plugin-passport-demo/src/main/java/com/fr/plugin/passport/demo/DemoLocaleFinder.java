package com.fr.plugin.passport.demo;

import com.fr.stable.fun.impl.AbstractLocaleFinder;

/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
public class DemoLocaleFinder extends AbstractLocaleFinder {
    @Override
    public String find() {
        return "com/fr/plugin/passport/demo/locale/main";
    }
}
