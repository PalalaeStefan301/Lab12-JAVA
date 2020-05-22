/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab12;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JPanel;

/**
 *
 * @author Palalae
 */
public class EncodeToXML {

    protected static final String ENCODED_FILE_NAME = "panel.xml";

    public static void encode(JPanel panel) throws FileNotFoundException {
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ENCODED_FILE_NAME)));
        xmlEncoder.writeObject(panel);
        xmlEncoder.close();
    }
}
