package uygulama;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormMusteriEkle extends javax.swing.JFrame {

    DB db = new DB();
    static boolean durum = false;

    public FormMusteriEkle() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/musteri_ekle.png")).getImage());
        durum = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOlustur = new javax.swing.JPanel();
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
        setTitle("Müşteri Oluşturma");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelOlustur.setBorder(javax.swing.BorderFactory.createTitledBorder("Müşteri Oluşturma"));

        txtAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdresKeyPressed(evt);
            }
        });

        btnEkle.setText("Müşteri Oluştur");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel1.setText("Müşteri Adı:");

        jLabel2.setText("Müşteri Soyadı:");

        jLabel3.setText("Müşteri Telefon:");

        jLabel4.setText("Müşteri Adres:");

        javax.swing.GroupLayout panelOlusturLayout = new javax.swing.GroupLayout(panelOlustur);
        panelOlustur.setLayout(panelOlusturLayout);
        panelOlusturLayout.setHorizontalGroup(
            panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOlusturLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOlusturLayout.createSequentialGroup()
                        .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(117, 117, 117)
                        .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdi)
                            .addComponent(txtSoyadi)
                            .addComponent(txtTelefon)
                            .addComponent(txtAdres, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOlusturLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEkle)))
                .addContainerGap())
        );
        panelOlusturLayout.setVerticalGroup(
            panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOlusturLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelOlusturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnEkle)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                String yazQuery = "insert into musteriler values(null, '" + adi + "', '" + soyadi + "', '" + telefon + "', '" + adres + "' ) ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    AnaForm.musteriVerileri();
                    JOptionPane.showMessageDialog(rootPane, "Müşteri başarı ile kaydedildi.");
                    txtAdi.setText("");
                    txtSoyadi.setText("");
                    txtTelefon.setText("");
                    txtAdres.setText("");
                    txtAdi.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Müşteri kayıt işlemi başarısız oldu!");
                }
            } catch (SQLException ex) {
                System.err.println("Müşteri kaydetme hatası : " + ex);
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
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
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
            java.util.logging.Logger.getLogger(FormMusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMusteriEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelOlustur;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtSoyadi;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

}
