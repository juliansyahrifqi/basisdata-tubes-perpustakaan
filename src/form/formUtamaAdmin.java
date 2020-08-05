/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import perpustakaan.MenuLogin;

/**
 *
 * @author oyeaaa
 */
public class formUtamaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form formUtamaAdmin
     */
    public formUtamaAdmin() {
        initComponents();
        
        // Menset ukuran layar utama ke full size
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        txtGreet.setText("SELAMAT DATANG " + formLoginAdmin.getNama().toUpperCase());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JDesktopPane();
        txtGreet = new javax.swing.JLabel();
        btnKelolaBuku = new javax.swing.JButton();
        btnKelolaAnggota = new javax.swing.JButton();
        btnKelolaPeminjaman = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAkun = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuKelolaBuku = new javax.swing.JMenu();
        formKelolaBuku = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuKelolaPinjam = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU UTAMA ADMIN");

        panelUtama.setPreferredSize(new java.awt.Dimension(1366, 632));

        txtGreet.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtGreet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGreet.setPreferredSize(new java.awt.Dimension(1366, 0));

        btnKelolaBuku.setBackground(new java.awt.Color(75, 75, 75));
        btnKelolaBuku.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnKelolaBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnKelolaBuku.setText("Pengelolaan Data Buku");
        btnKelolaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelolaBukuActionPerformed(evt);
            }
        });

        btnKelolaAnggota.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnKelolaAnggota.setText("Pengelolaan Data Anggota");

        btnKelolaPeminjaman.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnKelolaPeminjaman.setText("Pengelolaan Data Peminjaman");
        btnKelolaPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelolaPeminjamanActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton4.setText("Cari Data");

        panelUtama.setLayer(txtGreet, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnKelolaBuku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnKelolaAnggota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnKelolaPeminjaman, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtGreet, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKelolaPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnKelolaBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKelolaAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(txtGreet, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKelolaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKelolaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKelolaPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        menuAkun.setText("Akun");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuAkun.add(menuLogout);

        jMenuBar1.add(menuAkun);

        menuKelolaBuku.setText("Data");

        formKelolaBuku.setText("Data Buku");
        formKelolaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formKelolaBukuActionPerformed(evt);
            }
        });
        menuKelolaBuku.add(formKelolaBuku);
        menuKelolaBuku.add(jSeparator1);

        menuKelolaPinjam.setText("Data Anggota");
        menuKelolaPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKelolaPinjamActionPerformed(evt);
            }
        });
        menuKelolaBuku.add(menuKelolaPinjam);
        menuKelolaBuku.add(jSeparator2);

        jMenuItem4.setText("Data Peminjaman");
        menuKelolaBuku.add(jMenuItem4);

        jMenuBar1.add(menuKelolaBuku);

        jMenu3.setText("Tentang Kami");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // Instance menu login
        MenuLogin menuLogin = new MenuLogin();
        
        menuLogin.setVisible(true);
        this.dispose();
        
        JOptionPane.showMessageDialog(null, "Anda berhasil logout");
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void formKelolaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formKelolaBukuActionPerformed
        // Menghapus komponen lain di panel utama
        panelUtama.removeAll();
        panelUtama.repaint();
        
        // Instance class form kelola buku
        formKelolaBuku kelolaBuku = new formKelolaBuku();
        
        // Mengambil ukuran layar utama dan layar form kelola buku
        Dimension layarUtama = this.getSize();
        Dimension layarKelolaBuku = kelolaBuku.getSize();
        
        // Set posisi form kelola buku ke center
        kelolaBuku.setLocation((layarUtama.width - layarKelolaBuku.width)/2, (layarUtama.height - layarKelolaBuku.height)/4);
        
        // Menambahkan halaman form kelola buku di panel utama
        panelUtama.add(kelolaBuku);
        kelolaBuku.setVisible(true);
        
    }//GEN-LAST:event_formKelolaBukuActionPerformed

    private void btnKelolaPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKelolaPeminjamanActionPerformed

    private void btnKelolaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaBukuActionPerformed
        // TODO add your handling code here:
        
        // Menghapus komponen lain di panel utama
        panelUtama.removeAll();
        panelUtama.repaint();
        
        // Instance class form kelola buku
        formKelolaBuku kelolaBuku = new formKelolaBuku();
        
        // Mengambil ukuran layar utama dan layar form kelola buku
        Dimension layarUtama = this.getSize();
        Dimension layarKelolaBuku = kelolaBuku.getSize();
        
        // Set posisi form kelola buku ke center
        kelolaBuku.setLocation((layarUtama.width - layarKelolaBuku.width)/2, (layarUtama.height - layarKelolaBuku.height)/4);
        
        // Menambahkan halaman form kelola buku di panel utama
        panelUtama.add(kelolaBuku);
        kelolaBuku.setVisible(true);
    }//GEN-LAST:event_btnKelolaBukuActionPerformed

    private void menuKelolaPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKelolaPinjamActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        formKelolaAnggota kelolaAnggota = new formKelolaAnggota();
        
        Dimension layarUtama = this.getSize();
        Dimension layarKelolaAnggota = kelolaAnggota.getSize();
        
        kelolaAnggota.setLocation((layarUtama.width - layarKelolaAnggota.width)/2, (layarUtama.height - layarKelolaAnggota.height)/4);
        
        panelUtama.add(kelolaAnggota);
        kelolaAnggota.setVisible(true);
    }//GEN-LAST:event_menuKelolaPinjamActionPerformed

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
            java.util.logging.Logger.getLogger(formUtamaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formUtamaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formUtamaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formUtamaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formUtamaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKelolaAnggota;
    private javax.swing.JButton btnKelolaBuku;
    private javax.swing.JButton btnKelolaPeminjaman;
    private javax.swing.JMenuItem formKelolaBuku;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuAkun;
    private javax.swing.JMenu menuKelolaBuku;
    private javax.swing.JMenuItem menuKelolaPinjam;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JDesktopPane panelUtama;
    private javax.swing.JLabel txtGreet;
    // End of variables declaration//GEN-END:variables
}
