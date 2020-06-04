package netflix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Baglanti {

	private static Connection baglanti;

	private static void baglan() throws ClassNotFoundException, SQLException {
		String dbName = "prolabnetflix";
		String db = "jdbc:mysql://localhost/" + dbName
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\r\n";
		Class.forName("com.mysql.cj.jdbc.Driver");
		baglanti = DriverManager.getConnection(db, "root", "");
	};

	public static boolean ekleCikar(String io) {
		try {
			baglan();
			return !baglanti.createStatement().execute(io); // normalde false dönüyor oyuzden tersini (true)
															// döndürüyorum.
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean kontrol(String sorgu) {
		try {
			baglan();
			return baglanti.createStatement().executeQuery(sorgu).next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String[][] sorgula(String sorgu) {
		String donen[][] = new String[2][2];
		try {
			baglan();
			ResultSet rs = baglanti.createStatement().executeQuery(sorgu);
			int i = 0;
			while (rs.next()) {
				donen[i][0] = rs.getString(1).toString();
				donen[i][1] = rs.getString(2).toString();
				i++;
			}
		} catch (Exception e) {
			System.err.println("Hata 1! ");
			System.err.println(e.getMessage());
		}
		return donen;
	}
	
	public static String sorgula2(String sorgu) {
		String donen="";
		try {
			baglan();
			ResultSet rs = baglanti.createStatement().executeQuery(sorgu);
			while (rs.next()) {
				 donen += rs.getString(1).toString()+"\n";
			}
		} catch (Exception e) {
			System.err.println("Hata 1! ");
			System.err.println(e.getMessage());
		}
		return donen;
	}
}
