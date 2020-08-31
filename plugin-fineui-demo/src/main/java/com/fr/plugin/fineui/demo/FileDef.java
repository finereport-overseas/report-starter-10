package com.fr.plugin.fineui.demo;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @author Joe
 * Created by Joe on 8/31/2020
 */
@FunctionRecorder
public class FileDef extends Component {
    public static final FileDef KEY = new FileDef();
    private FileDef(){}
    /**
     * Provide the path of the JS file we want to include.
     * @param client A client object
     * @return The path of the JS file
     */
    public ScriptPath script(RequestClient client) {
        // Return ScriptPath.Empty if no need.
        return ScriptPath.build("com/fr/plugin/fineui/demo/web/demo.js");
    }
    /**
     * Provide the path of the CSS file we want to include.
     * @param client A client object
     * @return The path of the CSS file
     */
    public StylePath style(RequestClient client) {
        // Return StylePath.Empty if no need.
        return StylePath.build("com/fr/plugin/fineui/demo/web/demo.css");
    }

    /**
     * Decide whether to load this Atom by a filter
     * @return A filter
     */
    @ExecuteFunctionRecord
    public Filter filter(){
        return new Filter() {
            @Override
            public boolean accept() {
                return true;
            }
        };
    }
}
