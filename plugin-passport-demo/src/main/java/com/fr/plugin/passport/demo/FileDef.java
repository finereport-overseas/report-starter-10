package com.fr.plugin.passport.demo;

import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
public class FileDef extends Component {
    public static final FileDef KEY = new FileDef();
    private FileDef(){}

    public ScriptPath script(RequestClient client) {
        return ScriptPath.build("com/fr/plugin/passport/demo/web/demo.js");
    }

    public StylePath style(RequestClient client) {
        return StylePath.EMPTY;
    }

    public Filter filter(){
        return new Filter() {
            @Override
            public boolean accept() {
                return true;
            }
        };
    }
}
