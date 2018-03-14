package uygulama;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SiparisDB {

    DB db = new DB();

    public ArrayList<Siparis> veriGetir() {
        String siparisQuery = "select * from siparisler order by sID desc";
        ArrayList<Siparis> siparisListesi = new ArrayList<>();
        try {
            ResultSet rs = db.baglan().executeQuery(siparisQuery);
            while (rs.next()) {
                Siparis s = new Siparis();
                s.setID(rs.getString("" + SiparisEnum.sID));
                s.setMAdi(rs.getString("" + SiparisEnum.sMAdi));
                s.setMSoyadi(rs.getString("" + SiparisEnum.sMSoyadi));
                s.setMAdres(rs.getString("" + SiparisEnum.sMAdres));
                s.setDurum(rs.getString("" + SiparisEnum.sDurum));
                s.setTutar(rs.getString("" + SiparisEnum.sTutar));
                s.setTarih(rs.getString("" + SiparisEnum.sTarih));

                siparisListesi.add(s);

            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
            System.out.println("veriGetir");
        } finally {
            db.kapat();
        }
        return siparisListesi;
    }

    public boolean kaydet(Object o) {
        Siparis siparis = (Siparis) o;
        String siparisQuery = "insert into " + SiparisEnum.siparisler + " values (null, '" + siparis.getDurum() + "', '" + siparis.getTutar() + "', '" + siparis.getTarih() + "' )";
        try {
            int sonuc = db.baglan().executeUpdate(siparisQuery);
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
        String siparisQuery = "delete from " + SiparisEnum.siparisler + str;
        try {
            int result = db.baglan().executeUpdate(siparisQuery);
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
        Siparis siparis = (Siparis) o;
        String siparisQuery = "UPDATE " + SiparisEnum.siparisler + " set " + SiparisEnum.sDurum + " = '" + siparis.getDurum() + "'," + SiparisEnum.sTutar + " = '" + siparis.getTutar() + "', " + SiparisEnum.sTarih + " = '" + siparis.getTarih() + "' where " + SiparisEnum.sID + " = '" + id + "' ";

        try {
            int result = db.baglan().executeUpdate(siparisQuery);
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
