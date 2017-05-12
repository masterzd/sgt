/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgt.view;
import org.sqlite.SQLiteException;
import java.sql.*;
import com.sgt.db.DaoClass;
import com.sgt.model.Model;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author maste
 */
public class DetalhesEstudante extends javax.swing.JFrame {
    
    /**
     * Creates new form DetalhesEstudante
     */
    public DetalhesEstudante() {
        initComponents();
        this.getContentPane().setBackground(Color.decode("#009688"));
    }
    
    /* função que irá fazer ponte com a tela de consulta estudantes */
    public void ponteRecebe(String Nome) throws SQLException, ClassNotFoundException{
        
        this.setTitle("Detalhes de: " + Nome + " - SGT");
        String Sql1 = "SELECT * FROM estudantes WHERE est_nome = ?";
        String Sql2 = "SELECT * FROM programacao WHERE prog_oradorD1 LIKE ? or prog_oradorD2 LIKE ? or prog_oradorD3 LIKE ? or prog_oradorD4 LIKE ?";
        String Sql3 = "SELECT * FROM programacao WHERE prog_ajudanteD2 LIKE ? or prog_ajudanteD3 LIKE ? or prog_ajudanteD4 LIKE ?";
        
            
        
        try {
            
            Connection Conn = DaoClass.conectar();
            PreparedStatement Pmp = Conn.prepareStatement(Sql1);
            Pmp.setString(1, Nome);
            ResultSet rs1 = Pmp.executeQuery();
            
            if(rs1.next()){
                txtNomeEstudante.setText(rs1.getString("est_nome"));
                txtAjudante.setText(rs1.getString("est_aju"));
                txtContato.setText(rs1.getString("est_tel"));
                txtDataAju.setText(rs1.getString("est_dt_aju"));
                txtDataDesig.setText(rs1.getString("est_dt_desig"));
                txtId.setText(rs1.getString("est_cod"));
                cbPriv.setSelectedItem(rs1.getString("est_sit"));
                cbSala.setSelectedItem(rs1.getString("est_sala"));
                cbSexo.setSelectedItem(rs1.getString("est_sex"));
                spPontoCon.setValue(rs1.getInt("est_pnt_cs"));
                spProxPonto.setValue(rs1.getInt("est_ppnt_cs"));
                
            }else{
                JOptionPane.showMessageDialog(this, "Esse estudante não está cadastrado ou foi excluido!!");
                this.dispose();
            }
            
            Pmp = Conn.prepareStatement(Sql2);
            Pmp.setString(1, '%'+Nome+'%');
            Pmp.setString(2, '%'+Nome+'%');
            Pmp.setString(3, '%'+Nome+'%');
            Pmp.setString(4, '%'+Nome+'%');            
            ResultSet rs2 = Pmp.executeQuery();
            
            DefaultTableModel table01 = (DefaultTableModel) tbDesignado.getModel();
            table01.setNumRows(0);
            this.repaint();
           
            
            while(rs2.next()){       
                if(rs2.getString("prog_oradorD1").contains(Nome)){
                    Object [] info = {rs2.getString("prog_data"), rs2.getString("prog_discurso1"), rs2.getString("prog_pontoD1"), ""};
                    table01.addRow(info);
                }else if(rs2.getString("prog_oradorD2").contains(Nome)){
                    Object [] info = {rs2.getString("prog_data"), rs2.getString("prog_discurso2"), rs2.getString("prog_pontoD2"), rs2.getString("prog_ajudanteD2")};
                    table01.addRow(info);
                }else if(rs2.getString("prog_oradorD3").contains(Nome)){
                    Object [] info = {rs2.getString("prog_data"), rs2.getString("prog_discurso3"), rs2.getString("prog_pontoD3"), rs2.getString("prog_ajudanteD3")};
                    table01.addRow(info);
                }else if(rs2.getString("prog_oradorD4").contains(Nome)){
                    Object [] info = {rs2.getString("prog_data"), rs2.getString("prog_discurso4"), rs2.getString("prog_pontoD4"), rs2.getString("prog_ajudanteD4")};
                    table01.addRow(info);
                }else{
                     Object [] info = {"", "", "", ""};
                     table01.addRow(info);
                }
            }
            
            Pmp = Conn.prepareStatement(Sql3);
            Pmp.setString(1, '%'+Nome+'%');
            Pmp.setString(2, '%'+Nome+'%');
            Pmp.setString(3, '%'+Nome+'%');
            ResultSet rs3 = Pmp.executeQuery();
            
            DefaultTableModel table02 = (DefaultTableModel) tbAjudante.getModel();
            table02.setNumRows(0);
            this.repaint();
            
            while(rs3.next()){
                
                if(rs3.getString("prog_ajudanteD2").contains(Nome)){
                    Object [] info2 = {rs3.getString("prog_data"), rs3.getString("prog_oradorD2"), rs3.getString("prog_discurso2")};
                    table02.addRow(info2);
                }else if(rs3.getString("prog_ajudanteD3").contains(Nome)){
                    Object [] info2 = {rs3.getString("prog_data"), rs3.getString("prog_oradorD3"), rs3.getString("prog_discurso3")};
                    table02.addRow(info2);
                }else if(rs3.getString("prog_ajudanteD4").contains(Nome)){
                   Object [] info2 = {rs3.getString("prog_data"), rs3.getString("prog_oradorD4"), rs3.getString("prog_discurso4")};
                    table02.addRow(info2);
                }else{
                     Object [] info2 = {"", "", "", ""};
                     table02.addRow(info2);
                }
            }

            Conn.close();
        } catch (SQLiteException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar os dados: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbPriv = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spPontoCon = new com.toedter.components.JSpinField();
        jLabel5 = new javax.swing.JLabel();
        spProxPonto = new com.toedter.components.JSpinField();
        jLabel6 = new javax.swing.JLabel();
        txtAjudante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataDesig = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDataAju = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbSala = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDesignado = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAjudante = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        txtNomeEstudante = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 251, 251));
        jLabel2.setText("Privilégio:");

        cbPriv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Ancião", "Servo Ministerial", "Publicador", "Matriculado", "Pioneiro", "Desqualificado" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 251, 251));
        jLabel3.setText("Contato:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(252, 251, 251));
        jLabel4.setText("Ponto Cons.:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(252, 251, 251));
        jLabel5.setText("Prox. Ponto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 251, 251));
        jLabel6.setText("Ajudante:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(252, 251, 251));
        jLabel7.setText("Data da Desig.:");

        txtDataDesig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDataDesig.setForeground(new java.awt.Color(252, 251, 251));
        txtDataDesig.setText("aaaa-mm-dd");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(252, 251, 251));
        jLabel9.setText("Data Ajudante: ");

        txtDataAju.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDataAju.setForeground(new java.awt.Color(252, 251, 251));
        txtDataAju.setText("aaaa-mm-dd");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(252, 251, 251));
        jLabel11.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Masculino", "Feminino" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(252, 251, 251));
        jLabel12.setText("Sala:");

        cbSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "A", "B" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(252, 251, 251));
        jLabel13.setText("Ultimas Designações");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(252, 251, 251));
        jLabel14.setText("Designado");

        tbDesignado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Tema", "Ponto", "Ajudante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDesignado);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(252, 251, 251));
        jLabel15.setText("Ajudante");

        tbAjudante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Irmão que Ajudou", "Tema"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbAjudante);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485636510_floppy.png"))); // NOI18N
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485912315_free-27.png"))); // NOI18N
        btnDel.setText("Apagar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        txtNomeEstudante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeEstudanteActionPerformed(evt);
            }
        });

        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(jLabel15))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(cbPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(spProxPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataAju)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAjudante, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(37, 37, 37)
                                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(37, 37, 37)
                                .addComponent(spPontoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataDesig))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btnSave)
                        .addGap(90, 90, 90)
                        .addComponent(btnDel)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(txtNomeEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtId)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomeEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbPriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(spPontoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(spProxPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtAjudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtDataDesig)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDataAju)
                    .addComponent(jLabel11)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel))
                .addGap(40, 40, 40)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel15)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       if(txtAjudante.getText().equals("") || cbPriv.getSelectedItem().equals("Selecione...") || cbSala.getSelectedItem().equals("Selecione...") || cbSexo.getSelectedItem().equals("Selecione...") || spPontoCon.getValue() ==0 || spProxPonto.getValue() == 0){
           JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios");
       }else{
           
           Map Dados = new HashMap();
           Dados.put("ID", txtId.getText());
           Dados.put("Priv", cbPriv.getSelectedItem());
           Dados.put("Contato", txtContato.getText());
           Dados.put("PontoC", spPontoCon.getValue());
           Dados.put("ProxPon", spProxPonto.getValue());
           Dados.put("Ajudante", txtAjudante.getText());
           Dados.put("Sexo", cbSexo.getSelectedItem());
           Dados.put("Sala", cbSala.getSelectedItem());
           Dados.put("Nome", txtNomeEstudante.getText());
           
           Model CallModel = new Model();
           Map Exe = CallModel.UpdateEstudante(Dados);
           
           if(Exe.get("Result").equals(true)){
               JOptionPane.showMessageDialog(this, Exe.get("Mensagem"));
               this.dispose();
           }else{
              JOptionPane.showMessageDialog(this, Exe.get("Mensagem")); 
           }
           
           
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        
        int decisao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar o estudante?", "Alerta", JOptionPane.YES_NO_OPTION);
        
        if(decisao == 0){
            
            Model CallModel = new Model();
            Boolean ExeDel = null;
            try {
                ExeDel = CallModel.DeleteEstudante(txtNomeEstudante.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DetalhesEstudante.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(ExeDel == true){
                JOptionPane.showMessageDialog(this, "Dados Apagados com sucesso!!");
                this.dispose();
            }else{
               JOptionPane.showMessageDialog(this, "Falha ao deletar os dados"); 
            }
            
        }
        
        
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtNomeEstudanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeEstudanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeEstudanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalhesEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalhesEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalhesEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalhesEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalhesEstudante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbPriv;
    private javax.swing.JComboBox<String> cbSala;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private com.toedter.components.JSpinField spPontoCon;
    private com.toedter.components.JSpinField spProxPonto;
    private javax.swing.JTable tbAjudante;
    private javax.swing.JTable tbDesignado;
    private javax.swing.JTextField txtAjudante;
    private javax.swing.JTextField txtContato;
    private javax.swing.JLabel txtDataAju;
    private javax.swing.JLabel txtDataDesig;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNomeEstudante;
    // End of variables declaration//GEN-END:variables

  
}
