package com.fr.plugin.data.source.demo.core;

import com.fr.config.Identifier;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.data.AbstractParameterTableData;
import com.fr.data.core.DataCoreXmlUtils;
import com.fr.data.impl.Connection;
import com.fr.general.data.DataModel;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * @author Joe
 * Created by Joe on 10/15/2020
 */
public class DemoTableData extends AbstractParameterTableData {
    public final static String TAG = "others";
    @Identifier(TAG)
    private Conf<String> others = Holders.simple(StringUtils.EMPTY);

    // add a connection config
    @Identifier("database")
    private Conf<Connection> database = Holders.obj(null, Connection.class);

    // Database read and write for server dataset.
    public String getOthers() {
        return others.get();
    }

    public void setOthers(String others) {
        this.others.set(others);
    }

    public Connection getDatabase() {
        return this.database.get();
    }

    public void setDatabase(Connection connection) {
        this.database.set(connection);
    }

    /**
     * get the data model
     * @param calculator
     * @return
     */
    @Override
    public DataModel createDataModel(Calculator calculator) {
        // Get all parameters on the pane.
        ParameterProvider[] parameters = this.getParameters(calculator);
        // Sometimes the parameters need us to recalculate once, or you will get the default value.
        parameters = Calculator.processParameters(calculator, parameters);
        String globalName = StringUtils.EMPTY;
        String globalValue = StringUtils.EMPTY;
        Connection c = this.getDatabase();
        if (c != null && c instanceof DemoConnection) {
            globalName = ((DemoConnection) c).getGlobalColName();
            globalValue = ((DemoConnection) c).getGlobalColValue();
        }
        return DemoDataModel.create(parameters, getOthers(), globalName, globalValue);
    }

    /**
     * XML read for template dataset. Notice how we get connection.
     * @param reader
     */
    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
        if (reader.isChildNode()) {
            String tagName = reader.getTagName();
            if ("Attributes".equals(tagName)) {
                setOthers(reader.getAttrAsString(TAG, StringUtils.EMPTY));
            } else if (com.fr.data.impl.Connection.XML_TAG.equals(tagName)) {
                if (reader.getAttrAsString("class", null) != null) {
                    com.fr.data.impl.Connection con = DataCoreXmlUtils.readXMLConnection(reader);
                    this.setDatabase(con);
                }
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("Attributes").attr(TAG, getOthers()).end();
        if (this.getDatabase() != null) {
            DataCoreXmlUtils.writeXMLConnection(writer, this.getDatabase());
        }
    }
}
