/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgt.view;
import com.sgt.db.DaoClass;
import com.sgt.model.Model;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author maste
 */
public class CadastroUsuario extends javax.swing.JInternalFrame {
    
    public void BuscaUser() {
       
        String Sql = "SELECT id ,nome, usuario, senha, email FROM usuarios WHERE usuario LIKE ?";
        
        try {
            
            PreparedStatement Pmp = DaoClass.conectar().prepareStatement(Sql);
            Pmp.setString(1, txtSuser.getText()+'%');
            ResultSet rs = Pmp.executeQuery();            
            tbUsuarios.setModel(DbUtils.resultSetToTableModel(rs));            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Falha ao carregar os dados - " + e);
        }        
    }
    
    
    public void preencheCampos(){
        
        int get = tbUsuarios.getSelectedRow();
        txtNome.setText(tbUsuarios.getModel().getValueAt(get, 1).toString());
        txtNomeUser.setText(tbUsuarios.getModel().getValueAt(get, 2).toString());
        txtPass1.setText(tbUsuarios.getModel().getValueAt(get, 3).toString());
        txtPass2.setText(tbUsuarios.getModel().getValueAt(get, 3).toString());
        txtEmail.setText(tbUsuarios.getModel().getValueAt(get, 4).toString());
        labelID.setText(tbUsuarios.getModel().getValueAt(get, 0).toString());
    }
    
    
    /**
     * Creates new form CadastroUsuario
     */
    public CadastroUsuario() {
        initComponents();
        this.getContentPane().setBackground(Color.decode("#009688"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtNomeUser = new javax.swing.JTextField();
        txtSuser = new javax.swing.JTextField();
        bntBusca = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        labelID = new javax.swing.JLabel();

        setClosable(true);
        setForeground(new java.awt.Color(249, 249, 249));
        setIconifiable(true);
        setTitle("Cadastro de Usuário");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 249, 249));
        jLabel1.setText("Gerência de Usuários");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 249, 249));
        jLabel2.setText("Nome: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 249, 249));
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(249, 249, 249));
        jLabel4.setText("Informe a Senha:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 249, 249));
        jLabel5.setText("Informe novamente:");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485636510_floppy.png"))); // NOI18N
        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Usuário", "Senha", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 249, 249));
        jLabel6.setText("Nome de usuário: ");

        txtSuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSuserKeyReleased(evt);
            }
        });

        bntBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485832605_Search.png"))); // NOI18N

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/1485636510_floppy.png"))); // NOI18N
        btnSave.setText("Cadastrar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        labelID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelID.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSave)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(txtSuser, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(bntBusca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelID)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtSuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnSave))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(bntBusca)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSuserKeyReleased
   
       BuscaUser();        
    }//GEN-LAST:event_txtSuserKeyReleased

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        preencheCampos();
    }//GEN-LAST:event_tbUsuariosMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        if(txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNomeUser.getText().isEmpty() || txtPass1.getText().isEmpty() || txtPass2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha Todos os campos para continuar.");
        }else if(txtPass1.getText().equals(txtPass2.getText())){
            
            Map DadosUP = new HashMap();
            DadosUP.put("id", labelID.getText());
            DadosUP.put("Nome", txtNome.getText());
            DadosUP.put("NomeUser", txtNomeUser.getText());
            DadosUP.put("Email", txtEmail.getText());
            DadosUP.put("Senha", txtPass1.getText());
            
            
            Model CallModel = new Model();
            Map Resultado = CallModel.AtualizaUser(DadosUP);
            
            if(Resultado.get("Result").equals(true)){
                JOptionPane.showMessageDialog(null, Resultado.get("Mensagem"));
                txtNome.setText(null);
                txtEmail.setText(null);
                txtNomeUser.setText(null);
                txtPass1.setText(null);
                txtPass2.setText(null);
            }else{
                JOptionPane.showMessageDialog(null, Resultado.get("Mensagem"));
            }
     
        }else{
           JOptionPane.showMessageDialog(null, "As senhas informadas não conferem!!"); 
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
         if(txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNomeUser.getText().isEmpty() || txtPass1.getText().isEmpty() || txtPass2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha Todos os campos para continuar.");
        }else if(txtPass1.getText().equals(txtPass2.getText())){
            
            Map DadosCAD = new HashMap();
            DadosCAD.put("id", labelID.getText());
            DadosCAD.put("Nome", txtNome.getText());
            DadosCAD.put("NomeUser", txtNomeUser.getText());
            DadosCAD.put("Email", txtEmail.getText());
            DadosCAD.put("Senha", txtPass1.getText());
            
            Model CallModel = new Model();
            Map Resultado = CallModel.CadastraUser(DadosCAD);
            
            if(Resultado.get("Result").equals(true)){
                JOptionPane.showMessageDialog(null, Resultado.get("Mensagem"));
                txtNome.setText(null);
                txtEmail.setText(null);
                txtNomeUser.setText(null);
                txtPass1.setText(null);
                txtPass2.setText(null);
            }else{
                JOptionPane.showMessageDialog(null, Resultado.get("Mensagem"));
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "As senhas informadas não conferem!!");  
        }
        
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBusca;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelID;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeUser;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtSuser;
    // End of variables declaration//GEN-END:variables
}
