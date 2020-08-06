/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaan.Koneksi;

/**
 *
 * @author oyeaaa
 */
public class formKoleksiBuku extends javax.swing.JInternalFrame {

    /**
     * Creates new form formKoleksiBuku
     */
    public formKoleksiBuku() {
        initComponents();
        
        load_data();
    }
    
    private void load_data() {
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblKoleksiBuku.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit"
                    + " FROM buku "
                    + " WHERE status = 'ADA'"
                    + " ORDER BY id_buku ";
                    
            // Eksekusi query ke database
            ResultSet rs = stmt.executeQuery(sql);
            
            // Selama hasil ada ( true )
            while(rs.next()) {
                String id_buku = rs.getString(1);
                String judul_buku = rs.getString(2);
                String penerbit = rs.getString(3);
                String penulis = rs.getString(4);
                String deskripsi = rs.getString(5);
                String tahun_terbit = rs.getString(6);
                
                // Tambahkan data dari database ke tabel
                String d[] = {id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit};
                data.addRow(d);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            formUtamaAdmin utamaAdmin = new formUtamaAdmin();
            utamaAdmin.setVisible(true);
            this.dispose();
        }
    }
    
    private void load_data_cari() {
         // Koneksi ke database
       Connection kon = Koneksi.koneksiDB();

       // Nama header tabel
       Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT"};
       DefaultTableModel data = new DefaultTableModel(null, tableHeader);

       // Tambahkan data ke tabel Buku
       tblKoleksiBuku.setModel(data);

       try {
           // Mempersiapkan statement
           Statement stmt = kon.createStatement();

           // Query sql
           String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit"
                   + " FROM buku"
                   + " WHERE judul_buku LIKE '%"+txtCari.getText()+"%' AND status = 'ADA'"
                   + " ORDER BY id_buku";

           // Eksekusi query ke database
           ResultSet rs = stmt.executeQuery(sql);

           // Selama hasil ada ( true )
           while(rs.next()) {
               String id_buku = rs.getString(1);
               String judul_buku = rs.getString(2);
               String penerbit = rs.getString(3);
               String penulis = rs.getString(4);
               String deskripsi = rs.getString(5);
               String tahun_terbit = rs.getString(6);

               // Tambahkan data dari database ke tabel
               String d[] = {id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit};
               data.addRow(d);
           } 
           
           ResultSet rs2 = stmt.executeQuery(sql);
           
           if(!rs2.next()) {
               JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
               load_data();
           }
       } catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
           load_data();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKoleksiBuku = new javax.swing.JTable();
        btnPinjam = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 632));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR KOLEKSI BUKU PERPUSTAKAAN");
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 15));

        tblKoleksiBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKoleksiBuku);

        btnPinjam.setText("PINJAM BUKU");

        btnKembali.setText("KEMBALI");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        txtCari.setText("Cari judul buku disini");
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon.png"))); // NOI18N
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(539, 539, 539)
                            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(btnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        load_data_cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKoleksiBuku;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
