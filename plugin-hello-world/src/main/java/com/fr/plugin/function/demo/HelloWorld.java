package com.fr.plugin.function.demo;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.script.AbstractFunction;

/**
 * @author Joe
 * @version 10.0
 * Created by Joe on 4/17/2020
 */
@FunctionRecorder
public class HelloWorld extends AbstractFunction {

    @Override
    @ExecuteFunctionRecord
    public Object run(Object[] objects) {
        String parameter = (String) objects[0];
        return "Hello World!" + parameter;
    }
}
