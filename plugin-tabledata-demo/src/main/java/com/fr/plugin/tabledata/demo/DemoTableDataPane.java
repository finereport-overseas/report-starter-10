package com.fr.plugin.tabledata.demo;

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
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Joe
 * Created by Joe on 7/24/2020
 */
public class DemoTableDataPane extends AbstractTableDataPane<DemoTableData> {

    private final static double P = TableLayout.PREFERRED;
    private final static double F = TableLayout.FILL;

    private UITableEditorPane<ParameterProvider> parameterTableEditorPane;
    private UITextField tEditor;

    public DemoTableDataPane() {
        init();
    }

    private void init() {
        // Create a pane for entering parameters.
        UITableModelAdapter<ParameterProvider> model = new ParameterTableModel();
        parameterTableEditorPane = new UITableEditorPane<ParameterProvider>(model);

        // Create the text field for 'others'
        tEditor = new UITextField();

        // Create the 'preview' button
        UIButton preview = new UIButton(BaseUtils.readIcon("/com/fr/design/images/m_file/preview.png"));
        preview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PreviewTablePane.previewTableData(DemoTableDataPane.this.updateBean());
                    }
                });
            }
        });

        // Table layout
        JPanel topPane = TableLayoutHelper.createTableLayoutPane(
                new Component[][] {{
                    tEditor, preview
                }},
                new double[] {P},
                new double[] {F, P}
        );

        this.add(TableLayoutHelper.createTableLayoutPane(
                new Component[][] {{
                    topPane
                }, {
                    parameterTableEditorPane
                }},
                new double[] {P, F},
                new double[] {F}
        ));
    }

    @Override
    public void populateBean(DemoTableData demoTableData) {
        if (null == demoTableData) {
            return;
        }
        String others = demoTableData.getOthers();
        ParameterProvider[] parameters = demoTableData.getParameters(Calculator.createCalculator());
        tEditor.setText(others);
        parameterTableEditorPane.populate(parameters);
    }

    @Override
    public DemoTableData updateBean() {
        DemoTableData demoTableData = new DemoTableData();
        demoTableData.setOthers(tEditor.getText());
        List<ParameterProvider> parameterProviderList = parameterTableEditorPane.update();
        ParameterProvider[] parameters = parameterProviderList.toArray(new ParameterProvider[0]);
        demoTableData.setParameters(parameters);
        return demoTableData;
    }

    @Override
    protected String title4PopupWindow() {
        return "Demo";
    }
}
