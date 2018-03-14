package uygulama;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusteriDB {

    DB db = new DB();

    public ArrayList<Musteri> veriGetir() {
        String musteriQuery = "select * from musteriler ";
        ArrayList<Musteri> musteriListesi = new ArrayList<>();
        try {
            ResultSet rs = db.baglan().executeQuery(musteriQuery);
            while (rs.next()) {
                Musteri m = new Musteri();
                m.setID(rs.getString("" + MusteriEnum.mID));
                m.setAdi(rs.getString("" + MusteriEnum.mAdi));
                m.setSoyadi(rs.getString("" + MusteriEnum.mSoyadi));
                m.setTel(rs.getString("" + MusteriEnum.mTelefon));
                m.setAdres(rs.getString("" + MusteriEnum.mAdres));

                musteriListesi.add(m);

            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
            System.out.println("veriGetir");
        } finally {
            db.kapat();
        }
        return musteriListesi;
    }

    public boolean kaydet(Object o) {
        Musteri musteri = (Musteri) o;
        String musteriQuery = "insert into " + MusteriEnum.musteriler + " values (null, '" + musteri.getAdi() + "', '" + musteri.getSoyadi() + "', '" + musteri.getTel() + "', '" + musteri.getAdres() + "' )";
        try {
            int sonuc = db.baglan().executeUpdate(musteriQuery);
            if (sonuc > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Kaydetme hatası: " + ex);
        } finally {
            db.kapat();
        }
        return false;
    }

    public boolean sil(String str) {
        String musteriQuery = "delete from " + MusteriEnum.musteriler + str;
        try {
            int result = db.baglan().executeUpdate(musteriQuery);
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Silme hatası: " + ex);
        } finally {
            db.kapat();
        }
        return false;
    }

    public boolean guncelle(Object o, String id) {
        Musteri musteri = (Musteri) o;
        String musteriQuery = "UPDATE " + MusteriEnum.musteriler + " set " + MusteriEnum.mAdi + " = '" + musteri.getAdi() + "'," + MusteriEnum.mSoyadi + " = '" + musteri.getSoyadi() + "', " + MusteriEnum.mTelefon + " = '" + musteri.getTel() + "', " + MusteriEnum.mAdres + " = '" + musteri.getAdres() + "' where " + MusteriEnum.mID + " = '" + id + "' ";

        try {
            int result = db.baglan().executeUpdate(musteriQuery);
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Güncelleme hatası: " + ex);
        } finally {
            db.kapat();
        }
        return false;
    }

}
