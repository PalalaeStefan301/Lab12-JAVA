/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab12;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Palalae
 */
public class MainFrame extends JFrame {

    private JButton save;
    private JLabel statusXML;
    private JButton load;
    private JButton delete;
    private JPanel controlPanel;
    private JPanel designPanel;
    private JComboBox listOfObjects;
    private JLabel objectInserted;
    private JLabel objTextInserted;
    private JTextField textInserted;
    private JButton createObject;
    private String string = "";

    public MainFrame() {
        Random rand = new Random();
        statusXML = new JLabel("");
        String[] messageComboBox = {"-", "Label", "Button"};
        listOfObjects = new JComboBox(messageComboBox);
        listOfObjects.addActionListener((ActionEvent e) -> {
            if (e.getSource() == listOfObjects) {
                JComboBox cb = (JComboBox) e.getSource();
                String msg = (String) cb.getSelectedItem();
                switch (msg) {
                    case "-":
                        string = "Nope";
                        break;
                    case "Label":
                        string = "Label";
                        break;
                    case "Button":
                        string = "Button";
                        break;
                }
            }
        });
        objectInserted = new JLabel("Select object");
        textInserted = new JTextField();
        objTextInserted = new JLabel("Text");
        createObject = new JButton("Create");
        save = new JButton("Save");
        load = new JButton("Load");
        delete = new JButton("Delete");
        createObject.addActionListener((ActionEvent e) -> {
            if (e.getSource() == createObject && !"".equals(textInserted.getText())) {
                if ("Label".equals(string)) {
                    String data = textInserted.getText();
                    JLabel label = new JLabel(data);
                    label.setBounds(rand.nextInt(1800), rand.nextInt(350), 120, 35);
                    label.setVisible(true);
                    designPanel.add(label);
                } else {
                    if ("Button".equals(string)) {
                        String data = textInserted.getText();
                        JButton button = new JButton(data);
                        button.setBounds(rand.nextInt(1800), rand.nextInt(350), 120, 35);
                        button.setVisible(true);
                        designPanel.add(button);
                    }
                }
                setSize(new Dimension(1920, 1081));
                setSize(new Dimension(1920, 1080));
            }

        });
        save.addActionListener((ActionEvent e) -> {
            if (e.getSource() == save) {
                EncodeToXML encoder = new EncodeToXML();
                try {
                    encoder.encode(designPanel);
                    statusXML.setText("Saved in XML");
                } catch (FileNotFoundException ex) {
                    System.err.println("An IOException was caught!");
                }
            }
        });
        load.addActionListener((ActionEvent e) -> {
            if (e.getSource() == load) {
                DecodeFromXML encoder = new DecodeFromXML();
                try {
                    encoder.decode(designPanel);
                    statusXML.setText("Loaded from XML");
                    setSize(new Dimension(1920, 1081));
                    setSize(new Dimension(1920, 1080));
                } catch (FileNotFoundException ex) {
                    System.err.println("An IOException was caught!");
                }
            }
        });
        delete.addActionListener((ActionEvent e) -> {
            if (e.getSource() == delete) {
                Component[] componentList = designPanel.getComponents();
                for (Component c : componentList) {
                    designPanel.remove(c);
                }
                statusXML.setText("Items deleted");
                setSize(new Dimension(1920, 1081));
                setSize(new Dimension(1920, 1080));
            }
        });
        textInserted.setPreferredSize(new Dimension(200, 30));
        controlPanel = new JPanel();
        designPanel = new JPanel();
        designPanel.setLayout(null);
        this.add(controlPanel);
        this.add(designPanel);
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(objectInserted);
        controlPanel.add(listOfObjects);
        controlPanel.add(objTextInserted);
        controlPanel.add(textInserted);
        controlPanel.add(createObject);
        controlPanel.add(save);
        controlPanel.add(load);
        controlPanel.add(delete);
        controlPanel.add(statusXML);
        String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
        Object[][] data = {
            {"Kathy", "Smith",
                "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                "Pool", new Integer(10), new Boolean(false)}
        };
        JTable table = new JTable(data, columnNames);
        controlPanel.add(table);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(0, 0);
        this.setLayout(new GridLayout(2, 1));
        setSize(new Dimension(1920, 1080));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

    }

}
