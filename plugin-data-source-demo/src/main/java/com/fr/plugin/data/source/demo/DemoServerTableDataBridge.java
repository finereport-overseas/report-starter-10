package com.fr.plugin.data.source.demo;

import com.fr.base.TableData;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.fun.impl.AbstractServerTableDataDefineProvider;
import com.fr.plugin.data.source.demo.core.DemoTableData;
import com.fr.plugin.data.source.demo.ui.DemoTableDataPane;

/**
 * @author Joe
 * Created by Joe on 7/24/2020
 */
public class DemoServerTableDataBridge extends AbstractServerTableDataDefineProvider {
    @Override
    public Class<? extends TableData> classForTableData() {
        return DemoTableData.class;
    }

    @Override
    public Class<? extends TableData> classForInitTableData() {
        return DemoTableData.class;
    }

    @Override
    public Class<? extends AbstractTableDataPane> appearanceForTableData() {
        return DemoTableDataPane.class;
    }

    @Override
    public String nameForTableData() {
        return "Demo";
    }

    @Override
    public String prefixForTableData() {
        return "DM";
    }

    @Override
    public String iconPathForTableData() {
        return "/com/fr/plugin/data/source/demo/demo.png";
    }
}
