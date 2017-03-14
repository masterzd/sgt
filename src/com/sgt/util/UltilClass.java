package com.sgt.util;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

/**
 * @author Henrique Rocha
 */
public class UltilClass {

    /* Metodo para Criar label */
    public JLabel GeraLabel(String Texto, String Cor, int Altura, int Largura, int LocED, int LocCB) {
        JLabel lbGen = new JLabel();
        lbGen.setVisible(true);
        lbGen.setText(Texto);
        lbGen.setForeground(Color.decode(Cor));
        lbGen.setSize(Largura, Altura);
        lbGen.setLocation(LocED, LocCB);
        return lbGen;
    }

    /* Metodo para criar um Textfield */
    public JTextField GeraTexfield(int Altura, int Largura, int LocED, int LocCB) {
        JTextField TextField = new JTextField();
        TextField.setVisible(true);
        TextField.setSize(Largura, Altura);
        TextField.setLocation(LocED, LocCB);
        return TextField;
    }

    /* Metodo para gerar um combobox */
    public JComboBox GeraComboBox(String[] Opcoes, int Altura, int Largura, int LocED, int LocCB) {
        JComboBox ComboBox = new JComboBox(Opcoes);
        ComboBox.setVisible(true);
        ComboBox.setSize(Largura, Altura);
        ComboBox.setLocation(LocED, LocCB);
        return ComboBox;
    }

    /* Metodo para gerar um calendário */
    public JCalendarCombo GerarCalendario(int Altura, int Largura, int LocED, int LocCB) {       
        JCalendarCombo Calendario = new JCalendarCombo();
        Calendario.setVisible(true);
        Calendario.setSize(Largura, Altura);
        Calendario.setLocation(LocED, LocCB);        
        return Calendario;
    }

}
