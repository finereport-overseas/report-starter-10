package com.fr.learn;

import com.fr.start.Designer;

public class Leaner extends Designer {

    static {
        // 这段代码让插件能支持远程设计的时候的调试
        String workDir = System.getProperty("user.dir");
        System.setProperty("fine.plugin.home", workDir + "/webroot/WEB-INF/plugins");
    }

    public Leaner(String[] strings) {
        super(strings);
    }
}
