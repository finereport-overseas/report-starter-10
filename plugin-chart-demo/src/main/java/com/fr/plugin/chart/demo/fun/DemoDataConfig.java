package com.fr.plugin.chart.demo.fun;

import com.fr.extended.chart.AbstractDataConfig;
import com.fr.extended.chart.ExtendedField;
import com.fr.stable.AssistUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

/**
 * @author Joe
 * Created by Joe on 11/3/2020
 */
public class DemoDataConfig extends AbstractDataConfig {
    private ExtendedField x = new ExtendedField();
    private ExtendedField y = new ExtendedField();
    private ExtendedField z = new ExtendedField();

    public ExtendedField getX() {
        return x;
    }

    public void setX(ExtendedField x) {
        this.x = x;
    }

    public ExtendedField getY() {
        return y;
    }

    public void setY(ExtendedField y) {
        this.y = y;
    }

    public ExtendedField getZ() {
        return z;
    }

    public void setZ(ExtendedField z) {
        this.z = z;
    }

    @Override
    protected void readAttr(XMLableReader reader) {
        readExtendedField(x, "x", reader);
        readExtendedField(y, "y", reader);
        readExtendedField(z, "z", reader);
    }

    @Override
    protected void writeAttr(XMLPrintWriter writer) {
        writeExtendedField(x, "x", writer);
        writeExtendedField(y, "y", writer);
        writeExtendedField(z, "z", writer);
    }

    @Override
    public ExtendedField[] dataSetFields() {
        return new ExtendedField[]{
                x,
                y,
                z
        };
    }

    @Override
    public DemoDataConfig clone() throws CloneNotSupportedException {
        DemoDataConfig result = new DemoDataConfig();
        result.setX(this.getX().clone());
        result.setY(this.getY().clone());
        result.setZ(this.getZ().clone());
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + AssistUtils.hashCode(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DemoDataConfig
                && AssistUtils.equals(this.getX(), ((DemoDataConfig) obj).getX())
                && AssistUtils.equals(this.getY(), ((DemoDataConfig) obj).getY())
                && AssistUtils.equals(this.getZ(), ((DemoDataConfig) obj).getZ())
                ;
    }
}
