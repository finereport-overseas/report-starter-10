package com.fr.plugin.widget.demo;

import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class ReportJavaScriptFileHandler extends AbstractJavaScriptFileHandler {
    @Override
    public String[] pathsForFiles() {
        return new String[] {
                "/com/fr/plugin/widget/demo/web/style.text.js"
        };
    }
}
