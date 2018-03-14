package uygulama;

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormAyarlar extends javax.swing.JFrame {

    static boolean durum = false;
    String yoneticiID = "";

    DB db = new DB();

    public FormAyarlar() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/disliler.png")).getImage());
        durum = true;
        yoneticiVerileri();
        txtGecerliParola.requestFocus();
    }

    public void yoneticiVerileri() {
        try {
            String musteriQuery = "select kID, kAdi from ayarlar ";
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            DefaultTableModel dtmy = new DefaultTableModel();
            dtmy.addColumn("ID");
            dtmy.addColumn("Adı");
            while (rs.next()) {
                dtmy.addRow(new String[]{rs.getString("kID"), rs.getString("kAdi")});
                yTablo.setModel(dtmy);
            }
        } catch (Exception e) {
            System.out.println("Data getirme hatası: " + e);
        } finally {
            db.kapat();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblKullanici = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtGecerliParola = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtYeniParola = new javax.swing.JPasswordField();
        txtYeniParolaTekrar = new javax.swing.JPasswordField();
        btnKapat = new javax.swing.JButton();
        btnKaydet = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtYKullaniciAdi = new javax.swing.JTextField();
        btnYKapat = new javax.swing.JButton();
        btnYOlustur = new javax.swing.JButton();
        txtYYeniParola = new javax.swing.JPasswordField();
        txtYYeniParolaTekrar = new javax.swing.JPasswordField();
        txtYGecerliParola = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        yTablo = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtSGecerliParola = new javax.swing.JPasswordField();
        btnYoneticiSil = new javax.swing.JButton();
        btnSKapat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yönetici Ayarları");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Yönetici Ayarları"));

        lblKullanici.setText("Oturum açmış kullanıcı:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText(AnaForm.adminAdi);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Şifre Güncelleme"));

        jLabel1.setText("Geçerli Parola:");

        jLabel2.setText("Yeni Parola:");

        jLabel3.setText("Yeni Parola (Tekrar):");

        btnKapat.setText("Kapat");
        btnKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKapatActionPerformed(evt);
            }
        });

        btnKaydet.setText("Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 174, Short.MAX_VALUE)
                        .addComponent(btnKaydet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKapat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGecerliParola)
                            .addComponent(txtYeniParola)
                            .addComponent(txtYeniParolaTekrar))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGecerliParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtYeniParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtYeniParolaTekrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKapat)
                    .addComponent(btnKaydet))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Yönetici Oluştur"));

        jLabel5.setText("Geçerli Parola:");

        jLabel6.setText("Kullanıcı Adı:");

        jLabel7.setText("Parola:");

        jLabel8.setText("Parola (Tekrar):");

        btnYKapat.setText("Kapat");
        btnYKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYKapatActionPerformed(evt);
            }
        });

        btnYOlustur.setText("Oluştur");
        btnYOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYOlusturActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtYKullaniciAdi)
                    .addComponent(txtYYeniParola)
                    .addComponent(txtYYeniParolaTekrar)
                    .addComponent(txtYGecerliParola, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnYOlustur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnYKapat)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtYGecerliParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtYKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtYYeniParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtYYeniParolaTekrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYKapat)
                    .addComponent(btnYOlustur))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Yönetici Silme"));

        yTablo.setModel(new javax.swing.table.DefaultTableModel(
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
        yTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yTabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(yTablo);

        jLabel9.setText("Geçerli Parola:");

        btnYoneticiSil.setText("Yönetici Sil");
        btnYoneticiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYoneticiSilActionPerformed(evt);
            }
        });

        btnSKapat.setText("Kapat");
        btnSKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSKapatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtSGecerliParola))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 136, Short.MAX_VALUE)
                        .addComponent(btnYoneticiSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSKapat)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSGecerliParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSKapat)
                            .addComponent(btnYoneticiSil)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblKullanici)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKullanici)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        durum = false;
    }//GEN-LAST:event_formWindowClosed

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        String adminAdi = AnaForm.adminAdi;
        String gecerliParola = txtGecerliParola.getText().trim();
        String yeniParola = txtYeniParola.getText().trim();
        String yeniParolaTekrar = txtYeniParolaTekrar.getText().trim();

        System.out.println(adminAdi);

        if (gecerliParola.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen mevcut parolanızı giriniz.");
            txtGecerliParola.setText("");
            txtGecerliParola.requestFocus();
        } else if (yeniParola.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen yeni parolanızı giriniz.");
            txtYeniParola.setText("");
            txtYeniParola.requestFocus();
        } else if (yeniParolaTekrar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen yeni parolanızı tekrar giriniz.");
            txtYeniParolaTekrar.setText("");
            txtYeniParolaTekrar.requestFocus();
        } else {
            try {
                String kulQuery = "select * from ayarlar where kAdi = '" + adminAdi + "'";
                ResultSet rs = db.baglan().executeQuery(kulQuery);
                if (rs.next()) {
                    if (rs.getString("kParola").equals(gecerliParola)) {
                        if (yeniParolaTekrar.equals(yeniParola)) {
                            db.kapat();
                            String parolaQuery = "UPDATE ayarlar SET kParola = '" + yeniParolaTekrar + "' WHERE kAdi = '" + adminAdi + "' ";
                            int yazSonuc = db.baglan().executeUpdate(parolaQuery);
                            if (yazSonuc > 0) {
                                txtGecerliParola.setText("");
                                txtYeniParola.setText("");
                                txtYeniParolaTekrar.setText("");
                                JOptionPane.showMessageDialog(rootPane, "Parolanız başarı ile güncellendi.");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Parola güncelleme işlemi başarısız oldu!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Yeni parolalar eşleşmiyor!");
                            txtYeniParolaTekrar.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Geçerli parolanız hatalı girildi!");
                        txtGecerliParola.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Geçerli kullanıcı bulunamadı!");
                }
            } catch (Exception e) {
                System.out.println("Giriş hatası: " + e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKapatActionPerformed
        dispose();
    }//GEN-LAST:event_btnKapatActionPerformed

    private void btnYOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYOlusturActionPerformed
        String adminAdi = AnaForm.adminAdi;
        String gecerliYParola = txtYGecerliParola.getText().trim();
        String kullaniciAdi = txtYKullaniciAdi.getText().trim();
        String yeniYParola = txtYYeniParola.getText().trim();
        String yeniYParolaTekrar = txtYYeniParolaTekrar.getText().trim();

        System.out.println(adminAdi);

        if (gecerliYParola.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen mevcut parolanızı giriniz.");
            txtYGecerliParola.setText("");
            txtYGecerliParola.requestFocus();
        } else if (kullaniciAdi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen yeni yönetici için kullanıcı adı giriniz.");
            txtYKullaniciAdi.setText("");
            txtYKullaniciAdi.requestFocus();
        } else if (yeniYParola.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen yeni yönetici için parola giriniz.");
            txtYYeniParola.setText("");
            txtYYeniParola.requestFocus();
        } else if (yeniYParolaTekrar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen yeni yönetici için parolayı tekrar giriniz.");
            txtYYeniParolaTekrar.setText("");
            txtYYeniParolaTekrar.requestFocus();
        } else {
            try {
                String kulQuery = "select * from ayarlar where kAdi = '" + adminAdi + "'";
                ResultSet rs = db.baglan().executeQuery(kulQuery);
                if (rs.next()) {
                    if (rs.getString("kParola").equals(gecerliYParola)) {
                        if (yeniYParolaTekrar.equals(yeniYParola)) {
                            db.kapat();
                            String yeniKullaniciQuery = "insert into ayarlar values(null, '" + kullaniciAdi + "', '" + yeniYParolaTekrar + "')";
                            int yazSonuc = db.baglan().executeUpdate(yeniKullaniciQuery);
                            if (yazSonuc > 0) {
                                txtYGecerliParola.setText("");
                                txtYKullaniciAdi.setText("");
                                txtYYeniParola.setText("");
                                txtYYeniParolaTekrar.setText("");
                                yoneticiVerileri();
                                JOptionPane.showMessageDialog(rootPane, "Yeni yönetici başarı ile oluşturuldu.");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Yönetici oluşturma işlemi başarısız!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Yeni yönetici için belirlenen parolalar eşleşmiyor!");
                            txtYeniParolaTekrar.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Geçerli parolanız hatalı girildi!");
                        txtGecerliParola.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Geçerli kullanıcı bulunamadı!");
                }
            } catch (Exception e) {
                System.out.println("Giriş hatası: " + e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnYOlusturActionPerformed

    private void btnYKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYKapatActionPerformed
        btnKapatActionPerformed(evt);
    }//GEN-LAST:event_btnYKapatActionPerformed

    private void yTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yTabloMouseClicked
        int row = yTablo.getSelectedRow();
        if (row > -1) {
            yoneticiID = "" + yTablo.getValueAt(row, 0);
            System.out.println("yid : " + yoneticiID);
        }
    }//GEN-LAST:event_yTabloMouseClicked

    private void btnSKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSKapatActionPerformed
        btnKapatActionPerformed(evt);
    }//GEN-LAST:event_btnSKapatActionPerformed

    private void btnYoneticiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYoneticiSilActionPerformed
        String adminAdi = AnaForm.adminAdi;
        String gecerliParola = txtSGecerliParola.getText().trim();
        String silYID = yoneticiID;

        System.out.println(adminAdi);

        if (gecerliParola.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen mevcut parolanızı giriniz.");
            txtSGecerliParola.setText("");
            txtSGecerliParola.requestFocus();
        } else {
            try {
                String kulQuery = "select * from ayarlar where kAdi = '" + adminAdi + "'";
                ResultSet rs = db.baglan().executeQuery(kulQuery);
                if (rs.next()) {
                    if (rs.getString("kParola").equals(gecerliParola)) {
                        db.kapat();
                        int cevap = JOptionPane.showConfirmDialog(rootPane, "" + yoneticiID + " No'lu yöneticiyi silmek istediğinize emin misiniz?", "Müşteri Sil", JOptionPane.YES_NO_OPTION);
                        if (cevap == 0) {
                            String parolaQuery = "delete from ayarlar where kID = '" + silYID + "' ";
                            int yazSonuc = db.baglan().executeUpdate(parolaQuery);
                            if (yazSonuc > 0) {
                                txtYGecerliParola.setText("");
                                yoneticiVerileri();
                                JOptionPane.showMessageDialog(rootPane, "Yönetici başarı ile silindi.");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Yönetici silme işlemi başarısız oldu!");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Geçerli parolanız hatalı girildi!");
                        txtGecerliParola.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Geçerli kullanıcı bulunamadı!");
                }
            } catch (Exception e) {
                System.out.println("Giriş hatası: " + e);
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnYoneticiSilActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FormAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAyarlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKapat;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JButton btnSKapat;
    private javax.swing.JButton btnYKapat;
    private javax.swing.JButton btnYOlustur;
    private javax.swing.JButton btnYoneticiSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKullanici;
    private javax.swing.JPasswordField txtGecerliParola;
    private javax.swing.JPasswordField txtSGecerliParola;
    private javax.swing.JPasswordField txtYGecerliParola;
    private javax.swing.JTextField txtYKullaniciAdi;
    private javax.swing.JPasswordField txtYYeniParola;
    private javax.swing.JPasswordField txtYYeniParolaTekrar;
    private javax.swing.JPasswordField txtYeniParola;
    private javax.swing.JPasswordField txtYeniParolaTekrar;
    private javax.swing.JTable yTablo;
    // End of variables declaration//GEN-END:variables

}
