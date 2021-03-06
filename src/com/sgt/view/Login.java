/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgt.view;

import java.awt.Color;
import com.sgt.model.Model;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Henrique Rocha de Souza
 */
public class Login extends javax.swing.JFrame {

    String Theme = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    public void lookandfell() {

        try {
            UIManager.setLookAndFeel(Theme);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Falha no tema" + e.getMessage());
        }

    }

    public void CheckLogin(String usuario, String senha) {
        Model CallModel = new Model();
        Map Result = CallModel.MLogar(usuario, senha);
        if (Result.get("erro").equals(true)) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha Inválidos");
        } else {
            MenuPrincipal CallMenu = new MenuPrincipal();
            CallMenu.setVisible(true);
            CallMenu.setNames(Result);
            this.dispose();
        }

    }

    /**
     * Creates new form Login
     */
    public Login() {
        Boolean User = Checkusers();
        

        if (User == true) {
            initComponents();
            this.getContentPane().setBackground(Color.decode("#009688"));
            this.setLocationRelativeTo(null);
            lookandfell();
            getRootPane().setDefaultButton(btnLogar);
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Parece que você está ultilizando o SGT pela primeira vez ou a base de dados atual foi apagada. Antes de continuarmos. Vamos cadastrar um novo usuário, ok?");           
            CadUserEmptydb CallTela = new CadUserEmptydb();
            CallTela.setVisible(true);
            CallTela.setLocationRelativeTo(null);
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

        txtTitleLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTextLogin = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtTextSenha = new javax.swing.JLabel();
        txtUserSenha = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGT - Login");
        setAutoRequestFocus(false);
        setResizable(false);

        txtTitleLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTitleLogin.setForeground(new java.awt.Color(252, 252, 252));
        txtTitleLogin.setText("Sistema de Gerenciamento Teocrático");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/JwSmall.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Esse Software não foi Produzido pela WatchTower. Trata-se de um projeto pessoal para auxiliar nas atividades na congregação");

        txtTextLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTextLogin.setForeground(new java.awt.Color(255, 255, 255));
        txtTextLogin.setText("Login:");

        txtTextSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTextSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtTextSenha.setText("Senha:");

        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sgt/img/oie_7201842K96vZuQU.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTextLogin)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(txtTextSenha)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(txtTitleLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(txtTitleLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTextLogin)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTextSenha)
                    .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnLogar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)))
                .addComponent(jLabel2)
                .addContainerGap())
        );

        setBounds(0, 0, 739, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        CheckLogin(txtUserName.getText(), txtUserSenha.getText());
    }//GEN-LAST:event_btnLogarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel txtTextLogin;
    private javax.swing.JLabel txtTextSenha;
    private javax.swing.JLabel txtTitleLogin;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtUserSenha;
    // End of variables declaration//GEN-END:variables

    private Boolean Checkusers() {
        Model CallModel = new Model();
        Boolean Exe = CallModel.BuscaUser();
        return Exe;
    }
}
