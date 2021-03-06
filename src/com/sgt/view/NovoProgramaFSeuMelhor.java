/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgt.view;
import com.sgt.model.Model;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author maste
 */
public class NovoProgramaFSeuMelhor extends javax.swing.JInternalFrame {

    /**
     * Creates new form NovoProgramaFSeuMelhor
     */
    public NovoProgramaFSeuMelhor() {
        initComponents();
        PreecheCombobox();
        this.getContentPane().setBackground(Color.decode("#009688"));
    }
    
    
    private void PreecheCombobox(){
    
        Model Call = new Model();
        ArrayList Back = Call.GetEstudantes();
        int Tam = Back.size(); 
        
            cbAjuEstudoBiblico.addItem("");
            cbAjuPriVis.addItem("");
            cbAjuRevisita.addItem("");
            cbPartPriVis.addItem("");
            cbPartRevisita.addItem("");
            cbPartLeitura.addItem("");
            cbPartEstudoBiblico.addItem("");
        
        
        for(int i = 0; i < Tam; i++){
            cbAjuEstudoBiblico.addItem(Back.get(i).toString());
            cbAjuPriVis.addItem(Back.get(i).toString());
            cbAjuRevisita.addItem(Back.get(i).toString());
            cbPartPriVis.addItem(Back.get(i).toString());
            cbPartRevisita.addItem(Back.get(i).toString());
            cbPartLeitura.addItem(Back.get(i).toString());
            cbPartEstudoBiblico.addItem(Back.get(i).toString());
        }  
    
    }
    
    private void GravaProg(){
        
        if(txtEstudoBiblico.getText().isEmpty() || txtLeitura.getText().isEmpty() || txtPriVisita.getText().isEmpty() || txtRevisita.getText().isEmpty()|| cbAjuEstudoBiblico.getSelectedItem().equals("") || 
                cbAjuPriVis.getSelectedItem().equals("")|| cbAjuRevisita.getSelectedItem().equals("") || cbPartEstudoBiblico.getSelectedItem().equals("") || cbPartLeitura.getSelectedItem().equals("") || 
                cbPartPriVis.getSelectedItem().equals("") || cbPartRevisita.getSelectedItem().equals("") || cbSala.getSelectedItem().equals("Selecione...") || spLeituraPonto.getValue().equals(0) || spPontoEstudoBiblico.getValue().equals(0) || spPontoPriVis.getValue().equals(0) || spPontoRev.getValue().equals(0)){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatÃ³rios");
        }else{
            
            SimpleDateFormat FormatUSADate = new SimpleDateFormat("yyyy-MM-dd");           
            Map DadosProg = new HashMap();
            DadosProg.put("Leitura", txtLeitura.getText());
            DadosProg.put("Leitura Participante", cbPartLeitura.getSelectedItem());
            DadosProg.put("Leitura Ponto", spLeituraPonto.getValue().toString());
            DadosProg.put("Pri Visita", txtPriVisita.getText());
            DadosProg.put("PVisita Participante", cbPartPriVis.getSelectedItem());
            DadosProg.put("PVisita Ajudante", cbAjuPriVis.getSelectedItem());
            DadosProg.put("PVisita Ponto", spPontoPriVis.getValue().toString());
            DadosProg.put("Revisita", txtRevisita.getText());
            DadosProg.put("Revisita Participante", cbPartRevisita.getSelectedItem());
            DadosProg.put("Revisita Ajudante", cbAjuRevisita.getSelectedItem());
            DadosProg.put("Revisita Ponto", spPontoRev.getValue().toString());
            DadosProg.put("Estudo Biblico", txtEstudoBiblico.getText());
            DadosProg.put("EsBiblico Participante", cbPartEstudoBiblico.getSelectedItem());
            DadosProg.put("EsBiblico Ajudante", cbAjuEstudoBiblico.getSelectedItem());
            DadosProg.put("EsBiblico Ponto", spPontoEstudoBiblico.getValue().toString());
            DadosProg.put("Sala", cbSala.getSelectedItem());
            DadosProg.put("Data", FormatUSADate.format(cbDateSem.getDate().getTime()));
            
           Model CallModel = new Model();
           Map Execute = CallModel.GrvProg(DadosProg);
           
           if(Execute.get("Retorno").equals(true)){
               Object[] options = { "Confirmar", "Cancelar" };
               int decisao =  JOptionPane.showConfirmDialog(null, "Dados Salvos com sucesso. Gostaria de cadastrar um novo programa?","",JOptionPane.YES_NO_OPTION);
            
               if(decisao == 0){
                txtLeitura.setText(null);
                cbPartLeitura.setSelectedItem(null);
                spLeituraPonto.setValue(0);
                txtPriVisita.setText(null);
                cbPartPriVis.setSelectedItem(null);
                cbAjuPriVis.setSelectedItem(null);
                spPontoPriVis.setValue(0);
                txtRevisita.setText(null);
                cbPartRevisita.setSelectedItem(null);
                cbAjuRevisita.setSelectedItem(null);
                spPontoRev.setValue(0);
                txtEstudoBiblico.setText(null);
                cbPartEstudoBiblico.setSelectedItem(null);
                cbAjuEstudoBiblico.setSelectedItem(null);
                spPontoEstudoBiblico.setValue(0);
                cbSala.setSelectedItem(null);
               }else{
                   this.dispose();
               }
            
           }else{
               JOptionPane.showMessageDialog(null, "Falha ao cadastrar os dados");
           }
           
           
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSala = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLeitura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spLeituraPonto = new javax.swing.JSpinner();
        txtPriVisita = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbAjuPriVis = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbPartPriVis = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        spPontoPriVis = new javax.swing.JSpinner();
        txtRevisita = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbAjuRevisita = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spPontoRev = new javax.swing.JSpinner();
        txtEstudoBiblico = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        spPontoEstudoBiblico = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        cbAjuEstudoBiblico = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbPartEstudoBiblico = new javax.swing.JComboBox<>();
        btnSaveProg = new javax.swing.JButton();
        cbPartLeitura = new javax.swing.JComboBox<>();
        cbPartRevisita = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbDateSem = new org.freixas.jcalendar.JCalendarCombo();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setTitle("Nova Programação Faça seu Melhor");
        setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sala:");

        cbSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "A", "B" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Leitura da Bíblia: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Revisita:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Primeira Visita:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estudo Bíblico:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Participante:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ponto:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Participante:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ajudante:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ponto:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Participante:");

        cbAjuRevisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAjuRevisitaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ajudante:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ponto:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ponto:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Participante:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Ajudante:");

        cbPartEstudoBiblico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartEstudoBiblicoActionPerformed(evt);
            }
        });

        btnSaveProg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485636510_floppy.png"))); // NOI18N
        btnSaveProg.setText("Salvar");
        btnSaveProg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProgActionPerformed(evt);
            }
        });

        cbPartLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartLeituraActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(249, 249, 249));
        jLabel19.setText("Nova Programação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(457, 457, 457))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbDateSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61)
                        .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cbPartPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbAjuPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addGap(37, 37, 37)
                                        .addComponent(spPontoPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(51, 51, 51)
                                        .addComponent(cbPartLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel9)
                                        .addGap(37, 37, 37)
                                        .addComponent(spLeituraPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPriVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPartRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbAjuRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel15)
                                        .addGap(36, 36, 36)
                                        .addComponent(spPontoRev, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPartEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbAjuEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel16)
                                        .addGap(36, 36, 36)
                                        .addComponent(spPontoEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(400, 400, 400)
                                        .addComponent(btnSaveProg)))))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbDateSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(spLeituraPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbPartLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPriVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbAjuPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbPartPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(spPontoPriVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbAjuRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(spPontoRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPartRevisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbAjuEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbPartEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(spPontoEstudoBiblico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSaveProg)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPartRevisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartRevisitaActionPerformed
        
    }//GEN-LAST:event_cbPartRevisitaActionPerformed

    private void cbPartEstudoBiblicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartEstudoBiblicoActionPerformed
        
    }//GEN-LAST:event_cbPartEstudoBiblicoActionPerformed

    private void btnSaveProgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProgActionPerformed
       GravaProg();
    }//GEN-LAST:event_btnSaveProgActionPerformed

    private void cbAjuRevisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAjuRevisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAjuRevisitaActionPerformed

    private void cbPartLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartLeituraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPartLeituraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProg;
    private javax.swing.JComboBox<String> cbAjuEstudoBiblico;
    private javax.swing.JComboBox<String> cbAjuPriVis;
    private javax.swing.JComboBox<String> cbAjuRevisita;
    private org.freixas.jcalendar.JCalendarCombo cbDateSem;
    private javax.swing.JComboBox<String> cbPartEstudoBiblico;
    private javax.swing.JComboBox<String> cbPartLeitura;
    private javax.swing.JComboBox<String> cbPartPriVis;
    private javax.swing.JComboBox<String> cbPartRevisita;
    private javax.swing.JComboBox<String> cbSala;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spLeituraPonto;
    private javax.swing.JSpinner spPontoEstudoBiblico;
    private javax.swing.JSpinner spPontoPriVis;
    private javax.swing.JSpinner spPontoRev;
    private javax.swing.JTextField txtEstudoBiblico;
    private javax.swing.JTextField txtLeitura;
    private javax.swing.JTextField txtPriVisita;
    private javax.swing.JTextField txtRevisita;
    // End of variables declaration//GEN-END:variables
}
