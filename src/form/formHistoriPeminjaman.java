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
public class formHistoriPeminjaman extends javax.swing.JInternalFrame {

    /**
     * Creates new form formHistoriPeminjaman
     */
    public formHistoriPeminjaman() {
        initComponents();
        
        load_data_peminjaman();
    }
    
    public void load_data_peminjaman() {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblHistoriPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE anggota.id_anggota = '"+formLoginAnggota.getId()
                    + "' ORDER BY detail_peminjaman.id_peminjaman";
            
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
        
        tblHistoriPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE anggota.id_anggota = '"+formLoginAnggota.getId()
                    + "'AND detail_peminjaman.status = '"+stat+"'"
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
        
        tblHistoriPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE judul_buku LIKE '%"+txtCariBuku.getText()+"%' "
                    + "AND anggota.id_anggota = '"+formLoginAnggota.getId()+"'"
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
        tblHistoriPeminjaman = new javax.swing.JTable();
        btnSemua = new javax.swing.JButton();
        btnDipinjam = new javax.swing.JButton();
        btnDikembalikan = new javax.swing.JButton();
        txtCariBuku = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1366, 632));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORI PEMINJAMAN BUKU");
        jLabel1.setPreferredSize(new java.awt.Dimension(1322, 43));

        tblHistoriPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblHistoriPeminjaman);

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

        txtCariBuku.setText("Cari nama buku disini");
        txtCariBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariBukuMouseClicked(evt);
            }
        });

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-icon.png"))); // NOI18N
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSemua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDipinjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDikembalikan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1311, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDikembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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

    private void txtCariBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariBukuMouseClicked
        txtCariBuku.setText("");
    }//GEN-LAST:event_txtCariBukuMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari_data();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDikembalikan;
    private javax.swing.JButton btnDipinjam;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSemua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistoriPeminjaman;
    private javax.swing.JTextField txtCariBuku;
    // End of variables declaration//GEN-END:variables
}
