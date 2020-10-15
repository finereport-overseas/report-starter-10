package com.fr.plugin.data.source.demo.ui;

import com.fr.base.BaseUtils;
import com.fr.base.Parameter;
import com.fr.design.data.datapane.preview.PreviewTablePane;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.gui.ibutton.UIButton;
import com.fr.design.gui.itableeditorpane.ParameterTableModel;
import com.fr.design.gui.itableeditorpane.UITableEditorPane;
import com.fr.design.gui.itableeditorpane.UITableModelAdapter;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.file.ConnectionConfig;
import com.fr.plugin.data.source.demo.core.DemoTableData;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joe
 * Created by Joe on 10/15/2020
 */
public class DemoTableDataPane extends AbstractTableDataPane<DemoTableData> {
    private final static double P = TableLayout.PREFERRED;
    private final static double F = TableLayout.FILL;

    private UITableEditorPane<ParameterProvider> parameterTableEditorPane;
    private UITextField otherText;
    private DemoConnectionChoosePane choosePane;

    public DemoTableDataPane() {
        init();
    }

    private void init(){
        this.setLayout(new BorderLayout(4, 4));
        // create a pane for entering parameters
        UITableModelAdapter<ParameterProvider> model = new ParameterTableModel();
        parameterTableEditorPane = new UITableEditorPane<ParameterProvider>(model);

        // create the text field for 'others'
        otherText = new UITextField();

        // create the 'preview' button
        UIButton preview = new UIButton(BaseUtils.readIcon("/com/fr/design/images/m_file/preview.png"));
        preview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PreviewTablePane.previewTableData(DemoTableDataPane.this.updateBean());
                    }
                });
            }
        });

        // Table layout
        JPanel one = TableLayoutHelper.createTableLayoutPane(
                new Component[][] {{
                        otherText,preview
                }},
                new double[] { P },
                new double[] { F,P  }
        );

        JPanel tableLayoutPane = TableLayoutHelper.createTableLayoutPane(
                new Component[][]{{
                        one
                }, {
                        parameterTableEditorPane
                }},
                new double[]{P, F},
                new double[]{F}
        );

        // create and place the connection choose pane
        choosePane = new DemoConnectionChoosePane();
        choosePane.setPreferredSize(new Dimension(200, 200));
        JPanel centerPane = new JPanel(new BorderLayout(4, 4));
        centerPane.add(tableLayoutPane,BorderLayout.CENTER);
        this.add(choosePane,BorderLayout.WEST);
        this.add(centerPane,BorderLayout.CENTER);
    }
    @Override
    public void populateBean(DemoTableData demoTableData) {
        if(demoTableData==null){
            return;
        }
        otherText.setText(demoTableData.getOthers());
        ParameterProvider[] parameters = demoTableData.getParameters( Calculator.createCalculator() );
        parameterTableEditorPane.populate(parameters);
        choosePane.populateConnection(demoTableData.getDatabase());
    }


    @Override
    public DemoTableData updateBean() {
        DemoTableData result = new DemoTableData();
        result.setOthers(otherText.getText());
        java.util.List<ParameterProvider> parameterProviderList = parameterTableEditorPane.update();
        Parameter[] parameters = parameterProviderList.toArray(new Parameter[parameterProviderList.size()]);
        result.setParameters(parameters);
        String connectionName = choosePane.getSelectConnectionName();
        if (StringUtils.isNotEmpty(connectionName)) {
            result.setDatabase(ConnectionConfig.getInstance().getConnection(connectionName));
        }
        return result;
    }

    @Override
    protected String title4PopupWindow() {
        return "Demo";
    }
}
