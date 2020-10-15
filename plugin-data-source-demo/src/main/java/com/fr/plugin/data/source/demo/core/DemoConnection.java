package com.fr.plugin.data.source.demo.core;

import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.data.impl.AbstractDatabaseConnection;
import com.fr.general.ComparatorUtils;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * @author Joe
 * Created by Joe on 10/13/2020
 */
@FunctionRecorder
public class DemoConnection extends AbstractDatabaseConnection {

    private Conf<String> globalColName = Holders.simple(StringUtils.EMPTY);
    private Conf<String> globalColValue = Holders.simple(StringUtils.EMPTY);

    /**
     * To test the connection. Throw exception if it fails.
     * @throws Exception
     */
    @Override
    @ExecuteFunctionRecord
    public void testConnection() throws Exception {
        if(StringUtils.isBlank(this.getGlobalColName())){
            throw new Exception();
        }
    }

    /**
     * Return the driver of a connection. No need here.
     * @return
     */
    @Override
    public String getDriver() {
        return null;
    }

    public String getGlobalColName() {
        return globalColName.get();
    }

    public void setGlobalColName(String globalColName) {
        this.globalColName.set(globalColName);
    }

    public String getGlobalColValue() {
        return globalColValue.get();
    }

    public void setGlobalColValue(String globalColValue) {
        this.globalColValue.set(globalColValue);
    }

    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
        if(reader.isChildNode()){
            String tagName=reader.getTagName();
            if(ComparatorUtils.equals("Attr",tagName)){
                this.setGlobalColName(reader.getAttrAsString("colName",StringUtils.EMPTY));
                this.setGlobalColValue(reader.getAttrAsString("colValue",StringUtils.EMPTY));
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("Attr").attr("colName",this.getGlobalColName()).attr("colValue",this.getGlobalColValue()).end();
    }
}
