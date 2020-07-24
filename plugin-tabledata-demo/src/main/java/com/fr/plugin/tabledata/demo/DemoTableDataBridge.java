package com.fr.plugin.tabledata.demo;

import com.fr.base.TableData;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.fun.impl.AbstractTableDataDefineProvider;

/**
 * @author Joe
 * Created by Joe on 7/24/2020
 */
public class DemoTableDataBridge extends AbstractTableDataDefineProvider {
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
        return "/com/fr/plugin/tabledata/demo/image/demo.png";
    }
}
