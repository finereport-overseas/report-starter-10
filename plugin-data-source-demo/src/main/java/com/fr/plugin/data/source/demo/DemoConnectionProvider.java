package com.fr.plugin.data.source.demo;

import com.fr.data.impl.Connection;
import com.fr.design.beans.BasicBeanPane;
import com.fr.design.fun.impl.AbstractConnectionProvider;
import com.fr.plugin.data.source.demo.core.DemoConnection;
import com.fr.plugin.data.source.demo.ui.DemoConnectionPane;

/**
 * @author Joe
 * Created by Joe on 10/14/2020
 */
public class DemoConnectionProvider extends AbstractConnectionProvider {
    @Override
    public String nameForConnection() {
        return "demoConnection";
    }

    @Override
    public String iconPathForConnection() {
        return null;
    }

    @Override
    public Class<? extends Connection> classForConnection() {
        return DemoConnection.class;
    }

    @Override
    public Class<? extends BasicBeanPane<? extends Connection>> appearanceForConnection() {
        return DemoConnectionPane.class;
    }
}
