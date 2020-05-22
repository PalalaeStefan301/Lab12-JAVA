/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab12;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Palalae
 */
public class InfoTable extends JTable {

    private String[] columnNames = {"text",
        "X coord",
        "Y coord",
        "name",
        "height",
        "width"};
    private Object[][] data;
    private DefaultTableModel model = (DefaultTableModel) this.getModel();

    public InfoTable(JButton button) {
        Vector row = new Vector();
        row.add(button.getText());
        row.add(button.getBounds().x);
        row.add(button.getBounds().y);
        row.add(button.getName());
        row.add(button.getHeight());
        row.add(button.getWidth());
        model.addRow(row);
    }

    public InfoTable(JLabel label) {
        Vector row = new Vector();
        row.add(label.getText());
        row.add(label.getBounds().x);
        row.add(label.getBounds().y);
        row.add(label.getName());
        row.add(label.getHeight());
        row.add(label.getWidth());
        model.addRow(row);
    }
}
