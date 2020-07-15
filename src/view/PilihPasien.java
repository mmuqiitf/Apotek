/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.Pasien;
import com.Transaksi;
import db.ConnectionManager;
import exec.ExecutePasien;
import exec.ExecuteTransaksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import object.ConvertPasienToObject;

/**
 *
 * @author ALIK
 */
public class PilihPasien extends javax.swing.JFrame {

    /**
     * Creates new form PilihPasien
     */
    public PilihPasien() {
        initComponents();
        setDataPasien();
    }
    public PilihPasien(int id_pegawai) {
        initComponents();
        setDataPasien();
        this.id_pegawai = id_pegawai;
    }
    public int id_pasien, id_pegawai, id_transaksi;
    private void setDataPasien(){
        ConvertPasienToObject cpto = new ConvertPasienToObject();
        String[][] dataPasien = cpto.getPasien();
        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
            dataPasien,
            new String [] {
                "ID Pasien", "Nama", "Alamat", "No Telpon"
            }
        ));
        jScrollPane2.setViewportView(tblPasien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmitPasien = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPasien = new javax.swing.JTable();
        txtNoTelpPasien = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        taAlamatPasien = new javax.swing.JTextArea();
        txtNamaPasien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLanjutkan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSubmitPasien.setText("Submit");
        btnSubmitPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPasienActionPerformed(evt);
            }
        });

        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPasienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPasien);

        taAlamatPasien.setColumns(20);
        taAlamatPasien.setRows(5);
        jScrollPane.setViewportView(taAlamatPasien);

        jLabel4.setText("Nama Pasien");

        jLabel5.setText("Alamat Pasien");

        jLabel6.setText("No Telpon");

        btnLanjutkan.setText("Lanjutkan");
        btnLanjutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanjutkanActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSubmitPasien)
                                .addGap(18, 18, 18)
                                .addComponent(btnLanjutkan))
                            .addComponent(txtNoTelpPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnKembali)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoTelpPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitPasien)
                    .addComponent(btnLanjutkan))
                .addGap(28, 28, 28)
                .addComponent(btnKembali)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPasienActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaPasien.getText();
        String alamat = taAlamatPasien.getText();
        String no_telp = txtNoTelpPasien.getText();
        Pasien p = new Pasien(nama, alamat, no_telp);
        exec.ExecutePasien executePasien = new ExecutePasien();
        int hasil = executePasien.insertData(p);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataPasien();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitPasienActionPerformed

    private void tblPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPasienMouseClicked
        // TODO add your handling code here:
        int row = tblPasien.getSelectedRow();
        String id = tblPasien.getValueAt(row, 0).toString();
        String nama = tblPasien.getValueAt(row, 1).toString();
        String alamat = tblPasien.getValueAt(row, 2).toString();
        String no_telp = tblPasien.getValueAt(row, 3).toString();
        this.id_pasien = Integer.parseInt(id);
        txtNamaPasien.setText(nama);
        taAlamatPasien.setText(alamat);
        txtNoTelpPasien.setText(no_telp);
        System.out.println("ID PASIEN : " + this.id_pasien);
    }//GEN-LAST:event_tblPasienMouseClicked

    private void btnLanjutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanjutkanActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDateTime now = LocalDateTime.now();  
        String date_now = dtf.format(now);
        Random rnd = new Random();
        char [] digits = new char[5];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        int random_digit = Integer.parseInt(new String(digits));
        String invoice = "#INV" + dtf2.format(now) + random_digit;
        System.out.println(invoice);
        Transaksi ts = new Transaksi(invoice, date_now, id_pasien, id_pegawai);
        exec.ExecuteTransaksi et = new ExecuteTransaksi();
        this.id_transaksi = et.insertTransaksi(ts);
        TransaksiObat to = new TransaksiObat(this.id_transaksi);
        to.setVisible(true);
        this.dispose();
        System.out.println("ID TRANSAKSI : " + this.id_transaksi);
        
    }//GEN-LAST:event_btnLanjutkanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(PilihPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PilihPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PilihPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PilihPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PilihPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLanjutkan;
    private javax.swing.JButton btnSubmitPasien;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taAlamatPasien;
    private javax.swing.JTable tblPasien;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNoTelpPasien;
    // End of variables declaration//GEN-END:variables
}