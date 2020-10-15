package com.fr.plugin.data.source.demo.ui;

import com.fr.data.impl.Connection;
import com.fr.design.data.datapane.connect.ConnectionComboBoxPanel;
import com.fr.design.dialog.BasicPane;
import com.fr.plugin.data.source.demo.core.DemoConnection;

import java.awt.BorderLayout;
import java.util.List;

/**
 * @author Joe
 * Created by Joe on 10/15/2020
 */
public class DemoConnectionChoosePane extends BasicPane {
    // connection combo box panel implemented for us
    private ConnectionComboBoxPanel connectionComboBoxPanel;

    public DemoConnectionChoosePane() {
        setLayout(new BorderLayout(4, 4));
        /**
         * instantiate the connectionComboBoxPanel
         */
        connectionComboBoxPanel = new ConnectionComboBoxPanel(Connection.class) {
            /**
             * filter the connection types to be chosen
             * @param connection
             * @param conName
             * @param nameList
             */
            protected void filterConnection(Connection connection, String conName, List<String> nameList) {
                connection.addConnection(nameList, conName, new Class[]{DemoConnection.class});
            }
        };
        add(connectionComboBoxPanel, BorderLayout.NORTH);
    }

    /**
     *
     * @return the chosen connection name
     */
    public String getSelectConnectionName() {
        return connectionComboBoxPanel.getSelectedItem();
    }

    /**
     * invoked when reloading the connection combo box panel
     * @param connection
     */
    public void populateConnection(Connection connection) {
        connectionComboBoxPanel.populate(connection);
    }

    @Override
    protected String title4PopupWindow() {
        return "chose";
    }
}
