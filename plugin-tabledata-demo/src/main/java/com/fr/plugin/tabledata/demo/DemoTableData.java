package com.fr.plugin.tabledata.demo;

import com.fr.config.Identifier;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.data.AbstractParameterTableData;
import com.fr.general.data.DataModel;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * @author Joe
 * Created by Joe on 7/24/2020
 */
@FunctionRecorder
public class DemoTableData extends AbstractParameterTableData {
    public final static String TAG = "others";

    @Override
    @ExecuteFunctionRecord
    public DataModel createDataModel(Calculator calculator) {
        // Get all parameters on the pane.
        ParameterProvider[] parameters = this.getParameters(calculator);
        // Sometimes the parameters need us to recalculate once, or you will get the default value.
        parameters = Calculator.processParameters(calculator,parameters);
        return DemoDataModel.create(parameters, getOthers());
    }

    // Suppose we have some configuration other than parameters
    @Identifier(TAG)
    private Conf<String> others = Holders.simple(StringUtils.EMPTY);

    // Database read and write for server dataset.
    public String getOthers(){
        return others.get();
    }

    public void setOthers(String others){
        this.others.set(others);
    }

    // XML read and write for template dataset.
    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
        if (reader.isChildNode()) {
            if ("Attributes".equals(reader.getTagName())) {
                setOthers(reader.getAttrAsString(TAG,StringUtils.EMPTY));
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("Attributes").attr(TAG,getOthers()).end();
    }
}
