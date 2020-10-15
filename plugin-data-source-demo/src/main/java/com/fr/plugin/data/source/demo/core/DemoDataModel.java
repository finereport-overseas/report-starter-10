package com.fr.plugin.data.source.demo.core;

import com.fr.data.AbstractDataModel;
import com.fr.general.data.TableDataException;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;

/**
 * @author Joe
 * Created by Joe on 10/15/2020
 */
public class DemoDataModel extends AbstractDataModel {
    private String[] colNames = null;

    private ParameterProvider[] parameters = new ParameterProvider[0];
    private String globalName = StringUtils.EMPTY;
    private String globalValue = StringUtils.EMPTY;
    private String others = StringUtils.EMPTY;

    /**
     * build the data model
     * @param parameters
     * @param others
     * @param globalName
     * @param globalValue
     * @return
     */
    public static DemoDataModel create(ParameterProvider[] parameters, String others, String globalName, String globalValue) {
        DemoDataModel result = new DemoDataModel();
        result.parameters = null == parameters ? new ParameterProvider[0] : parameters;
        result.others = null == others ? StringUtils.EMPTY : others;
        result.globalName = globalName;
        result.globalValue = globalValue;
        return result;
    }

    /**
     * Data Initialization.
     */
    public void initData() {
        if (colNames != null) {
            return;
        }
        if (StringUtils.isBlank(globalName)) {
            globalName = "defaultName";
        }
        colNames = new String[]{"KEY", "VALUE", "OTHERS", globalName};
    }

    @Override
    public int getColumnCount() throws TableDataException {
        initData();
        return colNames.length;
    }

    @Override
    public String getColumnName(int i) throws TableDataException {
        return colNames[i];
    }

    @Override
    public int getRowCount() throws TableDataException {
        return parameters.length;
    }

    @Override
    public Object getValueAt(int row, int col) throws TableDataException {
        if (col == 2) {
            return others;
        }
        if (col == 3) {
            return globalValue;
        }
        ParameterProvider p = parameters[row];
        return 0 == col ? p.getName() : p.getValue();
    }
}
