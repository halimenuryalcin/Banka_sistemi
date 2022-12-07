import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class bankaMuduruManager {
	Connection myCon=null;
	Statement myStat=null;
	ResultSet rs=null;
	public calisanlar temsilcimi(Long tc)
	{
		 try {
	            var query = String.format("Select * from temsilci where id=%d",tc);
	        
	            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
	            var statement = connection.createStatement();
	            
	            var resultSet = statement.executeQuery(query);
	            
	            if (resultSet.next()) {
	                calisanlar account = new calisanlar();
	                account.setCalisanId(rs.getLong("id"));
	                account.setId(rs.getInt("index"));
	                return account;
	            }
	            else {
	                System.out.println("bankanın verilerine su an ulasilamiyor.");
	            }
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	        return null;
	}
	
	public accounts bankageneldurumgoruntuleme(Long mudurId)
	{
		 try {
	            var query = String.format("Select * from bankageneldurumu where mudurId=%d",mudurId);
	        
	            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
	            var statement = connection.createStatement();
	            
	            var resultSet = statement.executeQuery(query);
	            
	            if (resultSet.next()) {
	                accounts account = new accounts();
	                account.setBakiye(resultSet.getInt("toplambakiye"));
	                account.setGelir(resultSet.getInt("gelir"));
	                account.setGider(resultSet.getInt("gider"));
	                account.setKardurumu(resultSet.getInt("kar"));
	                return account;
	            }
	            else {
	                System.out.println("bankanın verilerine su an ulasilamiyor.");
	            }
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	        return null;
	}
	
	public ArrayList<kayit> kayitgoster(int islem)
    {
            ArrayList<kayit> kayitlar = new ArrayList<kayit>();
        try {
            myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            myStat=(Statement) myCon.createStatement();
            rs=myStat.executeQuery("select * from islemler");
            rs.next();
            int id=rs.getInt("id");
            while(id<=islem)
            {
                while(rs.next()) {
                    kayit account = new kayit();
                    //account.setId();
                    account.setKaynakId(rs.getLong("kaynakId"));
                    account.setHedefId(rs.getLong("hedefId"));
                    account.setIslem(rs.getString("islem"));
                    account.setTutar(rs.getInt("tutar"));
                    account.setKbakiye(rs.getInt("kaynakbakiye"));
                    account.setHbakiye(rs.getInt("hedefbakiye"));
                    account.setTarih(rs.getTime("tarih"));
                    kayitlar.add(account);

                }
                id++;
            }
            }catch(SQLException e){
            e.printStackTrace();
        }
        return kayitlar;
    }
	
	public calisanlar mudurbilgisi( Long mudurId) {
        try {
            var query = String.format("Select * from bankageneldurumu where mudurId=%d", mudurId);
        
            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            
            var resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                calisanlar employee = new calisanlar();
                employee.setCalisanId(resultSet.getLong("mudurId"));
                return employee;
            }
           
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
    }
	
	public void calisanmaas(Long mudurId,int maas)
	{
		try {
			var data=mudurbilgisi(mudurId);
			if(data!=null)
			{	var query = String.format("update temsilci set maas=%d ",maas);
				myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
				myStat=(Statement) myCon.createStatement();
				rs=myStat.executeQuery("select mudurId from bankageneldurumu");
				myStat.executeUpdate(query);
			}
			else
				System.out.println("kisi bu yetkiye sahip değil");
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void faizayarlama(Long mudurId,int kredifaiz,int gecikmefaiz)
	{	
		try {
			var data=mudurbilgisi(mudurId);
			if(data!=null)
			{	var query = String.format("update kredi set faiz=%d,gecikmeFaizOrani=%d",kredifaiz,gecikmefaiz);
				myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
				myStat=(Statement) myCon.createStatement();
				rs=myStat.executeQuery("select * from kredi");
			
				if(rs!=null)
				{	System.out.println(rs);
					myStat.executeUpdate(query);
					System.out.println("girdi");
				}
				
				
				else
				{
					query=String.format("insert imto kredi(faiz,gecikmeFaizOrani) values(%d,%d)",kredifaiz,gecikmefaiz);
				}
			}
			else
				System.out.println("kisi bu yetkiye sahip değil");
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public void musteriekle(Long musteriId,String isim,String soyisim,String adres,String mail,String tel)
	{
		
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from musteri");		
			String sorgu=String.format("insert into musteri values(%d,'%s','%s','%s','%s','%s')",musteriId,isim,soyisim,adres,mail,tel);
			myStat.executeUpdate(sorgu);
				
			}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void islemgoruntuleme(Long mudurId,int islemsayisi)
	{
		var data=bankageneldurumgoruntuleme(mudurId);
		if(data!=null)
		{
			
				kayitgoster(islemsayisi);
			
		}
	}

	public void sistemi1ayilerial() throws SQLException
    {    int calisansayi = 0,id=0;
    	Long tc;
        Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
        Statement myStat=(Statement) myCon.createStatement();
        ResultSet rs=myStat.executeQuery("select * from temsilci"); 
        while(rs.next())
        {
            calisansayi=rs.getInt("index");

        }
        int maas=rs.getInt("maas");
         rs= myStat.executeQuery("select * from bankaningeneldurumu"); 
         rs.next();
         int toplambakiye=rs.getInt("toplambakiye");
         toplambakiye-=maas*calisansayi;
         int gider=rs.getInt("gider");
         gider+=maas*calisansayi;
         String sorgu=String.format("update bankaningeneldurumu set toplambakiye=%d, gider=%d",toplambakiye,gider);
         myStat.executeUpdate(sorgu);
  

    }
}
