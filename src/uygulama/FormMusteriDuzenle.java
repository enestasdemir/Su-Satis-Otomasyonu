package uygulama;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormMusteriDuzenle extends javax.swing.JFrame {

    static String mid = "";
    static boolean durum = false;

    DB db = new DB();

    public FormMusteriDuzenle() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/musteri_duzenle.png")).getImage());
        durum = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDuzenle = new javax.swing.JPanel();
        txtAdi = new javax.swing.JTextField();
        txtSoyadi = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        btnEkle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Müşteri Düzenleme");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelDuzenle.setBorder(javax.swing.BorderFactory.createTitledBorder("Müşteri Güncelleme"));

        txtAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdresKeyPressed(evt);
            }
        });

        btnEkle.setText("Müşteri Güncelle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel1.setText("Müşteri Adı:");

        jLabel2.setText("Müşteri Soyadı:");

        jLabel3.setText("Müşteri Telefon:");

        jLabel4.setText("Müşteri Adres:");

        javax.swing.GroupLayout panelDuzenleLayout = new javax.swing.GroupLayout(panelDuzenle);
        panelDuzenle.setLayout(panelDuzenleLayout);
        panelDuzenleLayout.setHorizontalGroup(
            panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdres, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoyadi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEkle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAdi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelDuzenleLayout.setVerticalGroup(
            panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDuzenleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnEkle)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        String adi = txtAdi.getText().trim();
        String soyadi = txtSoyadi.getText().trim();
        String telefon = txtTelefon.getText().trim();
        String adres = txtAdres.getText().trim();

        if (adi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen müşteri adını giriniz!");
            txtAdi.requestFocus();
        } else if (soyadi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen müşteri soyadını giriniz!");
            txtSoyadi.requestFocus();
        } else if (telefon.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen müşteri telefonunu giriniz!");
            txtTelefon.requestFocus();
        } else if (adres.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen müşteri adresini giriniz!");
            txtAdres.requestFocus();
        } else {
            try {
                String yazQuery = "UPDATE musteriler SET mAdi = '" + adi + "', mSoyadi = '" + soyadi + "', mTelefon = '" + telefon + "', mAdres = '" + adres + "' WHERE mID = '" + mid + "' ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    AnaForm.musteriVerileri();
                    JOptionPane.showMessageDialog(rootPane, "Müşteri başarı ile güncellendi.");
                    txtAdi.setText("");
                    txtSoyadi.setText("");
                    txtTelefon.setText("");
                    txtAdres.setText("");
                    txtAdi.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Müşteri güncelleme işlemi başarısız oldu!");
                }
            } catch (SQLException ex) {
                System.err.println("Müşteri güncelleme işlemi hatası : " + ex);
                if (ex.toString().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı telefon numarası ile birden fazla kayıt yapılamaz!");
                }
            } finally {
                db.kapat();
                dispose();
            }
        }
    }//GEN-LAST:event_btnEkleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        durum = false;
    }//GEN-LAST:event_formWindowClosed

    private void txtAdresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEkleActionPerformed(null);
        }
    }//GEN-LAST:event_txtAdresKeyPressed

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
            java.util.logging.Logger.getLogger(FormMusteriDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMusteriDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMusteriDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMusteriDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMusteriDuzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelDuzenle;
    public javax.swing.JTextField txtAdi;
    public javax.swing.JTextField txtAdres;
    public javax.swing.JTextField txtSoyadi;
    public javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

}
