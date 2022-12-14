/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tetris.tetrisapp;

import javax.swing.JOptionPane;



/**
 *
 * @author António
 */
public class MenuInic extends javax.swing.JFrame {

    /**
     * Creates new form MenuInic
     */
    public MenuInic() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jogar = new javax.swing.JButton();
        Controlos = new javax.swing.JButton();
        Regras = new javax.swing.JButton();
        Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        Jogar.setBackground(new java.awt.Color(255, 51, 51));
        Jogar.setForeground(new java.awt.Color(255, 255, 255));
        Jogar.setText("Jogar");
        Jogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JogarActionPerformed(evt);
            }
        });

        Controlos.setBackground(new java.awt.Color(255, 51, 51));
        Controlos.setForeground(new java.awt.Color(255, 255, 255));
        Controlos.setText("Controlos");
        Controlos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlosActionPerformed(evt);
            }
        });

        Regras.setBackground(new java.awt.Color(255, 51, 51));
        Regras.setForeground(new java.awt.Color(255, 255, 255));
        Regras.setText("Regras");
        Regras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegrasActionPerformed(evt);
            }
        });

        Sair.setBackground(new java.awt.Color(255, 51, 51));
        Sair.setForeground(new java.awt.Color(255, 255, 255));
        Sair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regras, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Jogar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(Controlos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(Jogar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Controlos)
                .addGap(18, 18, 18)
                .addComponent(Regras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sair)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JogarActionPerformed
        // TODO add your handling code here:
        TetrisApp jogo = new TetrisApp();
        jogo.setVisible(true);
        jogo.setLocationRelativeTo(null);
    }//GEN-LAST:event_JogarActionPerformed

    private void ControlosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlosActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Os controlos do Tetris são as setas: Esquerda, Direita e Baixo - Executam o movimento das peças;\n "+
                "As teclas 'Q' e 'E' que permitem rodar para a esquerda e para a direita respetivamente; \n " + 
                "E os botões do rato, o botão esquerdo que faz com que a peça ande para a esquerda e rode quando clica no botão \n "
                + "E o botão direito que permite mover a peça e rodar a peça quando clica no botão." );
    }//GEN-LAST:event_ControlosActionPerformed

    private void RegrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegrasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "As regras do jogo Tetris são as seguintes: \n "+
                "O jogo é composto por 7 peças de forma geométrica I, O, J, L, S, Z, T; \n " + 
                "O jogador deve controlar as peças e fazer com que elas se encaixem umas às outras; \n " 
                + "Quando conseguir preencher totalmente uma linha horizontal, a linha irá desaparecer.");
    }//GEN-LAST:event_RegrasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Controlos;
    private javax.swing.JButton Jogar;
    private javax.swing.JButton Regras;
    private javax.swing.JButton Sair;
    // End of variables declaration//GEN-END:variables
}
