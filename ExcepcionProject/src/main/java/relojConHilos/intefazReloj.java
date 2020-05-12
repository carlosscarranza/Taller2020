/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojConHilos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observer;
import javafx.beans.Observable;

/**
 *
 * @author Karen.Pena
 */
public class intefazReloj extends javax.swing.JFrame implements Observer {

    Calendar calendario = new GregorianCalendar();

    public intefazReloj() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCronometroReloj = new javax.swing.JLabel();
        btnIniciarReloj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(28, 23, 23));
        setMaximumSize(new java.awt.Dimension(2147483647, 1135635656));
        setSize(new java.awt.Dimension(2, 0));

        lblCronometroReloj.setFont(new java.awt.Font("Source Code Pro", 1, 55)); // NOI18N
        lblCronometroReloj.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.MatteBorder(null)));

        btnIniciarReloj.setText("INICIAR RELOJ");
        btnIniciarReloj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciarReloj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarRelojActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reloj Digital Karen Peña");
        jLabel2.setAlignmentX(10.0F);
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCronometroReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnIniciarReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCronometroReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarRelojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarRelojActionPerformed
        this.btnIniciarReloj.setEnabled(false);
        this.btnIniciarReloj.setFocusPainted(false);
        

        //instancia de reloj
        RelijDigitalThreads reloj = new RelijDigitalThreads(calendario.get(Calendar.HOUR_OF_DAY),
                calendario.get(Calendar.MINUTE),
                calendario.get(Calendar.SECOND));

        //suscribcion al observador
        reloj.addObserver(this);

        //nuevo hilo
        Thread hiloReloj = new Thread(reloj);
        hiloReloj.start();

    }//GEN-LAST:event_btnIniciarRelojActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new intefazReloj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarReloj;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCronometroReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(java.util.Observable o, Object datosHoraReloj) {

        lblCronometroReloj.setText((String) datosHoraReloj);
    }
}
