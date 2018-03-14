package uygulama;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AnaForm extends javax.swing.JFrame {

    FormAyarlar fa = null;
    FormMusteriDuzenle fmd = null;
    FormMusteriEkle fme = null;
    FormSiparisEkle fse = null;

    String musteriID = "";
    String siparisID = "";

    static String adminAdi = "";

    DB db = new DB();

    public AnaForm() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/yildiz.png")).getImage());
        musteriVerileri();
        siparisVerileri();
    }

    static void musteriVerileri() {
        ArrayList<Musteri> mListesi = new ArrayList<>();
        DefaultTableModel dtmm = new DefaultTableModel();
        mListesi = new MusteriDB().veriGetir();

        dtmm = new DefaultTableModel();
        dtmm.addColumn("No");
        dtmm.addColumn("Adı");
        dtmm.addColumn("Soyadı");
        dtmm.addColumn("Telefon");
        dtmm.addColumn("Adres");

        for (Musteri musteri : mListesi) {
            dtmm.addRow(new String[]{musteri.getID(), musteri.getAdi(), musteri.getSoyadi(), musteri.getTel(), musteri.getAdres()});
        }
        mTablo.setModel(dtmm);
    }

    static void siparisVerileri() {
        ArrayList<Siparis> sListesi = new ArrayList<>();
        DefaultTableModel dtms = new DefaultTableModel();
        sListesi = new SiparisDB().veriGetir();

        dtms = new DefaultTableModel();
        dtms.addColumn("No");
        dtms.addColumn("Adı");
        dtms.addColumn("Soyadı");
        dtms.addColumn("Adres");
        dtms.addColumn("Durum");
        dtms.addColumn("Tutar");
        dtms.addColumn("Tarih");

        for (Siparis siparis : sListesi) {
            dtms.addRow(new String[]{siparis.getID(), siparis.getMAdi(), siparis.getMSoyadi(), siparis.getMAdres(), siparis.getDurum(), siparis.getTutar(), siparis.getTarih()});
        }
        sTablo.setModel(dtms);
    }

    public void aramaVerileri(String aramaQuery) {
        try {
            ResultSet rs = db.baglan().executeQuery(aramaQuery);
            DefaultTableModel dtma = new DefaultTableModel();
            dtma.addColumn("No");
            dtma.addColumn("Adı");
            dtma.addColumn("Soyadı");
            dtma.addColumn("Telefon");
            dtma.addColumn("Adres");

            while (rs.next()) {
                dtma.addRow(new String[]{rs.getString("mID"), rs.getString("mAdi"), rs.getString("mSoyadi"), rs.getString("mTelefon"), rs.getString("mAdres")});
            }
            mTablo.setModel(dtma);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }
    }

    public void gununVerileri(String gunlukQuery) {
        try {
            ResultSet rs = db.baglan().executeQuery(gunlukQuery);
            DefaultTableModel dtmg = new DefaultTableModel();

            dtmg = new DefaultTableModel();
            dtmg.addColumn("No");
            dtmg.addColumn("Adı");
            dtmg.addColumn("Soyadı");
            dtmg.addColumn("Adres");
            dtmg.addColumn("Durum");
            dtmg.addColumn("Tutar");
            dtmg.addColumn("Tarih");

            while (rs.next()) {
                dtmg.addRow(new String[]{rs.getString("sID"), rs.getString("sMAdi"), rs.getString("sMSoyadi"), rs.getString("sMAdres"), rs.getString("sDurum"), rs.getString("sTutar"), rs.getString("sTarih")});
            }
            sTablo.setModel(dtmg);
        } catch (Exception e) {
            System.err.println("Data getirme hatası : " + e);
        } finally {
            db.kapat();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mTablo = new javax.swing.JTable();
        btnMusteriEkle = new javax.swing.JButton();
        btnMusteriSil = new javax.swing.JButton();
        btnMusteriDuzenle = new javax.swing.JButton();
        txtArama = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        cboxArama = new javax.swing.JComboBox<>();
        btnAyarlar = new javax.swing.JButton();
        sPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sTablo = new javax.swing.JTable();
        btnSiparisOlustur = new javax.swing.JButton();
        btnSiparisIptali = new javax.swing.JButton();
        btnYolaCikti = new javax.swing.JButton();
        btnTeslimEdildi = new javax.swing.JButton();
        btnGununSiparisleri = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Su Satış Otomasyonu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Müşteriler"));

        mTablo.setModel(new javax.swing.table.DefaultTableModel(
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
        mTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mTabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mTablo);

        btnMusteriEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musteri_ekle.png"))); // NOI18N
        btnMusteriEkle.setToolTipText("Müşteri Ekle");
        btnMusteriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriEkleActionPerformed(evt);
            }
        });

        btnMusteriSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musteri_sil.png"))); // NOI18N
        btnMusteriSil.setToolTipText("Müşteri Sil");
        btnMusteriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriSilActionPerformed(evt);
            }
        });

        btnMusteriDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musteri_duzenle.png"))); // NOI18N
        btnMusteriDuzenle.setToolTipText("Müşteri Düzenle");
        btnMusteriDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriDuzenleActionPerformed(evt);
            }
        });

        txtArama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAramaKeyPressed(evt);
            }
        });

        btnAra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/musteri_arama.png"))); // NOI18N
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        cboxArama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Müşteri No", "Müşteri Adı", "Müşteri Soyadı", "Müşteri Telefon", "Müşteri Adres" }));

        btnAyarlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ayarlar.png"))); // NOI18N
        btnAyarlar.setToolTipText("Yönetici Ayarları");
        btnAyarlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyarlarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mPanelLayout = new javax.swing.GroupLayout(mPanel);
        mPanel.setLayout(mPanelLayout);
        mPanelLayout.setHorizontalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mPanelLayout.createSequentialGroup()
                        .addComponent(txtArama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxArama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAra))
                    .addGroup(mPanelLayout.createSequentialGroup()
                        .addComponent(btnMusteriEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnMusteriDuzenle)
                        .addGap(18, 18, 18)
                        .addComponent(btnMusteriSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAyarlar)))
                .addContainerGap())
        );
        mPanelLayout.setVerticalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMusteriSil)
                    .addComponent(btnMusteriDuzenle)
                    .addComponent(btnMusteriEkle)
                    .addComponent(btnAyarlar))
                .addGap(18, 18, 18)
                .addGroup(mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxArama)
                    .addComponent(btnAra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        sPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Siparişler"));

        sTablo.setModel(new javax.swing.table.DefaultTableModel(
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
        sTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sTabloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sTablo);

        btnSiparisOlustur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siparis_ekle.png"))); // NOI18N
        btnSiparisOlustur.setToolTipText("Sipariş Ekle");
        btnSiparisOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiparisOlusturActionPerformed(evt);
            }
        });

        btnSiparisIptali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siparis_iptali.png"))); // NOI18N
        btnSiparisIptali.setToolTipText("Sipariş İptali");
        btnSiparisIptali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiparisIptaliActionPerformed(evt);
            }
        });

        btnYolaCikti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siparis_yolda.png"))); // NOI18N
        btnYolaCikti.setToolTipText("Yola Çıktı");
        btnYolaCikti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYolaCiktiActionPerformed(evt);
            }
        });

        btnTeslimEdildi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siparis_teslim_edildi.png"))); // NOI18N
        btnTeslimEdildi.setToolTipText("Teslim Edildi");
        btnTeslimEdildi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeslimEdildiActionPerformed(evt);
            }
        });

        btnGununSiparisleri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siparis_bugun.png"))); // NOI18N
        btnGununSiparisleri.setToolTipText("Bugünün Siparişleri");
        btnGununSiparisleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGununSiparisleriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sPanelLayout = new javax.swing.GroupLayout(sPanel);
        sPanel.setLayout(sPanelLayout);
        sPanelLayout.setHorizontalGroup(
            sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(sPanelLayout.createSequentialGroup()
                        .addComponent(btnSiparisOlustur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnYolaCikti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTeslimEdildi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGununSiparisleri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiparisIptali)))
                .addContainerGap())
        );
        sPanelLayout.setVerticalGroup(
            sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSiparisIptali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnYolaCikti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTeslimEdildi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSiparisOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGununSiparisleri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiparisOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiparisOlusturActionPerformed

        if (musteriID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen bir müşteri seçiniz!");
        } else {
            if (!fse.durum) {
                fse = new FormSiparisEkle();
                try {
                    String musteriQuery = "select mAdi, mSoyadi, mAdres from musteriler where mID = " + musteriID;
                    ResultSet rs = db.baglan().executeQuery(musteriQuery);
                    fse.txtAdi.setText(rs.getString("mAdi"));
                    fse.txtSoyadi.setText(rs.getString("mSoyadi"));
                    fse.txtAdres.setText(rs.getString("mAdres"));
                } catch (Exception e) {
                    System.err.println("Sipariş ekleme hatası: " + e);
                } finally {
                    db.kapat();
                }
                fse.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnSiparisOlusturActionPerformed

    private void btnSiparisIptaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiparisIptaliActionPerformed
        if (siparisID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen sipariş seçimi yapınız!");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "" + siparisID + " No'lu siparişi silmek istediğinize emin misiniz?", "Sipariş İptali", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "delete from siparisler where sID = '" + siparisID + "' ";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        siparisVerileri();
                        JOptionPane.showMessageDialog(rootPane, "Sipariş silme işlemi başarılı!");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Sipariş silme hatası!");
                    }
                } catch (Exception e) {
                    System.err.println("Sipariş silme hatası : " + e);
                } finally {
                    db.kapat();
                }
            }
        }
    }//GEN-LAST:event_btnSiparisIptaliActionPerformed

    private void sTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sTabloMouseClicked
        int row = sTablo.getSelectedRow();
        if (row > -1) {
            siparisID = "" + sTablo.getValueAt(row, 0);
            System.out.println("sid : " + siparisID);
        }
    }//GEN-LAST:event_sTabloMouseClicked

    private void btnYolaCiktiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYolaCiktiActionPerformed
        if (siparisID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen bir sipariş seçiniz!");
        } else {
            try {
                String yazQuery = "UPDATE siparisler SET sDurum = 'Yola Çıktı' WHERE sID = '" + siparisID + "' ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    siparisVerileri();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sipariş güncelleme işlemi başarısız oldu!");
                }
            } catch (SQLException ex) {
                System.out.println("Veritabanı hatası: " + ex);
            }
        }
    }//GEN-LAST:event_btnYolaCiktiActionPerformed

    private void btnTeslimEdildiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeslimEdildiActionPerformed
        if (siparisID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen bir sipariş seçiniz!");
        } else {
            try {
                String yazQuery = "UPDATE siparisler SET sDurum = 'Teslim Edildi' WHERE sID = '" + siparisID + "' ";
                int yazSonuc = db.baglan().executeUpdate(yazQuery);
                if (yazSonuc > 0) {
                    siparisVerileri();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sipariş güncelleme işlemi başarısız oldu!");
                }
            } catch (SQLException ex) {
                System.out.println("Veritabanı hatası: " + ex);
            }
        }
    }//GEN-LAST:event_btnTeslimEdildiActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed

        String arama = "%" + txtArama.getText() + "%";

        switch (cboxArama.getSelectedIndex()) {
            case 0: {
                String aramaQuery = "select * from musteriler where mID like '" + arama + "' ";
                aramaVerileri(aramaQuery);
                break;
            }
            case 1: {
                String aramaQuery = "select * from musteriler where mAdi like '" + arama + "' ";
                aramaVerileri(aramaQuery);
                break;
            }
            case 2: {
                String aramaQuery = "select * from musteriler where mSoyadi like '" + arama + "' ";
                aramaVerileri(aramaQuery);
                break;
            }
            case 3: {
                String aramaQuery = "select * from musteriler where mTelefon like '" + arama + "' ";
                aramaVerileri(aramaQuery);
                break;
            }
            default: {
                String aramaQuery = "select * from musteriler where mAdres like '" + arama + "' ";
                aramaVerileri(aramaQuery);
                break;
            }
        }
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnMusteriDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriDuzenleActionPerformed
        if (musteriID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen bir müşteri seçiniz!");
        } else {
            if (!fmd.durum) {
                fmd = new FormMusteriDuzenle();
                fmd.mid = musteriID;
                try {
                    String musteriQuery = "select mAdi, mSoyadi, mTelefon, mAdres from musteriler where mID = " + musteriID;
                    ResultSet rs = db.baglan().executeQuery(musteriQuery);
                    fmd.txtAdi.setText(rs.getString("mAdi"));
                    fmd.txtSoyadi.setText(rs.getString("mSoyadi"));
                    fmd.txtTelefon.setText(rs.getString("mTelefon"));
                    fmd.txtAdres.setText(rs.getString("mAdres"));
                } catch (Exception e) {
                    System.err.println("Müşteri güncelleme hatası: " + e);
                } finally {
                    db.kapat();
                }
                fmd.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnMusteriDuzenleActionPerformed

    private void btnMusteriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriSilActionPerformed
        if (musteriID.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen seçim yapınız");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "" + musteriID + " No'lu müşteriyi silmek istediğinize emin misiniz?", "Müşteri Sil", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "delete from musteriler where mID = '" + musteriID + "' ";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        musteriVerileri();
                        JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme hatası !");
                    }
                } catch (Exception e) {
                    System.err.println("Silme hatası : " + e);
                } finally {
                    db.kapat();
                }
            }
        }
    }//GEN-LAST:event_btnMusteriSilActionPerformed

    private void btnMusteriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriEkleActionPerformed
        if (!fme.durum) {
            fme = new FormMusteriEkle();
            fme.setVisible(true);
        }
    }//GEN-LAST:event_btnMusteriEkleActionPerformed

    private void mTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mTabloMouseClicked
        int row = mTablo.getSelectedRow();
        if (row > -1) {
            musteriID = "" + mTablo.getValueAt(row, 0);
            System.out.println("mid : " + musteriID);
        }
    }//GEN-LAST:event_mTabloMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int cevap = JOptionPane.showConfirmDialog(rootPane, "Çıkış yapmak istediğinize emin misiniz?", "Çıkış", JOptionPane.YES_NO_OPTION);
        if (cevap == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnGununSiparisleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGununSiparisleriActionPerformed
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");

        if (btnGununSiparisleri.isSelected()) {
            String gunlukQuery = "select * from siparisler where sTarih = '" + dateFormat.format(date) + "' ";
            gununVerileri(gunlukQuery);
        } else {
            siparisVerileri();
        }
    }//GEN-LAST:event_btnGununSiparisleriActionPerformed

    private void txtAramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAraActionPerformed(null);
        }
    }//GEN-LAST:event_txtAramaKeyPressed

    private void btnAyarlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyarlarActionPerformed
        if (!fa.durum) {
            fa = new FormAyarlar();
            fa.setVisible(true);
        }
    }//GEN-LAST:event_btnAyarlarActionPerformed

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
            java.util.logging.Logger.getLogger(AnaForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnAyarlar;
    private javax.swing.JToggleButton btnGununSiparisleri;
    private javax.swing.JButton btnMusteriDuzenle;
    private javax.swing.JButton btnMusteriEkle;
    private javax.swing.JButton btnMusteriSil;
    private javax.swing.JButton btnSiparisIptali;
    private javax.swing.JButton btnSiparisOlustur;
    private javax.swing.JButton btnTeslimEdildi;
    private javax.swing.JButton btnYolaCikti;
    private javax.swing.JComboBox<String> cboxArama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mPanel;
    private static javax.swing.JTable mTablo;
    private javax.swing.JPanel sPanel;
    private static javax.swing.JTable sTablo;
    private javax.swing.JTextField txtArama;
    // End of variables declaration//GEN-END:variables
}
