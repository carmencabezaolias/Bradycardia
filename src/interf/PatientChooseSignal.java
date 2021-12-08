/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import BITalino.BITalino;
import Utilities.ConnectionWithServer;
import Utilities.Exceptions;
import Utilities.FunctionsBitalino;
import java.awt.Color;

/**
 *
 * @author carmen
 */
public class PatientChooseSignal extends javax.swing.JFrame {
public static BITalino bitalino;
    //public static BITalino bitalino = new BITalino();
    /**
     * Creates new form PatientChooseSignal
     */
    public PatientChooseSignal() {
        initComponents();
       // this.showText.setVisible(false);
        //this.stopBut.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.StartBut.setVisible(true);
        this.errorNum.setVisible(false);
        this.ErrorText.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SignalInput = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ErrorText = new javax.swing.JLabel();
        SamplingInput = new javax.swing.JComboBox<>();
        StartBut = new javax.swing.JButton();
        BackBut = new javax.swing.JButton();
        showText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nSamples = new javax.swing.JTextField();
        errorNum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SignalInput.setMaximumRowCount(3);
        SignalInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECG", "Acelometer", "Both" }));
        SignalInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignalInputActionPerformed(evt);
            }
        });

        jLabel2.setText("CHOOSE YOUR SAMPLING RATE:");

        ErrorText.setText("Something went wrong");

        SamplingInput.setMaximumRowCount(3);
        SamplingInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "100", "1000" }));
        SamplingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SamplingInputActionPerformed(evt);
            }
        });

        StartBut.setText("Start");
        StartBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButActionPerformed(evt);
            }
        });

        BackBut.setText("Back");
        BackBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButActionPerformed(evt);
            }
        });

        showText.setText("Recording....");

        jLabel1.setText("Introduce number of samples you want to record:");

        errorNum.setText("Introduce a valid number!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(showText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nSamples, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(errorNum, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SamplingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackBut)
                        .addGap(138, 138, 138)
                        .addComponent(StartBut)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(ErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(SignalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SamplingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nSamples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorNum))
                .addGap(18, 18, 18)
                .addComponent(ErrorText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBut)
                    .addComponent(StartBut))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignalInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignalInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignalInputActionPerformed

    private void SamplingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SamplingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SamplingInputActionPerformed

    private void StartButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButActionPerformed
        int sam = this.SamplingInput.getSelectedIndex();
        int samplingRate = FunctionsBitalino.getSampling(sam);
        this.errorNum.setVisible(false);
        
            boolean num= Exceptions.checkInt(this.nSamples.getText());
            if(num){
              
                bitalino = FunctionsBitalino.configuredBitalino(PatientPrincipalWindow.patient.getMacBitalino(), samplingRate, this.SignalInput.getSelectedIndex());
                if (bitalino==null) {
                      this.ErrorText.setForeground(Color.red);
                      this.ErrorText.setVisible(true);
                }else{ 
                    this.showText.setVisible(true);
                    this.showText.setForeground(Color.pink);
                    ConnectionWithServer.sendSomething(FirstWindow.socket, FirstWindow.printWriter, "start");
                    int n= Exceptions.convertInt(this.nSamples.getText());
                    FunctionsBitalino.getDataBitalino(bitalino, n);
                    
                    this.StartBut.setVisible(false); 
                }
            }else{
                this.errorNum.setForeground(Color.red);
                this.errorNum.setVisible(true);
                
           
                
        }       // TODO add your handling code here:
    }//GEN-LAST:event_StartButActionPerformed

    private void BackButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButActionPerformed
              ConnectionWithServer.sendSomething(FirstWindow.socket, FirstWindow.printWriter, "back");
        PatientInsideWindow rd = new PatientInsideWindow();
        this.setVisible(false);
        rd.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_BackButActionPerformed

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
            java.util.logging.Logger.getLogger(PatientChooseSignal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientChooseSignal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientChooseSignal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientChooseSignal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientChooseSignal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBut;
    private javax.swing.JLabel ErrorText;
    private javax.swing.JComboBox<String> SamplingInput;
    private javax.swing.JComboBox<String> SignalInput;
    private javax.swing.JButton StartBut;
    private javax.swing.JLabel errorNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nSamples;
    private javax.swing.JLabel showText;
    // End of variables declaration//GEN-END:variables
}
