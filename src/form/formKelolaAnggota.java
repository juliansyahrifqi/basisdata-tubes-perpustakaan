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
public class formKelolaAnggota extends javax.swing.JInternalFrame {

    /**
     * Creates new form formKelolaAnggota
     */
    public formKelolaAnggota() {
        initComponents();
        load_data();
        
        // Btn hapus dinonaktifkan
        btnHapus.setEnabled(false);
    }
    
    private void load_data() {
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID ANGGOTA", "NAMA ANGGOTA", "NO TELEPON", "ALAMAT", "USERNAME", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblAnggota.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT * FROM anggota";
            
            // Eksekusi query ke database
            ResultSet rs = stmt.executeQuery(sql);
            
            // Selama hasil ada ( true )
            while(rs.next()) {
                String id_anggota = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String no_tlp = rs.getString(3);
                String alamat = rs.getString(4);
                String username = rs.getString(5);
                String status = rs.getString(7);
                
                // Tambahkan data dari hasil query ke tabel
                String d[] = {id_anggota, nama_anggota, no_tlp, alamat, username, status};
                data.addRow(d);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            formUtamaAdmin utamaAdmin = new formUtamaAdmin();
            utamaAdmin.setVisible(true);
            this.dispose();
        }
    }
    
    private void load_data_status(String stat) {
        
        // Mempersiapkan koneksi
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID ANGGOTA", "NAMA ANGGOTA", "NO TELEPON", "ALAMAT", "USERNAME", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblAnggota.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT * FROM anggota WHERE status = '"+stat+"'";
            
            // Eksekusi query ke database
            ResultSet rs = stmt.executeQuery(sql);
            
            // Selama hasil ada ( true )
            while(rs.next()) {
                String id_anggota = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String no_tlp = rs.getString(3);
                String alamat = rs.getString(4);
                String username = rs.getString(5);
                String status = rs.getString(7);
                
                // Tambahkan data dari database ke tabel
                String d[] = {id_anggota, nama_anggota, no_tlp, alamat, username, status};
                data.addRow(d);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            load_data();
        }
    }
    
    private void load_data_cari() {
        
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID ANGGOTA", "NAMA ANGGOTA", "NO TELEPON", "ALAMAT", "USERNAME", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblAnggota.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT * FROM anggota WHERE nama_anggota LIKE '%"+txtCari.getText()+"%'";
            
            // Eksekusi query ke database
            ResultSet rs = stmt.executeQuery(sql);
            
            // Selama hasil ada ( true )
            while(rs.next()) {
                String id_anggota = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String no_tlp = rs.getString(3);
                String alamat = rs.getString(4);
                String username = rs.getString(5);
                String status = rs.getString(7);
                
                // Tambahkan data dari database ke tabel
                String d[] = {id_anggota, nama_anggota, no_tlp, alamat, username, status};
                data.addRow(d);
                 
            } 
            
            // Resultset 2 ketika data rs2.next = false ( data tidak ada )
            ResultSet rs2 = stmt.executeQuery(sql);
            
            // Jika data tidak ada
            if(!rs2.next()) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                load_data();
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            load_data();
        }
    }
    
    private void hapus_data() {
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        try {
            
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "UPDATE anggota SET status = 'TIDAK AKTIF' WHERE id_anggota = '"+tblAnggota.getValueAt(tblAnggota.getSelectedRow(), 0).toString()+"'";
            // Eksekusi query ke database
            int baris = stmt.executeUpdate(sql);
            
            // Jika database berpengaruh
            // Tampilkan pesan berhasil
            if(baris > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");

            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error :"+e);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnAktif = new javax.swing.JButton();
        btnNonaktif = new javax.swing.JButton();
        btnSemua = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 632));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PENGELOLAAN DATA ANGGOTA");
        jLabel2.setPreferredSize(new java.awt.Dimension(1366, 43));

        tblAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAnggota);

        btnHapus.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapus.setText("HAPUS DATA");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnAktif.setText("ANGGOTA AKTIF");
        btnAktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAktifActionPerformed(evt);
            }
        });

        btnNonaktif.setText("ANGGOTA TIDAK AKTIF");
        btnNonaktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNonaktifActionPerformed(evt);
            }
        });

        btnSemua.setText("SEMUA ANGGOTA");
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });

        txtCari.setText("Cari nama anggota disini");
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

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N

        btnKembali.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 206, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSemua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAktif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNonaktif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(514, 514, 514))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNonaktif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnggotaMouseClicked
        // TODO add your handling code here:
        // Mendapatkan baris yang dipilih     
        // Tombol tambah data dimatikan
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tblAnggotaMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int hapus = JOptionPane.showOptionDialog(this, 
                "Apakah anda yakin untuk menghapus data ini ?", null, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(hapus == JOptionPane.YES_OPTION) {
            hapus_data();
            load_data();
            btnHapus.setEnabled(false);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnAktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAktifActionPerformed
        // TODO add your handling code here:
        load_data_status("AKTIF");
    }//GEN-LAST:event_btnAktifActionPerformed

    private void btnSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaActionPerformed
        // TODO add your handling code here:
        load_data();
    }//GEN-LAST:event_btnSemuaActionPerformed

    private void btnNonaktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNonaktifActionPerformed
        load_data_status("TIDAK AKTIF");
    }//GEN-LAST:event_btnNonaktifActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        load_data_cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        load_data();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAktif;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnNonaktif;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSemua;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAnggota;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
