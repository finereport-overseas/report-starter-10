package com.fr.plugin.theme.demo;

import com.fr.decision.config.AppearanceConfig;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @author Joe
 * Created by Joe on 9/23/2020
 */
@FunctionRecorder
public class DemoThemeAtom extends Component {
    public static final DemoThemeAtom KEY=new DemoThemeAtom();

    @Override
    public StylePath style(RequestClient requestClient) {
        return StylePath.build("/com/fr/plugin/theme/demo/web/button.css");
    }

    @Override
    public ScriptPath script(RequestClient requestClient) {
        return ScriptPath.build("/com/fr/plugin/theme/demo/web/provider.js");
    }

    @Override
    @ExecuteFunctionRecord
    public Filter filter() {
        return new Filter() {
            @Override
            public boolean accept() {
                /*The JS file will be imported only if the theme is chosen.*/
                return "com.fr.plugin.theme.demo".equals(AppearanceConfig.getInstance().getThemeId());
            }
        };
    }
}
