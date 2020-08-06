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
public class formUtamaAnggota extends javax.swing.JFrame {

    /**
     * Creates new form formUtamaAnggota
     */
    public formUtamaAnggota() {
        
        initComponents();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        txtGreet.setText("SELAMAT DATANG, " + formLoginAnggota.getNama());
    }
    
    private void do_logout() {
        MenuLogin menuLogin = new MenuLogin();
        
        menuLogin.setVisible(true);
        this.dispose();
        
        JOptionPane.showMessageDialog(null, "Anda berhasil logout");
    }
    
    private void show_profile() {
        // Menghapus komponen lain di panel utama
        panelUtama.removeAll();
        panelUtama.repaint();
        
        // Instance class form kelola buku
        formProfile myProfile = new formProfile();
        
        // Mengambil ukuran layar utama dan layar form kelola buku
        Dimension layarUtama = this.getSize();
        Dimension layarProfile = myProfile.getSize();
        
        // Set posisi form kelola buku ke center
        myProfile.setLocation((layarUtama.width - layarProfile.width)/2, (layarUtama.height - layarProfile.height)/4);
        
        System.out.println(layarProfile.width);
        System.out.println(layarProfile.height);
        
        // Menambahkan halaman form kelola buku di panel utama
        panelUtama.add(myProfile);
        myProfile.setVisible(true);
        
        // Menambahkan kembali komponen yang ada di panel utama
        panelUtama.add(txtGreet);
        panelUtama.add(btnProfile);
        panelUtama.add(btnKoleksiBuku);
        panelUtama.add(btnPinjamBuku);
        panelUtama.add(btnHistoriPinjam);
        panelUtama.add(btnLogout);
    }
    
    private void show_buku() {
                // Menghapus komponen lain di panel utama
        panelUtama.removeAll();
        panelUtama.repaint();
        
        // Instance class form kelola buku
        formKoleksiBuku koleksiBuku = new formKoleksiBuku();
        
        // Mengambil ukuran layar utama dan layar form kelola buku
        Dimension layarUtama = this.getSize();
        Dimension layarKoleksi = koleksiBuku.getSize();
        
        // Set posisi form kelola buku ke center
        koleksiBuku.setLocation((layarUtama.width - layarKoleksi.width)/2, (layarUtama.height - layarKoleksi.height)/4);
        
        // Menambahkan halaman form kelola buku di panel utama
        panelUtama.add(koleksiBuku);
        koleksiBuku.setVisible(true);
        
        // Menambahkan kembali komponen yang ada di panel utama
        panelUtama.add(txtGreet);
        panelUtama.add(btnProfile);
        panelUtama.add(btnKoleksiBuku);
        panelUtama.add(btnPinjamBuku);
        panelUtama.add(btnHistoriPinjam);
        panelUtama.add(btnLogout);
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
        btnProfile = new javax.swing.JButton();
        btnKoleksiBuku = new javax.swing.JButton();
        btnPinjamBuku = new javax.swing.JButton();
        btnHistoriPinjam = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtGreet = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAkun = new javax.swing.JMenu();
        menuProfile = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuData = new javax.swing.JMenu();
        menuKoleksiBuku = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtama.setPreferredSize(new java.awt.Dimension(1366, 632));

        btnProfile.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnProfile.setText("My Profile");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnKoleksiBuku.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnKoleksiBuku.setText("Daftar Koleksi Perpustakaan");
        btnKoleksiBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoleksiBukuActionPerformed(evt);
            }
        });

        btnPinjamBuku.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnPinjamBuku.setText("Pinjam Buku");

        btnHistoriPinjam.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnHistoriPinjam.setText("Histori Peminjaman Buku");

        btnLogout.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtGreet.setFont(new java.awt.Font("American Captain", 0, 48)); // NOI18N
        txtGreet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGreet.setPreferredSize(new java.awt.Dimension(1366, 15));

        panelUtama.setLayer(btnProfile, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnKoleksiBuku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnPinjamBuku, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnHistoriPinjam, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(btnLogout, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelUtama.setLayer(txtGreet, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtGreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(btnPinjamBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHistoriPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnKoleksiBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGap(561, 561, 561)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtGreet, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKoleksiBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinjamBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistoriPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        menuAkun.setText("Akun");

        menuProfile.setText("My Profile");
        menuProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProfileActionPerformed(evt);
            }
        });
        menuAkun.add(menuProfile);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuAkun.add(menuLogout);

        jMenuBar1.add(menuAkun);

        menuData.setText("Data");

        menuKoleksiBuku.setText("Daftar Koleksi Perpustakaan");
        menuKoleksiBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKoleksiBukuActionPerformed(evt);
            }
        });
        menuData.add(menuKoleksiBuku);
        menuData.add(jSeparator1);

        jMenuItem3.setText("Data Peminjaman");
        menuData.add(jMenuItem3);
        menuData.add(jSeparator2);

        jMenuItem4.setText("Histori Peminjaman");
        menuData.add(jMenuItem4);

        jMenuBar1.add(menuData);

        jMenu1.setText("Pinjam Buku");
        jMenuBar1.add(jMenu1);

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
        // Jika pengguna melakukan logout, lanjutkan ke menu login
        
        do_logout();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        do_logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void menuKoleksiBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKoleksiBukuActionPerformed
        show_buku();
    }//GEN-LAST:event_menuKoleksiBukuActionPerformed

    private void menuProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProfileActionPerformed
        show_profile();
    }//GEN-LAST:event_menuProfileActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        show_profile();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnKoleksiBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoleksiBukuActionPerformed
        show_buku();
    }//GEN-LAST:event_btnKoleksiBukuActionPerformed

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
            java.util.logging.Logger.getLogger(formUtamaAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formUtamaAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formUtamaAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formUtamaAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formUtamaAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistoriPinjam;
    private javax.swing.JButton btnKoleksiBuku;
    public javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPinjamBuku;
    private javax.swing.JButton btnProfile;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuAkun;
    private javax.swing.JMenu menuData;
    private javax.swing.JMenuItem menuKoleksiBuku;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuProfile;
    private javax.swing.JDesktopPane panelUtama;
    private javax.swing.JLabel txtGreet;
    // End of variables declaration//GEN-END:variables
}
