/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Doğukan
 */
public class GUI_CostumerMenu_main_frm extends javax.swing.JFrame {

    /**
     * Creates new form costumer_main_frm
     */
    public GUI_CostumerMenu_main_frm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCostumerPanelAccountCreateDelete4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jButtonCostumerPanelMoneyWithdrawDeposit = new javax.swing.JButton();
        jButtonCostumerPanelAccountCreateDelete = new javax.swing.JButton();
        jButtonCostumerPanelMoneyTransferToAccount = new javax.swing.JButton();
        jButtonCostumerPanelCreditRequest = new javax.swing.JButton();
        jButtonCostumerPanelInfoUpdate = new javax.swing.JButton();
        jButtonCostumerPanelMoneyTransferToBank = new javax.swing.JButton();
        jButtonCostumerPanelMonthlySummary = new javax.swing.JButton();
        jLabelCostumerPanelWelcome = new javax.swing.JLabel();
        jButtonCostumerPanelExit = new javax.swing.JButton();

        jButtonCostumerPanelAccountCreateDelete4.setText("Hesap Açma veya Silme Talebi");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCostumerPanelMoneyWithdrawDeposit.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelMoneyWithdrawDeposit.setText("Para Cekme ve Yatirma");
        jButtonCostumerPanelMoneyWithdrawDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelMoneyWithdrawDepositActionPerformed(evt);
            }
        });

        jButtonCostumerPanelAccountCreateDelete.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelAccountCreateDelete.setText("Hesap Açma veya Silme Talebi");
        jButtonCostumerPanelAccountCreateDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelAccountCreateDeleteActionPerformed(evt);
            }
        });

        jButtonCostumerPanelMoneyTransferToAccount.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelMoneyTransferToAccount.setText("Hesaba Para Transferi");
        jButtonCostumerPanelMoneyTransferToAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelMoneyTransferToAccountActionPerformed(evt);
            }
        });

        jButtonCostumerPanelCreditRequest.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelCreditRequest.setText("Kredi Talebi");
        jButtonCostumerPanelCreditRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelCreditRequestActionPerformed(evt);
            }
        });

        jButtonCostumerPanelInfoUpdate.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelInfoUpdate.setText("Bilgi Güncelleme");
        jButtonCostumerPanelInfoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelInfoUpdateActionPerformed(evt);
            }
        });

        jButtonCostumerPanelMoneyTransferToBank.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelMoneyTransferToBank.setText("Bankaya Para Transfer(Borc odeme)");
        jButtonCostumerPanelMoneyTransferToBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelMoneyTransferToBankActionPerformed(evt);
            }
        });

        jButtonCostumerPanelMonthlySummary.setBackground(new java.awt.Color(204, 255, 255));
        jButtonCostumerPanelMonthlySummary.setText("Aylik Ozet Goruntule");
        jButtonCostumerPanelMonthlySummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelMonthlySummaryActionPerformed(evt);
            }
        });

        jLabelCostumerPanelWelcome.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelCostumerPanelWelcome.setForeground(new java.awt.Color(0, 51, 255));
        jLabelCostumerPanelWelcome.setText("Degerli Musterimiz banka sistemine hosgeldiniz...");

        jButtonCostumerPanelExit.setBackground(new java.awt.Color(153, 204, 255));
        jButtonCostumerPanelExit.setText("Cikis");
        jButtonCostumerPanelExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostumerPanelExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCostumerPanelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCostumerPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCostumerPanelMoneyWithdrawDeposit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jButtonCostumerPanelCreditRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCostumerPanelAccountCreateDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCostumerPanelMoneyTransferToAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonCostumerPanelInfoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addComponent(jButtonCostumerPanelMoneyTransferToBank, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCostumerPanelMonthlySummary, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCostumerPanelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCostumerPanelExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCostumerPanelInfoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCostumerPanelMoneyWithdrawDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCostumerPanelMoneyTransferToBank, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCostumerPanelAccountCreateDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCostumerPanelMonthlySummary, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCostumerPanelMoneyTransferToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCostumerPanelCreditRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCostumerPanelExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelExitActionPerformed
        GUI_MainMenu_main_frm giris = new GUI_MainMenu_main_frm();
        giris.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCostumerPanelExitActionPerformed

    private void jButtonCostumerPanelMoneyWithdrawDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelMoneyWithdrawDepositActionPerformed
        GUI_CustomerMenu_MoneyWithdrawDeposit MoneyWithdrawDeposit = new GUI_CustomerMenu_MoneyWithdrawDeposit();
        MoneyWithdrawDeposit.setVisible(true);
        dispose();
    
    }//GEN-LAST:event_jButtonCostumerPanelMoneyWithdrawDepositActionPerformed

    private void jButtonCostumerPanelMoneyTransferToBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelMoneyTransferToBankActionPerformed
        GUI_CustomerMenu_MoneyTransferBank MoneyTransferBank = new GUI_CustomerMenu_MoneyTransferBank();
        MoneyTransferBank.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCostumerPanelMoneyTransferToBankActionPerformed

    private void jButtonCostumerPanelAccountCreateDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelAccountCreateDeleteActionPerformed
        GUI_CustomerMenu_AccountRequest AccountRequest = new GUI_CustomerMenu_AccountRequest();
        AccountRequest.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCostumerPanelAccountCreateDeleteActionPerformed

    private void jButtonCostumerPanelMoneyTransferToAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelMoneyTransferToAccountActionPerformed
        GUI_CustomerMenu_MoneyTransferAccount MoneyTransfer = new GUI_CustomerMenu_MoneyTransferAccount();
        MoneyTransfer.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCostumerPanelMoneyTransferToAccountActionPerformed

    private void jButtonCostumerPanelCreditRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelCreditRequestActionPerformed
       GUI_CustomerMenu_CreditRequest CreditRequest = new GUI_CustomerMenu_CreditRequest();
       CreditRequest.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButtonCostumerPanelCreditRequestActionPerformed

    private void jButtonCostumerPanelInfoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelInfoUpdateActionPerformed
        GUI_CustomerMenu_InfoUpdate InfoUpdate = new GUI_CustomerMenu_InfoUpdate();
        InfoUpdate.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCostumerPanelInfoUpdateActionPerformed

    private void jButtonCostumerPanelMonthlySummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostumerPanelMonthlySummaryActionPerformed
       GUI_CustomerMenu_MonthlySummary MonthlySummary = new GUI_CustomerMenu_MonthlySummary();
       MonthlySummary.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButtonCostumerPanelMonthlySummaryActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_CostumerMenu_main_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_CostumerMenu_main_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_CostumerMenu_main_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_CostumerMenu_main_frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_CostumerMenu_main_frm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCostumerPanelAccountCreateDelete;
    private javax.swing.JButton jButtonCostumerPanelAccountCreateDelete4;
    private javax.swing.JButton jButtonCostumerPanelCreditRequest;
    private javax.swing.JButton jButtonCostumerPanelExit;
    private javax.swing.JButton jButtonCostumerPanelInfoUpdate;
    private javax.swing.JButton jButtonCostumerPanelMoneyTransferToAccount;
    private javax.swing.JButton jButtonCostumerPanelMoneyTransferToBank;
    private javax.swing.JButton jButtonCostumerPanelMoneyWithdrawDeposit;
    private javax.swing.JButton jButtonCostumerPanelMonthlySummary;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabelCostumerPanelWelcome;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}