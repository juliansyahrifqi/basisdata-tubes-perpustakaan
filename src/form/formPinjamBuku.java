/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaan.Koneksi;

/**
 *
 * @author oyeaaa
 */
public class formPinjamBuku extends javax.swing.JInternalFrame {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    
    String tanggalSekarang = dateFormat.format(date);
   
    /**
     * Creates new form formPinjamBuku
     */
    public formPinjamBuku() {
        initComponents();
        load_judul_buku();
        load_pinjam_hari();
            
        txtTanggalPinjam.setText(tanggalSekarang);
        set_tanggal_kembali();
        
        
        txtIdAnggota.setText(Integer.toString(formLoginAnggota.getId()));
        txtNamaAnggota.setText(formLoginAnggota.getNama());
        
        txtIdAnggota.setEditable(false);
        txtNamaAnggota.setEditable(false);
        txtTanggalPinjam.setEditable(false);
        txtTanggalKembali.setEditable(false);
        txtIdBuku.setEditable(false);
        txtPenulis.setEditable(false);
    }
    
    private int getID() {
        
        Connection kon = Koneksi.koneksiDB();
        
        try {
            int no=0;
                
                Statement stmt = kon.createStatement();
                
                String sql = "SELECT COUNT(*) as id_peminjaman from peminjaman ";
                
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    no = rs.getInt("id_peminjaman") + 1;
                }

                rs.close();

                return no;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }    
    
    private void set_tanggal_kembali() {
         
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 5);

        Date expirationDate = cal.getTime();
        
        String kembali = dateFormat.format(expirationDate);

        txtTanggalKembali.setText(kembali);
    }
    
    private void load_judul_buku() {
        Connection kon = Koneksi.koneksiDB();
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT * FROM buku WHERE status = 'ADA'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                cbJudulBuku.addItem(rs.getString("judul_buku"));
            }
            
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void load_penulis_buku() {
        
        Connection kon = Koneksi.koneksiDB();
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT * FROM buku WHERE judul_buku = '"+cbJudulBuku.getSelectedItem()+"'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                txtPenulis.setText(rs.getString("penulis"));
                txtIdBuku.setText(rs.getString("id_buku"));
            }
            
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void pinjam_buku() {
        Connection kon = Koneksi.koneksiDB();
        
        try {
            Statement stmt = kon.createStatement();
            
            String sql = "INSERT INTO peminjaman VALUES (default, '"+txtIdAnggota.getText()+"')";
                    
            String sql2 = "INSERT INTO detail_peminjaman "
                    + " VALUES ('"+getID()+"','"+txtIdBuku.getText()
                    +"','"+txtTanggalPinjam.getText()
                    +"','"+txtTanggalKembali.getText()
                    +"', 'DIPINJAM');";
            
            int baris1 = stmt.executeUpdate(sql);
            int baris2 = stmt.executeUpdate(sql2);
            
            if(baris1 > 0 && baris2 > 0) {
                JOptionPane.showMessageDialog(null, "Pinjam Buku Berhasil!");
            } else {
                JOptionPane.showMessageDialog(null, "Pinjam Buku Gagal!");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void load_pinjam_hari() {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE tanggal_pinjam = '"+tanggalSekarang+"' AND anggota.id_anggota = '"+formLoginAnggota.getId()
                    + "' ORDER BY id_peminjaman";
            
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
    
    private void cari_data() {
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID PEMINJAMAN", "NAMA PEMINJAM", "JUDUL BUKU", "PENULIS", "TANGGAL PINJAM", "TANGGAL KEMBALI", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblPeminjaman.setModel(data);
        
        try {
            Statement stmt = kon.createStatement();

            String sql = "SELECT detail_peminjaman.id_peminjaman, nama_anggota, judul_buku, penulis, tanggal_pinjam, tanggal_kembali, detail_peminjaman.status "
                    + "FROM detail_peminjaman "
                    + "INNER JOIN buku ON detail_peminjaman.id_buku = buku.id_buku "
                    + "INNER JOIN peminjaman ON detail_peminjaman.id_peminjaman = peminjaman.id_peminjaman "
                    + "INNER JOIN anggota ON peminjaman.id_anggota = anggota.id_anggota "
                    + "WHERE tanggal_pinjam = '"+tanggalSekarang+"' AND anggota.id_anggota = '"+formLoginAnggota.getId()
                    +"' AND judul_buku LIKE '%"+txtCari.getText()+"%'"
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

        btnKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdAnggota = new javax.swing.JTextField();
        cbJudulBuku = new javax.swing.JComboBox<>();
        txtTanggalPinjam = new javax.swing.JTextField();
        txtTanggalKembali = new javax.swing.JTextField();
        txtNamaAnggota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnPinjam = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtPenulis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdBuku = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1366, 632));

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM PINJAM BUKU PERPUSTAKAAN");
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 15));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("ID Anggota");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Judul Buku");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Tanggal Peminjaman");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Tanggal Dikembalikan");

        cbJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJudulBukuActionPerformed(evt);
            }
        });

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPeminjaman);

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnPinjam.setText("PINJAM BUKU");
        btnPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamActionPerformed(evt);
            }
        });

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setText("Peminjaman Buku Hari Ini");

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

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Penulis Buku");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnPinjam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh))
                    .addComponent(btnReset)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbJudulBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(272, 272, 272)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJudulBukuActionPerformed
        load_penulis_buku();
    }//GEN-LAST:event_cbJudulBukuActionPerformed

    private void btnPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamActionPerformed
        int pinjam = JOptionPane.showOptionDialog(this, 
                "Anda yakin pinjam buku ini?", null, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(pinjam == JOptionPane.YES_OPTION) {
            pinjam_buku(); 
        }
        
    }//GEN-LAST:event_btnPinjamActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cbJudulBuku.setSelectedItem(0);
        txtPenulis.setText("");
        txtIdBuku.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        load_pinjam_hari();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari_data();
    }//GEN-LAST:event_btnCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbJudulBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtNamaAnggota;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
