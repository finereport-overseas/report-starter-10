package com.fr.learn;

import com.fr.log.FineLoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Leaner {

    static {
        // 这段代码让插件能支持远程设计的时候的调试
        String workDir = System.getProperty("user.dir");
        System.setProperty("fine.plugin.home", workDir + "/webroot/WEB-INF/plugins");
    }

    public static void main(String[] args) {
        try {
            Class mainClass = Class.forName("com.fr.start.MainDesigner");
            invokeMain(mainClass, args);
        } catch (ClassNotFoundException e) {
            // MainDesigner找不到，走以前的Designer
            try {
                Class oldMainClass = Class.forName("com.fr.start.Designer");
                invokeMain(oldMainClass, args);
            } catch (ClassNotFoundException ex) {
                FineLoggerFactory.getLogger().error(e.getMessage(), e);
            }
        }
    }

    private static void invokeMain(Class clazz, String[] args) {
        try {
            Method method = clazz.getMethod("main", String[].class);
            Object[] param = new Object[] {args};
            method.invoke(clazz, param);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            FineLoggerFactory.getLogger().error(e.getMessage(), e);
        }
    }
}
