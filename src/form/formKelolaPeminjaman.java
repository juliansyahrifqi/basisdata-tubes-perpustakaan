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
public class formKelolaPeminjaman extends javax.swing.JInternalFrame {

    
    /**
     * Creates new form formKelolaPeminjaman
     */
    public formKelolaPeminjaman() {
        initComponents();
        
        load_data_peminjaman();
        btnKembalikanBuku.setEnabled(false);
    }
    
    public void load_data_peminjaman() {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblKelolaPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "ORDER BY detail_peminjaman.id_peminjaman";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_peminjaman = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String judul_buku = rs.getString(3);
                String penulis = rs.getString(4);
                String tanggal_pinjam = rs.getString(5);
                String tanggal_kembali = rs.getString(6);
                String status = rs.getString(7);
                
                
                String d[] = {id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, status};
                data.addRow(d);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void load_data_filter(String stat) {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblKelolaPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE detail_peminjaman.status = '"+stat+"'"
                    + "ORDER BY detail_peminjaman.id_peminjaman";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_peminjaman = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String judul_buku = rs.getString(3);
                String penulis = rs.getString(4);
                String tanggal_pinjam = rs.getString(5);
                String tanggal_kembali = rs.getString(6);
                String status = rs.getString(7);
                
                
                String d[] = {id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, status};
                data.addRow(d);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cari_data() {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblKelolaPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE judul_buku LIKE '%"+txtCari.getText()+"%'"
                    + "ORDER BY detail_peminjaman.id_peminjaman";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_peminjaman = rs.getString(1);
                String nama_anggota = rs.getString(2);
                String judul_buku = rs.getString(3);
                String penulis = rs.getString(4);
                String tanggal_pinjam = rs.getString(5);
                String tanggal_kembali = rs.getString(6);
                String status = rs.getString(7);
                
                
                String d[] = {id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, status};
                data.addRow(d);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void kembalikan() {
        Connection kon = Koneksi.koneksiDB();
        
        try {
            
            Statement stmt = kon.createStatement();
            
            String sql = "UPDATE detail_peminjaman SET "
                    + " status = 'DIKEMBALIKAN'"
                    + "WHERE id_peminjaman = '"+tblKelolaPeminjaman.getValueAt(tblKelolaPeminjaman.getSelectedRow(), 0).toString()+"'";
        
            int baris = stmt.executeUpdate(sql);
            
            if(baris > 0 ) {
                JOptionPane.showMessageDialog(null, "Peminjaman berhasil dikembalikan!");
                load_data_peminjaman();
            } else {
                JOptionPane.showMessageDialog(null, "Peminjaman gagal dikembalikan!");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKelolaPeminjaman = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnKembalikanBuku = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSemua = new javax.swing.JButton();
        btnDipinjam = new javax.swing.JButton();
        btnDikembalikan = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 632));

        tblKelolaPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKelolaPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKelolaPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKelolaPeminjaman);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PENGELOLAAN DATA PEMINJAMAN BUKU");
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 57));

        btnKembalikanBuku.setText("KEMBALIKAN BUKU");
        btnKembalikanBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanBukuActionPerformed(evt);
            }
        });

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnRefresh.setText("REFRESH DATA");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSemua.setText("SEMUA");
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });

        btnDipinjam.setText("DIPINJAM");
        btnDipinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDipinjamActionPerformed(evt);
            }
        });

        btnDikembalikan.setText("DIKEMBALIKAN");
        btnDikembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDikembalikanActionPerformed(evt);
            }
        });

        txtCari.setText("Cari nama buku");
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addGap(36, 36, 36)
                        .addComponent(btnKembalikanBuku)
                        .addGap(557, 557, 557))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSemua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDipinjam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDikembalikan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDikembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembalikanBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaActionPerformed
        load_data_peminjaman();
    }//GEN-LAST:event_btnSemuaActionPerformed

    private void btnDipinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDipinjamActionPerformed
        load_data_filter("DIPINJAM");
    }//GEN-LAST:event_btnDipinjamActionPerformed

    private void btnDikembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDikembalikanActionPerformed
        load_data_filter("DIKEMBALIKAN");
    }//GEN-LAST:event_btnDikembalikanActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        load_data_peminjaman();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari_data();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblKelolaPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKelolaPeminjamanMouseClicked
        btnKembalikanBuku.setEnabled(true);
    }//GEN-LAST:event_tblKelolaPeminjamanMouseClicked

    private void btnKembalikanBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanBukuActionPerformed
        kembalikan();
    }//GEN-LAST:event_btnKembalikanBukuActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDikembalikan;
    private javax.swing.JButton btnDipinjam;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKembalikanBuku;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSemua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKelolaPeminjaman;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
