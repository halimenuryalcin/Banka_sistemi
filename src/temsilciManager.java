import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;
import java.util.ArrayList;

public class temsilciManager {
	Connection myCon=null;
	Statement myStat=null;
	ResultSet rs=null;
	
	
	public calisanlar GetEmployeeByCustomerAndRepresentativeId(Long customerId, Long representativeId) {
        try {
            var query = String.format("Select * from calisanlar where calisanId=%d and musteriId=%d", representativeId,customerId);
        
            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            
            var resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                calisanlar employee = new calisanlar();
                employee.setMusteriId(resultSet.getLong("musteriId"));
                employee.setId(resultSet.getInt("id"));
                employee.setCalisanId(resultSet.getLong("calisanId"));
                return employee;
            }
            else {
                System.out.println("�al��anlarda b�yle bir kay�t mevcut de�il.");
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
    }
	

	public ArrayList<accounts> musteribilgigoruntule(Long musteriId,Long calisanId)
	{            
            ArrayList<accounts> output = new ArrayList<accounts>();
		 try {
	            var query = String.format("Select * from musteri where id in (select musteriId from calisanlar where calisanId=%d)"+calisanId);
	        
	            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
	            var statement = connection.createStatement();
	            
	            var resultSet = statement.executeQuery(query);
	            
	            while (resultSet.next()) {
	                accounts account = new accounts();
	                account.setKardurumu(resultSet.getInt("id"));
	                account.setBakiye(resultSet.getInt("bakiye"));
	                account.setGelir(resultSet.getInt("gelir"));
	                account.setGider(resultSet.getInt("gider"));
	                output.add(account);   
	            }
                   
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	       return output;
	}
	
	public ArrayList<islemler> talepgoruntuleme(Long temsilciId)
	{
            ArrayList<islemler> output = new ArrayList<islemler>();
		try {
            var query = String.format("Select * from talepler where temsilciId=%d",temsilciId);
        
            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            
            var resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                islemler account = new islemler();
                account.setIslem(resultSet.getString("talepturu"));
                account.setMusteriId(resultSet.getLong("musteriId"));
                output.add(account);
            }
            return output;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
	}

	public void musteriekle(String isim,String soyisim,String adres,String mail,String tel,Long musteriId)
	{	Scanner yeniKayit=new Scanner(System.in);
		System.out.println("bilgiler");
	
		System.out.println("kayit yapiliyor");
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
	
	public void musterisil(Long musteriId,Long temsilciId)
	{
		 
		        try {
		            var data = GetEmployeeByCustomerAndRepresentativeId(musteriId, temsilciId);
		            if (data!=null) {
		            	var query = String.format("delete from calisanlar where musteriId=%d", data.musteriId);

		                
		                var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
		                var statement = connection.createStatement();
		                var resultSet = statement.executeUpdate(query);
		                 query = String.format("delete from musteri where id=%d", data.musteriId);

		                resultSet=statement.executeUpdate(query);
		                if (resultSet==1) {
		                    System.out.println("M��teri ba�ar�yla silindi");
		                    
		                }
		                else {
		                    System.out.println("M��teri silinemedi");
		                }
		            }
		            
		        } catch (Exception e) {
					e.printStackTrace();
		        }
		        
		    
	}

	public void musteriguncelle(Long musteriId,Long temsilciId,String mail,String adres,String tel)
	{
		 try {
	            var data = GetEmployeeByCustomerAndRepresentativeId(musteriId, temsilciId); 
	            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
	            var statement = connection.createStatement();
	            if (data!=null) {
	            	if(adres!=null)
	    			{
	    				String sorgu=String.format("update musteri set adres ='%s' where id=%d",adres,musteriId);
	    				statement.executeUpdate(sorgu);
	    			}
	    			if(mail!=null)
	    			{
	    				String sorgu=String.format("update musteri set mail ='%s' where id=%d",mail,musteriId);
	    				statement.executeUpdate(sorgu);
	    			}
	    			if(tel!=null)
	    			{
	    				String sorgu=String.format("update musteri set tel ='%s' where id=%d",tel,musteriId);
	    				statement.executeUpdate(sorgu);
	    			}
	    		
	         
	   
	            }
	            
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	        
	    
	}
	
	public void yenihesapac(int nakit,Long musteriId,Long temsilciId) throws SQLException
	{
		try {
			 var data = GetEmployeeByCustomerAndRepresentativeId(musteriId, temsilciId);
	         if (data!=null) {
	            
	                 myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select *from hesap");
			rs.next();
			int id = 0;
			while(rs.next())
			{
				id=rs.getInt("id");
			}
			id++;
			String sorgu=String.format("insert into hesap(id,musteribankId,bakiye) values (%d, %d, %d)",id,musteriId,nakit);
			myStat.executeUpdate(sorgu);
	             }
			
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	
	}
	
	public void hesapsil(Long musteriId,Long temsilciId)
	{
		 try {
	            var data = GetEmployeeByCustomerAndRepresentativeId(musteriId, temsilciId);
	            if (data!=null) {
	               
	            	myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
	    			myStat=(Statement) myCon.createStatement();
	    			var rs=myStat.executeQuery("select *from hesap");
	    			rs.next();
	    			int bakiye=rs.getInt("bakiye");
	    			String sorgu=null;
	    			while(rs.next())
	    			{
	    				sorgu="delete from hesap where bakiye=0";
	    			}
	    			myStat.executeUpdate(sorgu);
	               
	            }
	            else
	            	System.out.println("temsilci musteri uyumsuzlu�u");
	            
	        } catch (Exception e) {
				e.printStackTrace();
	        }
		 
	}
	
	public void taleponay(Long musteriId,Long temsilciId,String cevap,int nakit,int vade)
	{	String talep;
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from talepler");
			rs.next();
			talep=rs.getString("talepturu");
			String sorgu=String.format("update talepler set onaydurumu='%s'",cevap);
			myStat.executeUpdate(sorgu);
			if(talep=="hesapac" && cevap=="onayland�")
			{	
				yenihesapac(nakit,musteriId,temsilciId);
			}
			else if(talep=="hesapsil" && cevap=="onayland�")
			{
				hesapsil(musteriId,temsilciId);
			}
			else if(talep=="kredi" && cevap=="onayland�")
			{
				rs=myStat.executeQuery("select * from kredi");
				int anapara=rs.getInt("anapara");
				int faiz=rs.getInt("faiz");
				int borc=(anapara+faiz)/vade;
				sorgu=String.format("update kredi set aylikborc=%d",borc);
				myStat.executeUpdate(sorgu);
				

			}
			
			}catch(SQLException e){
			e.printStackTrace();
			}
	}
	
	
}
