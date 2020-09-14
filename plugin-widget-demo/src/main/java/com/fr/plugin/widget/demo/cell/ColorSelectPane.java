package com.fr.plugin.widget.demo.cell;

import com.fr.design.designer.IntervalConstants;
import com.fr.design.gui.ibutton.UIColorButton;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

/**
 * @author Joe
 * Created by Joe on 9/14/2020
 */
public class ColorSelectPane extends JPanel {
    private UIColorButton colorButton = new UIColorButton();

    /**
     * Create a color select pane. The label and UIColorButton arrange horizontally.
     */
    public ColorSelectPane() {
        this.setLayout(new BorderLayout());

        double f = TableLayout.FILL;
        double p = TableLayout.PREFERRED;
        Component[][] components = new Component[][]{
                new Component[]{new UILabel("Font Color"), colorButton},
        };
        double[] rowSize = {p};
        double[] columnSize = {p, f};
        int[][] rowCount = {{1, 1}};
        JPanel panel = TableLayoutHelper.createGapTableLayoutPane(components, rowSize, columnSize, rowCount, IntervalConstants.INTERVAL_W3, IntervalConstants.INTERVAL_L1);
        this.add(panel, BorderLayout.CENTER);
    }

    public Color getColor(){
        return this.colorButton.getColor();
    }

    public void setColor(Color color){
        this.colorButton.setColor(color);
        this.colorButton.repaint();
    }
}
