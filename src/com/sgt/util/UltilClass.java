package com.sgt.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Henrique Rocha
 */

public class UltilClass {
   
    
    /* Metodo para Criar label */   
    public JLabel GeraLabel(String Texto, String Cor, int Altura, int Largura, int LocED, int LocCB){
         JLabel lbGen = new JLabel();
         lbGen.setVisible(true);
         lbGen.setText(Texto);
         lbGen.setForeground(Color.decode(Cor));
         lbGen.setSize(Largura, Altura);
         lbGen.setLocation(LocED, LocCB);       
         return lbGen;        
    }
    
    /* Metodo para criar um Textfield */
    public JTextField GeraTexfield(int Altura, int Largura, int LocED, int LocCB){       
           JTextField TextField = new JTextField();
           TextField.setVisible(true);
           TextField.setSize(Largura, Altura);
           TextField.setLocation(LocED, LocCB);
           return  TextField;
    }
    
    
}
