/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaan.Koneksi;
import perpustakaan.MenuLogin;

/**
 *
 * @author oyeaaa
 */
public class formKelolaBuku extends javax.swing.JInternalFrame {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    /**
     * Creates new form formKelolaBuku
     */
    public formKelolaBuku() {
        initComponents();
        load_data();
        
        txtTanggal.setText(dateFormat.format(date));
        txtIdAdmin.setText(Integer.toString(formLoginAdmin.getId()));
        txtNamaAdmin.setText(formLoginAdmin.getNama());
        txtTanggal.setEditable(false);
        txtIdAdmin.setEditable(false);
        txtNamaAdmin.setEditable(false);
        
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);

    }
    
    private void load_data() {
        Connection kon = Koneksi.koneksiDB();
        Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT", "TANGGAL DITAMBAHKAN", "DITAMBAHKAN"};
        
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        tblBuku.setModel(data);
            
        try {
            Statement stmt = kon.createStatement();
            
            String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin "
                    + " FROM buku "
                    + " INNER JOIN admin ON buku.id_admin = admin.id_admin";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String id_admin = rs.getString(1);
                String judul_buku = rs.getString(2);
                String penerbit = rs.getString(3);
                String penulis = rs.getString(4);
                String deskripsi = rs.getString(5);
                String tahun_terbit = rs.getString(6);
                String date_created = rs.getString(7);
                String nama_admin = rs.getString(8);
                
                String d[] = {id_admin, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin};
                data.addRow(d);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            formUtamaAdmin utamaAdmin = new formUtamaAdmin();
            utamaAdmin.setVisible(true);
            this.dispose();
        }
    }
    
    private void tambah_data() {
        
        Connection kon = Koneksi.koneksiDB();
        try {    
            Statement stmt = kon.createStatement();
            
            String sql = "INSERT INTO buku"
                    + " VALUES (default,'"+txtJudulBuku.getText()
                    +"','"+txtPenerbit.getText()
                    +"','"+txtPenulis.getText()
                    +"','"+txtDeskripsi.getText()
                    +"','"+cbTahun.getSelectedItem()
                    +"','"+txtTanggal.getText()
                    +"','"+txtIdAdmin.getText()
                    +"');";
            
            int baris = stmt.executeUpdate(sql);
            
            // Jika baris / data bertambah
            // Lanjutkan ke menu login dan tampilkan pesan berhasil
            if(baris > 0) {
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil!");
                load_data();
            } else {
                JOptionPane.showMessageDialog(null, "Tambah Data Gagal!");
            }
           
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "Error :"+er);
        } 
    }
    
    private void edit_data() {
        Connection kon = Koneksi.koneksiDB();
        
        try {
            Statement stmt = kon.createStatement();
            
            String sql = "UPDATE buku SET judul_buku = '"+txtJudulBuku.getText()
                    +"', penerbit = '"+txtPenerbit.getText()
                    +"', penulis = '"+txtPenulis.getText()
                    +"', deskripsi = '"+txtDeskripsi.getText()
                    +"', tahun_terbit = '"+cbTahun.getSelectedItem()
                    +"', date_created = '"+txtTanggal.getText()
                    +"', id_admin = '"+txtIdAdmin.getText()
                    +"' WHERE id_buku = '"+tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString()+"'";
            
            int baris = stmt.executeUpdate(sql);
            
            if(baris>0) {
                JOptionPane.showMessageDialog(null, "Data Buku Berhasil Diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Buku Gagal Diupdate!");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error :"+e);
        }
    }
    
    private void hapus_data() {
        Connection kon = Koneksi.koneksiDB();
        
        try {
            
            Statement stmt = kon.createStatement();
            
            String sql = "DELETE FROM buku WHERE id_buku = '"+tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString()+"'";
            
            int baris = stmt.executeUpdate(sql);
            
            if(baris > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");

            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error :"+e);
        }
    }
    
    private void clear_data() {
        txtJudulBuku.setText("");
        txtPenerbit.setText("");
        txtPenulis.setText("");
        txtDeskripsi.setText("");
        cbTahun.setSelectedItem(1);
    }
    
    private int getId(String x) {
        
        Connection kon = Koneksi.koneksiDB();
        
        int id_admin = 0;
        
        try {
            Statement stmt = kon.createStatement();
      
            String sql = "SELECT id_admin FROM admin WHERE nama_admin='"+x+"'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
   
            id_admin = rs.getInt("id_admin");
           
        } catch(Exception e) {
            
        }
        
        return id_admin;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtJudulBuku = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        txtPenulis = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cbTahun = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIdAdmin = new javax.swing.JTextField();
        txtNamaAdmin = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1366, 632));
        setPreferredSize(new java.awt.Dimension(1366, 632));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM PENGELOLAAN DATA BUKU");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(1320, 43));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Judul Buku");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Penerbit");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Penulis");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Deskripsi");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane1.setViewportView(txtDeskripsi);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Tahun Terbit");

        cbTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Tanggal Ditambahkan");

        btnKembali.setText("KEMBALI");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("ID Admin");

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBuku);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtNamaAdmin))
                                    .addComponent(txtPenulis)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtJudulBuku)
                                    .addComponent(txtPenerbit)
                                    .addComponent(txtTanggal)
                                    .addComponent(cbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambah_data();
        load_data();
        clear_data();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here: 
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuMouseClicked
        // TODO add your handling code here:
        int baris = tblBuku.getSelectedRow();
        
        
        String judul_buku = tblBuku.getValueAt(baris, 1).toString();
        String penerbit = tblBuku.getValueAt(baris, 2).toString();
        String penulis = tblBuku.getValueAt(baris, 3).toString();
        String deskripsi = tblBuku.getValueAt(baris, 4).toString();
        String tahun_terbit = tblBuku.getValueAt(baris, 5).toString();
        String date_created = tblBuku.getValueAt(baris, 6).toString();
        String nama_admin = tblBuku.getValueAt(baris, 7).toString();
        
        
        txtJudulBuku.setText(judul_buku);
        txtPenerbit.setText(penerbit);
        txtPenulis.setText(penulis);
        txtDeskripsi.setText(deskripsi);
        cbTahun.setSelectedItem(tahun_terbit);
        txtTanggal.setText(date_created);
        txtIdAdmin.setText(Integer.toString(getId(nama_admin)));
        txtNamaAdmin.setText(nama_admin);
       
        
        btnTambah.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tblBukuMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        edit_data();
        load_data();
        clear_data();

        btnTambah.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus_data();
        load_data();
        clear_data();
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
