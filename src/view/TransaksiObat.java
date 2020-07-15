/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.Golongan;
import com.Jabatan;
import com.Supplier;
import com.TransaksiItem;
import db.ConnectionManager;
import exec.ExecuteTransaksiItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import object.ConvertObatToObject;

/**
 *
 * @author ALIK
 */
public class TransaksiObat extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    public TransaksiObat() {
        initComponents();
        setDataObat();
        lblInvoice.setVisible(false);
        txtSubTotal.setEnabled(false);
        txtNamaObat.setEnabled(false);
        txtHargaObat.setEditable(false);
    }
    public TransaksiObat(int id_transaksi) {
        initComponents();
        setDataObat();
        lblInvoice.setVisible(false);
        txtSubTotal.setEnabled(false);
        txtNamaObat.setEnabled(false);
        txtHargaObat.setEditable(false);
        PreparedStatement ps;
        this.id_transaksi = id_transaksi;
        try{
            ConnectionManager conMan = new ConnectionManager();
            Connection conn = conMan.logOn();
            ps = conn.prepareStatement("select invoice from transaksi where id_transaksi=?");
            ps.setInt(1, id_transaksi);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.invoice = rs.getString("invoice");
                System.out.println("Invoice : " + this.invoice);
                lblInvoice.setVisible(true);
                lblInvoice.setText(this.invoice);
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
            
    }
    private void setDataObat(){
        ConvertObatToObject coto = new ConvertObatToObject();
        String[][] dataObat = coto.getObat();
        tblObat.setModel(new javax.swing.table.DefaultTableModel(
            dataObat,
            new String [] {
                "ID Obat", "Nama", "Harga", "Dosis", "Stok", "Satuan", "Keterangan", "ID Golongan", "ID Supplier", "Golongan", "Supplier"
            }
        ));
        jScrollPane3.setViewportView(tblObat);
        
    }
    public int id_obat, id_transaksi, id_pasien, harga;
    public String invoice;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblObat = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnKeranjang = new javax.swing.JButton();
        btnTransaksiLanjut = new javax.swing.JButton();
        txtSubTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHargaObat = new javax.swing.JTextField();
        txtNamaObat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQtyTransaksi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblInvoice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(112, 138, 129));

        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        tblObat.setBackground(new java.awt.Color(112, 138, 129));
        tblObat.setForeground(new java.awt.Color(255, 255, 255));
        tblObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tblObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblObat);

        jPanel1.setBackground(new java.awt.Color(112, 138, 129));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Obat");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Obat");

        btnKeranjang.setText("Masukkan keranjang");
        btnKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeranjangActionPerformed(evt);
            }
        });

        btnTransaksiLanjut.setText("Selesaikan transaksi");
        btnTransaksiLanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiLanjutActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Subtotal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity");

        txtQtyTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyTransaksiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQtyTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnKeranjang)
                    .addComponent(btnTransaksiLanjut))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(txtHargaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQtyTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKeranjang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransaksiLanjut)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(112, 138, 129));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        lblInvoice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInvoice.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoice.setText("invoice");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Invoice");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblInvoice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblInvoice))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObatMouseClicked
        // TODO add your handling code here:
        int row = tblObat.getSelectedRow();
        String id_obat = tblObat.getValueAt(row, 0).toString();
        String nama = tblObat.getValueAt(row, 1).toString();
        String harga = tblObat.getValueAt(row, 2).toString();
        String dosis = tblObat.getValueAt(row, 3).toString();
        String stok = tblObat.getValueAt(row, 4).toString();
        String satuan = tblObat.getValueAt(row,5).toString();
        String keterangan = tblObat.getValueAt(row,6).toString();
        String id_golongan = tblObat.getValueAt(row,7).toString();
        String id_supplier = tblObat.getValueAt(row,8).toString();
        this.id_obat = Integer.parseInt(id_obat);
        this.harga = Integer.parseInt(harga);
        txtNamaObat.setText(nama);
        txtHargaObat.setText(harga);
    }//GEN-LAST:event_tblObatMouseClicked

    private void txtQtyTransaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyTransaksiKeyReleased
        // TODO add your handling code here:
        int qty = 0;
        if(txtQtyTransaksi.getText().equals("")){
            qty = 0;
            txtSubTotal.setText(""+qty*this.harga);
        }else{
            qty = Integer.parseInt(txtQtyTransaksi.getText());
            txtSubTotal.setText(""+qty*this.harga);
        }
        
    }//GEN-LAST:event_txtQtyTransaksiKeyReleased

    private void btnKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeranjangActionPerformed
        // TODO add your handling code here:
        TransaksiItem t = new TransaksiItem(id_transaksi, id_obat, Integer.parseInt(txtQtyTransaksi.getText()), 
                Integer.parseInt(txtSubTotal.getText()));
        ExecuteTransaksiItem ex = new ExecuteTransaksiItem();
        int hasil = ex.insertData(t);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataObat();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnKeranjangActionPerformed

    private void btnTransaksiLanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiLanjutActionPerformed
        // TODO add your handling code here:
        Checkout checkout = new Checkout(this.id_transaksi);
        checkout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransaksiLanjutActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeranjang;
    private javax.swing.JButton btnTransaksiLanjut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JTable tblObat;
    private javax.swing.JTextField txtHargaObat;
    private javax.swing.JTextField txtNamaObat;
    private javax.swing.JTextField txtQtyTransaksi;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
