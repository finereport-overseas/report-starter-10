package com.fr.plugin.project;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.fun.impl.AbstractLocaleFinder;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
@FunctionRecorder
public class MyLocaleFinder extends AbstractLocaleFinder {
    @Override
    @ExecuteFunctionRecord
    public String find() {
        return "com/fr/plugin/project/locale/main";
    }
}
