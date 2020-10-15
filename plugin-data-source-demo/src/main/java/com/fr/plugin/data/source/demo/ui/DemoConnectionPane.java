package com.fr.plugin.data.source.demo.ui;

import com.fr.design.border.UITitledBorder;
import com.fr.design.data.datapane.connect.DatabaseConnectionPane;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.plugin.data.source.demo.core.DemoConnection;

import javax.swing.JPanel;
import java.awt.Component;

/**
 * @author Joe
 * Created by Joe on 10/13/2020
 */
public class DemoConnectionPane extends DatabaseConnectionPane<DemoConnection> {
    // define a text field for column name
    private UITextField colName;
    // for column value
    private UITextField colValue;
    private final static double P = TableLayout.PREFERRED;

    /**
     * Defined in DatabaseConnectionPane. To get the main panel.
     * @return
     */
    @Override
    protected JPanel mainPanel() {
        return creatMainPanel();
    }

    @Override
    protected boolean isFineBI() {
        return false;
    }

    /**
     * Defined in DatabaseConnectionPane. Reload the setting panel according to the connection object.
     * @param demoConnection
     */
    @Override
    protected void populateSubDatabaseConnectionBean(DemoConnection demoConnection) {
        this.colName.setText(demoConnection.getGlobalColName());
        this.colValue.setText(demoConnection.getGlobalColValue());
    }

    /**
     * Generate a new connection obj based on the setting panel.
     * @return
     */

    @Override
    protected DemoConnection updateSubDatabaseConnectionBean() {
        DemoConnection demoConnection = new DemoConnection();
        demoConnection.setGlobalColName(this.colName.getText());
        demoConnection.setGlobalColValue(this.colValue.getText());
        return demoConnection;
    }

    /**
     * title of the window
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return "demoConnection";
    }

    /**
     * Here add two text fields to the panel.
     * @return
     */
    public JPanel creatMainPanel() {
        colName = new UITextField();
        colValue = new UITextField();
        Component[][] tables = {{
                new UILabel("Column Name"), colName
        }, {
                new UILabel("Column Value"), colValue
        }};
        JPanel tableLayoutPane = TableLayoutHelper.createTableLayoutPane(tables, new double[]{P, P}, new double[]{P, 400});
        tableLayoutPane.setBorder(UITitledBorder.createBorderWithTitle("demo Connection"));
        return tableLayoutPane;
    }
}
