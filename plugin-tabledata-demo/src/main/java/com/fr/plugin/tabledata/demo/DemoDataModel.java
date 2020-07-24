package com.fr.plugin.tabledata.demo;

import com.fr.data.AbstractDataModel;
import com.fr.general.data.TableDataException;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;

/**
 * @author Joe
 * Created by Joe on 7/24/2020
 */
public class DemoDataModel extends AbstractDataModel {
    public final static DemoDataModel EMPTY = new DemoDataModel();

    // For demo use, just give the fixed column names here.
    private final static String [] COL_NAMES = new String[]{"KEY","VALUE","OTHERS"};

    private ParameterProvider[] parameters = new ParameterProvider[0];

    private String others = StringUtils.EMPTY;


    public DemoDataModel(){}

    public static DemoDataModel create(ParameterProvider[] parameters, String others){
        DemoDataModel result = new DemoDataModel();
        result.parameters = null == parameters ? new ParameterProvider[0] : parameters;
        result.others= null == others ? StringUtils.EMPTY : others;
        return result;
    }

    @Override
    public int getColumnCount() throws TableDataException {
        return COL_NAMES.length;
    }

    @Override
    public String getColumnName(int colIndex) throws TableDataException {
        return COL_NAMES[colIndex];
    }

    @Override
    public int getRowCount() throws TableDataException {
        return parameters.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) throws TableDataException {
        if( 2 == colIndex ){
            return others;
        }
        ParameterProvider p = parameters[rowIndex];
        return 0 == colIndex ? p.getName() : p.getValue() ;
    }
}
