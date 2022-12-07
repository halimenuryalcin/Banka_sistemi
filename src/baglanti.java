import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class baglanti {

	public static <ResaultSet> void main(String[] args ) throws SQLException {
		musterilerManager m=new musterilerManager();
		temsilciManager t=new temsilciManager();
		bankaMuduruManager b=new bankaMuduruManager();
		//b.calisanmaas(12345678900L,10);
		t.taleponay(10043725136L, 33457944290L,"onaylandi",500, 12);
		//m.borcgoruntuleme(33457944290L);
	}
}
