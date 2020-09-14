package com.fr.plugin.widget.demo;

import com.fr.form.ui.TextEditor;
import com.fr.general.ComparatorUtils;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.script.Calculator;
import com.fr.stable.StableUtils;
import com.fr.stable.core.NodeVisitor;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.awt.Color;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
@FunctionRecorder
public class DemoWidget extends TextEditor {
    /**
     * Add a property fontColor.
     * Need to create getter and setter.
     */
    private Color fontColor = Color.BLACK;

    /**
     * widget type
     * @return
     */
    @Override
    public String getXType() {
        return "styletext";
    }

    /**
     * To return the attribute JSON. It is passed to the front end as "widget.options"
     * Here add a new property fontColor.
     * @param repository
     * @param calculator
     * @param nodeVisitor
     * @return
     * @throws JSONException
     */
    @Override
    @ExecuteFunctionRecord
    public JSONObject createJSONConfig(Repository repository, Calculator calculator, NodeVisitor nodeVisitor) throws JSONException {
        return super.createJSONConfig(repository, calculator, nodeVisitor).put("fontColor", StableUtils.javaColorToCSSColor(this.fontColor));
    }

    public DemoWidget() {
        super();
    }

    /**
     * Read settings from the template (XML).
     */
    @Override
    public void readXML(XMLableReader xmLableReader) {
        super.readXML(xmLableReader);
        if (xmLableReader.isChildNode()) {
            String tagName = xmLableReader.getTagName();
            if (ComparatorUtils.equals(tagName, "FontColor")) {
                this.setFontColor(rgbTOColor(xmLableReader.getElementValue()));
            }
        }
    }

    /**
     * Save the settings in the template (XML).
     */

    @Override
    public void writeXML(XMLPrintWriter xmlPrintWriter) {
        super.writeXML(xmlPrintWriter);
        xmlPrintWriter.startTAG("FontColor").textNode(StableUtils.javaColorToCSSColor(this.fontColor)).end();
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    private Color rgbTOColor(String rgbStr) {
        int start = rgbStr.indexOf("(");
        int end = rgbStr.indexOf(")");
        if (start < 0 || end < 0 || start > end) {
            return Color.RED;
        }
        String colorString = rgbStr.substring(start + 1, end);
        String[] array = colorString.split(",");
        return new Color(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
    }

    @Override
    public boolean isEditor() {
        return false;
    }
}
