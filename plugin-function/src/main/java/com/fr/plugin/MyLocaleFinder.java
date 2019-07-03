package com.fr.plugin;

import com.fr.stable.fun.impl.AbstractLocaleFinder;

public class MyLocaleFinder extends AbstractLocaleFinder  {
    @Override
    public String find() {
        return "com/fr/plugin/demo";
    }
}
