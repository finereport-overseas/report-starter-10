package com.fr.plugin.project.component;

import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class HeaderComponent extends Component {
    public static final HeaderComponent KEY = new HeaderComponent();

    private HeaderComponent() {

    }

    @Override
    public ScriptPath script(RequestClient client) {
        return ScriptPath.build("com/fr/plugin/project/web/header.js");
    }

    @Override
    public StylePath style(RequestClient client) {
        return StylePath.build("com/fr/plugin/project/web/header.css");
    }

    @Override
    public Filter filter() {
        return new Filter() {
            public boolean accept() {
                return true;
            }
        };
    }
}
