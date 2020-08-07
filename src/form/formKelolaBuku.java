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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaan.Koneksi;

/**
 *
 * @author oyeaaa
 */
public class formKelolaBuku extends javax.swing.JInternalFrame {
    
    // Format tanggal
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    
    /**
     * Creates new form formKelolaBuku
     */
    public formKelolaBuku() {
        initComponents();
        load_data();
        
        // Set tanggal sekarang
        txtTanggal.setText(dateFormat.format(date));
        
        // Set id admin sesuai dengan yang login
        txtIdAdmin.setText(Integer.toString(formLoginAdmin.getId()));
        txtNamaAdmin.setText(formLoginAdmin.getNama());
        
        // Tanggal, id admin dan nama admin tidak bisa diedit
        txtTanggal.setEditable(false);
        txtIdAdmin.setEditable(false);
        txtNamaAdmin.setEditable(false);
        
        // Edit dan Hapus data tidak bisa sebelum memilih data yang akan dihapus
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        
    }
    
    private void load_data() {
        
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT", "TANGGAL DITAMBAHKAN", "DITAMBAHKAN", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblBuku.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status "
                    + " FROM buku "
                    + " INNER JOIN admin ON buku.id_admin = admin.id_admin"
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
                String date_created = rs.getString(7);
                String nama_admin = rs.getString(8);
                String status = rs.getString(9);
                
                // Tambahkan data dari database ke tabel
                String d[] = {id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status};
                data.addRow(d);
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            formUtamaAdmin utamaAdmin = new formUtamaAdmin();
            utamaAdmin.setVisible(true);
            this.dispose();
        }
    }
    
    private void load_data_status(String x) {
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Nama header tabel
        Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT", "TANGGAL DITAMBAHKAN", "DITAMBAHKAN", "STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, tableHeader);
        
        // Tambahkan data ke tabel Buku
        tblBuku.setModel(data);
            
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status "
                    + " FROM buku "
                    + " INNER JOIN admin ON buku.id_admin = admin.id_admin"
                    + " WHERE status = '"+x+"'"
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
                String date_created = rs.getString(7);
                String nama_admin = rs.getString(8);
                String status = rs.getString(9);
                
                // Tambahkan data dari database ke tabel
                String d[] = {id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status};
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
       Object tableHeader[] = {"ID BUKU", "JUDUL BUKU", "PENERBIT", "PENULIS", "DESKRIPSI", "TAHUN TERBIT", "TANGGAL DITAMBAHKAN", "DITAMBAHKAN", "STATUS"};
       DefaultTableModel data = new DefaultTableModel(null, tableHeader);

       // Tambahkan data ke tabel Buku
       tblBuku.setModel(data);

       try {
           // Mempersiapkan statement
           Statement stmt = kon.createStatement();

           // Query sql
           String sql = "SELECT id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status "
                   + " FROM buku "
                   + " INNER JOIN admin ON buku.id_admin = admin.id_admin"
                   + " WHERE judul_buku LIKE '%"+txtCari.getText()+"%'"
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
               String date_created = rs.getString(7);
               String nama_admin = rs.getString(8);
               String status = rs.getString(9);

               // Tambahkan data dari database ke tabel
               String d[] = {id_buku, judul_buku, penerbit, penulis, deskripsi, tahun_terbit, date_created, nama_admin, status};
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
    
    private void tambah_data() {
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        try {    
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "INSERT INTO buku"
                    + " VALUES (default,'"+txtJudulBuku.getText()
                    +"','"+txtPenerbit.getText()
                    +"','"+txtPenulis.getText()
                    +"','"+txtDeskripsi.getText()
                    +"','"+cbTahun.getSelectedItem()
                    +"','"+txtTanggal.getText()
                    +"','"+txtIdAdmin.getText()
                    +"', 'ADA');";
            
            // Eksekusi ke database
            int baris = stmt.executeUpdate(sql);
            
            // Jika baris / data bertambah
            // Tampilkan data terbaru
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
        
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        try {
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "UPDATE buku SET judul_buku = '"+txtJudulBuku.getText()
                    +"', penerbit = '"+txtPenerbit.getText()
                    +"', penulis = '"+txtPenulis.getText()
                    +"', deskripsi = '"+txtDeskripsi.getText()
                    +"', tahun_terbit = '"+cbTahun.getSelectedItem()
                    +"', date_created = '"+txtTanggal.getText()
                    +"', id_admin = '"+txtIdAdmin.getText()
                    +"', status = 'ADA' "
                    + "WHERE id_buku = '"+tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString()+"'";
            
            // Eksekusi query ke database
            int baris = stmt.executeUpdate(sql);
            
            // Jika data berpengaruh
            // Tampilkan pesan berhasil
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
        
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        try {
            
            // Mempersiapkan statement
            Statement stmt = kon.createStatement();
            
            // Query sql
            String sql = "UPDATE buku SET status = 'DIHAPUS' WHERE id_buku = '"+tblBuku.getValueAt(tblBuku.getSelectedRow(), 0).toString()+"'";
            
            // Eksekusi query ke database
            int baris = stmt.executeUpdate(sql);
            
            // Jika database berpengaruh
            // Tampilkan pesan berhasil dan sebaliknya
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
        
        // Unset semua field
        txtJudulBuku.setText("");
        txtPenerbit.setText("");
        txtPenulis.setText("");
        txtDeskripsi.setText("");
        cbTahun.setSelectedItem(1);
    }
    
    private int getId(String x) {
        
        // Koneksi ke database
        Connection kon = Koneksi.koneksiDB();
        
        // Set id_admin = 0
        int id_admin = 0;
        
        try {
            
            // Membuat statement
            Statement stmt = kon.createStatement();
      
            // Query sql
            String sql = "SELECT id_admin FROM admin WHERE nama_admin='"+x+"'";
            
            // Eksekusi query ke database
            ResultSet rs = stmt.executeQuery(sql);
            
            // Mendapatkan hasil dari query
            // Id admin diisi dari hasil query
            while(rs.next()) {
                id_admin = rs.getInt("id_admin");
            }
                    
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        // Kembalikan nilai id_admin
        return id_admin;
    }
    
    private boolean cek_validasi() {
        
        // Set nilai validasi = false
        boolean validasi = false;
        
        // Jika semua field belum diisi, tampilkan pesan
        if(txtJudulBuku.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Judul Buku wajib diisi!");
            txtJudulBuku.requestFocus();
        } else if(txtPenerbit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Penerbit Buku wajib diisi!");
            txtPenerbit.requestFocus();
        } else if(txtPenulis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Penulis harus diisi!");
            txtPenulis.requestFocus();
        } else if(txtDeskripsi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Deskripsi buku wajib diisi!");
            txtDeskripsi.requestFocus();
        } else {
            
            // Jika semua field sudah diisi set validasi menjadi true
            validasi = true;
        }
           
        // Kembalikan nilai validasi
        return validasi;
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
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnSemua = new javax.swing.JButton();
        btnAda = new javax.swing.JButton();
        btnDihapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

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

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
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

        txtCari.setText("Cari Nama Buku disini");
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

        btnSemua.setText("SEMUA");
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });

        btnAda.setText("ADA");
        btnAda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaActionPerformed(evt);
            }
        });

        btnDihapus.setText("DIHAPUS");
        btnDihapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDihapusActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSemua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDihapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDihapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // Jika semua field sudah diisi
        if(cek_validasi()) {
            tambah_data();
            load_data();
            clear_data();
        }     
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // Hapus jinternalframe dan kembali ke menu utama admin
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuMouseClicked

        // Mendapatkan baris yang dipilih 
        int baris = tblBuku.getSelectedRow();
        
        // Set variabel yang diambil dari baris tabel yang diklik
        String judul_buku = tblBuku.getValueAt(baris, 1).toString();
        String penerbit = tblBuku.getValueAt(baris, 2).toString();
        String penulis = tblBuku.getValueAt(baris, 3).toString();
        String deskripsi = tblBuku.getValueAt(baris, 4).toString();
        String tahun_terbit = tblBuku.getValueAt(baris, 5).toString();
        String date_created = tblBuku.getValueAt(baris, 6).toString();
        String nama_admin = tblBuku.getValueAt(baris, 7).toString();
        
        // Mengisi field pada form dengan data tabel yang dipilih
        txtJudulBuku.setText(judul_buku);
        txtPenerbit.setText(penerbit);
        txtPenulis.setText(penulis);
        txtDeskripsi.setText(deskripsi);
        cbTahun.setSelectedItem(tahun_terbit);
        txtTanggal.setText(date_created);
        txtIdAdmin.setText(Integer.toString(getId(nama_admin)));
        txtNamaAdmin.setText(nama_admin);
       
        // Tombol tambah data dimatikan
        btnTambah.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tblBukuMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Jika field sudah disii semua
        if(cek_validasi()) {
            edit_data();
            load_data();
            clear_data();
        }
        
        // Tombol tambah dinyalakan
        btnTambah.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int hapus = JOptionPane.showOptionDialog(this, 
                "Apakah anda yakin untuk menghapus data ini ?", null, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(hapus == JOptionPane.YES_OPTION) {
            if(cek_validasi()) {
                hapus_data();
                load_data();
                clear_data();
                btnHapus.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // Load data ke tabel berdasarkan pencarian
        load_data_cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaActionPerformed
        // Load data tabel sesuai dengan filter ( semua )
        load_data();
    }//GEN-LAST:event_btnSemuaActionPerformed

    private void btnAdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdaActionPerformed
        
        // Load data tabel sesuai dengan filter ( status = ada )
        load_data_status("ADA");
    }//GEN-LAST:event_btnAdaActionPerformed

    private void btnDihapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDihapusActionPerformed
        // Load data tabel sesuai dengan filter ( dihapus )
        load_data_status("DIHAPUS");
    }//GEN-LAST:event_btnDihapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clear_data();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAda;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDihapus;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSemua;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbTahun;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
