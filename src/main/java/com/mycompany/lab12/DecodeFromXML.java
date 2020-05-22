/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab12;

import static com.mycompany.lab12.EncodeToXML.ENCODED_FILE_NAME;
import java.awt.Component;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

/**
 *
 * @author Palalae
 */
public class DecodeFromXML {

    protected static final String ENCODED_FILE_NAME = "panel.xml";

    public void decode(JPanel designPanel) throws FileNotFoundException {
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(ENCODED_FILE_NAME)));
        JPanel panel_loaded = (JPanel) xmlDecoder.readObject();
        for (Component c : panel_loaded.getComponents()) {
            designPanel.add(c);
        }
        xmlDecoder.close();
    }
}
