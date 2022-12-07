import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class musterilerManager {
	Connection myCon;
	Statement myStat=null,stat=null;
	ResultSet rs,rs2,ar;
	public ArrayList<islemler> kayital(Long musteriId)
    {
             ArrayList<islemler> output = new ArrayList<islemler>();
        try {
            var query = String.format("Select * from islemler where  kaynakId=%d",musteriId);

            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                islemler employee = new islemler();
                employee.setMusteriId(rs.getLong("kaynakId"));
                employee.setIslem(rs.getString("islem"));
                output.add(employee);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
        }
	
	public accounts borcgoruntuleme1(Long musteriId)
	{
		try {accounts employee = new accounts();
            var query = String.format("Select * from kredi where musteriId=%d",musteriId);
        
            var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            if (rs.next()) {
                
                employee.setBakiye(rs.getInt("aylikborc"));
                employee.setGider(rs.getInt("kalanborc"));
                return employee;
            }
            else {
                System.out.println("borclar durumu goruntulenemiyor.");
              	
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
	}
    
	public void parayatir(int nakit,Long musteriId)throws SQLException
	{	
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from hesap");
			rs.next();			
			int bakiye=rs.getInt("bakiye");
			int gelir=rs.getInt("gelir");
			gelir+=nakit;
			bakiye+=nakit;
			String sorgu=String.format("update hesap set bakiye=%d where musteriId=%d",bakiye,musteriId);
			myStat.executeUpdate(sorgu);
			sorgu=String.format("update hesap set gelir=%d where musteriId=%d",gelir,musteriId);
			myStat.executeUpdate(sorgu);
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void paracek(int cekilecekTutar,Long musteriId)
	{

		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from hesap");
			rs.next();			
			int bakiye=rs.getInt("bakiye");
			int gider=rs.getInt("gider");
			bakiye-=cekilecekTutar;
			gider+=cekilecekTutar;
			String sorgu=String.format("update hesap set bakiye=%d where musteriId=%d",bakiye,musteriId);
			myStat.executeUpdate(sorgu);
			sorgu=String.format("update hesap set gider=%d where musteriId=%d",gider,musteriId);
			myStat.executeUpdate(sorgu);
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public void paratransferi(int id,int id2,int nakit)
	{	int bakiye2;
		int bakiye;
		int gelir;
		int gider;
		String sorgu = null,sorgu2=null;
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			stat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from hesap where id=" +id);
			rs2=stat.executeQuery("select * from hesap where id=" +id2);
			rs.next();
			rs2.next();
			bakiye=rs.getInt("bakiye");
			gider=rs.getInt("gider");
			bakiye2=rs2.getInt("bakiye");
			gelir=rs2.getInt("gelir");
			bakiye-=nakit;
			gider+=nakit;
			gelir+=nakit;
			System.out.println(gelir+" "+gider);
			bakiye2+=nakit;
                        //bakiye den azalmayacak mi
			sorgu=String.format("update hesap set bakiye =%d where id=%d",bakiye,id);
			sorgu2=String.format("update hesap set bakiye =%d where id=%d",bakiye2,id2);
			myStat.executeUpdate(sorgu);
			myStat.executeUpdate(sorgu2);
			sorgu=String.format("update hesap set gider =%d where id=%d",gider,id);
			sorgu2=String.format("update hesap set gelir =%d where id=%d",gelir,id2);
			myStat.executeUpdate(sorgu);
			myStat.executeUpdate(sorgu2);
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public void bilgiguncellemesi(Long musteriId,String adres,String tel,String mail)
	{
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
			rs=myStat.executeQuery("select * from musteri");
			rs.next();
			if(adres!=null)
			{
				String sorgu=String.format("update musteri set adres ='%s' where id=%d",adres,musteriId);
				myStat.executeUpdate(sorgu);
			}
			if(mail!=null)
			{
				String sorgu=String.format("update musteri set mail ='%s' where id=%d",mail,musteriId);
				myStat.executeUpdate(sorgu);
			}
			if(tel!=null)
			{
				String sorgu=String.format("update musteri set tel ='%s' where id=%d",tel,musteriId);
				myStat.executeUpdate(sorgu);
			}
		
			}catch(SQLException e){
			e.printStackTrace();
		}
	}

	//kredi tablosu g�ncellernirse burayi duzenlmeen gerekiyor!
	public void krediOdeme(Long musteriId,int nakit)
	{
		int bakiye2,gider;
		int bakiye,bgelir;
		int borc;
		String sorgu = null,sorgu2=null,sorgu3=null;
		try {
			myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
			myStat=(Statement) myCon.createStatement();
		
			rs=myStat.executeQuery("select * from bankageneldurumu");
			if(rs.next())
			{
				bakiye=rs.getInt("toplambakiye");
				bgelir=rs.getInt("gelir");
				bgelir+=nakit;
				bakiye+=nakit;
				sorgu=String.format("update bankageneldurumu set toplambakiye=%d",bakiye);
				myStat.executeUpdate(sorgu);
				sorgu=String.format("update bankageneldurumu set gelir=%d",bgelir);
				myStat.executeUpdate(sorgu);

				rs=myStat.executeQuery("select * from hesap where musteriId=" +musteriId);
				rs.next();
				bakiye2=rs.getInt("bakiye");
				gider=rs.getInt("gider");
				gider-=nakit;
				bakiye2-=nakit;
				sorgu2=String.format("update hesap set bakiye =%d where musteriId=%d",bakiye2,musteriId);
				myStat.executeUpdate(sorgu2);
				sorgu2=String.format("update hesap set gider =%d where musteriId=%d",gider,musteriId);
				myStat.executeUpdate(sorgu2);
				rs=myStat.executeQuery("select * from kredi where musteriId=" +musteriId);
				rs.next();
				borc=rs.getInt("kalanBorc");
				borc-=nakit;
				sorgu3=String.format("update kredi set kalanBorc = %d where musteriId =%d",borc,musteriId);
				myStat.executeUpdate(sorgu3);
			}
			
			
			myCon.close();
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	public void talep(Long musteriId,Long temsilciId,String talepturu,String parabirim)
	{	
		try {
				myCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
				myStat=(Statement) myCon.createStatement();
				if(talepturu=="kredi alma")
				{
					
					if(parabirim=="TL")
					{
						String sorgu=String.format("insert into talepler(musteriId,temsilciId,talepturu) values(%d,%d,'%s')",musteriId,temsilciId,talepturu);
						myStat.executeUpdate(sorgu);
						System.out.println("talebiniz alinmistir");
					}
					else 
					System.out.println("kredi talebi sadece tl �zerinden yap�labilir.");
						
				}
				else
				{
					String sorgu=String.format("insert into talepler(musteriId,temsilciId,talepturu) values(%d,%d,'%s')",musteriId,temsilciId,talepturu);
					myStat.executeUpdate(sorgu);
					System.out.println("talebiniz alinmistir");
				}
				
				
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<islemler> aylikozet(Long musteriId)
	{
			ArrayList<islemler> actions = kayital(musteriId);			
                        return actions;
        }

	public void borcgoruntuleme(Long musteriId)
	{
		try {
			var connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banka","root","");
            var statement = connection.createStatement();
            System.out.println("tum borcu odemek ister misiniz:");
            Scanner scan=new Scanner(System.in);
            String cevap=scan.nextLine();
            var data=borcgoruntuleme1(musteriId);
            if(cevap.equals("evet"))
            {	
            	String getAccountQuery = String.format("select * from hesap where musteriId =%d",musteriId);
            	rs=statement.executeQuery(getAccountQuery);
            	
            	if(rs.next())
            	{int id=rs.getInt("id");
            	int bakiye=rs.getInt("bakiye");
            	int gider=rs.getInt("gider");
            	System.out.println(bakiye);
            	if(bakiye>data.gider)
            	{
            		bakiye-=data.gider;
            	gider+=data.gider;
            	String sorgu=String.format("update hesap set bakiye=%d,gider=%d where id=%d",bakiye,gider,id);
      
            	statement.executeUpdate(sorgu);
            	rs=statement.executeQuery("select * from bankageneldurumu ");
            	rs.next();
            	int bbakiye=rs.getInt("toplambakiye");
            	int gelir=rs.getInt("gelir");
            	bbakiye+=data.gider;
            	gelir+=data.gider;
            	sorgu=String.format("update bankageneldurumu set toplambakiye =%d,gelir=%d ",bakiye,gider);
            	statement.executeUpdate(sorgu);
            	}
            	
            	}
            	
            	
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
       
	}
	
	

}