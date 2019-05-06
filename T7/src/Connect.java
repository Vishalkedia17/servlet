import java.sql.*;
import java.util.*;
	
public class Connect {
		public Connection con;
		public PreparedStatement ps;
		public ResultSet rs;
		Scanner sc=new Scanner(System.in);
		Connect()
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","t55","p55");
				System.out.println("Connected");
				} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Question getQuestion(int i)
		{
			String s=null;
			Question ob=new Question();
			try 
			{
				String sql="select * from DATA where SNO="+i+"";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					ob.setSno(rs.getInt(1));
					ob.setQues(rs.getString(2));
					ob.setOp1(rs.getString(3));
					ob.setOp2(rs.getString(4));
					ob.setOp3(rs.getString(5));
					ob.setOp4(rs.getString(6));
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ob;

		}
		public int getCount()
		{
			int c=0;
			try {
				String sql="select count(*) from DATA";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					c=rs.getInt(1);
				}
			}catch(Exception e) {e.printStackTrace();}
			return c;
		}
		public int getCountAns(String name)
		{
			int c=0;
			try {
				String sql="select count(CA) from ANSWER where USERNAME='"+name+"'";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					c=rs.getInt(1);
				}
			}catch(Exception e) {e.printStackTrace();}
			return c;
		}
		public void setSno(int tmp,String uname)
		{
			for(int i=1;i<=tmp;i++)
			{
				try {
					String sql="insert into ANSWER(SNO,CA,USERNAME)values(?,?,?)";
					
					ps=con.prepareStatement(sql);
					ps.setInt(1,i);
					ps.setString(2,null);
					ps.setString(3,uname);
					ps.executeUpdate();
				}catch(Exception e) {e.printStackTrace();}
			}
		}
		public String getANS(int sno,String name)
		{
			String ans=null;
			try {
				
				String sql="select CA from ANSWER where SNO="+sno+" and USERNAME='"+name+"'";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					ans=rs.getString(1);
				}

			}catch(Exception e) {e.printStackTrace();}
			return ans;
		}
		public int update(int sno,String ans)
		{
			try {
				String sql="update ANSWER set CA=?where SNO=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,ans);
				ps.setInt(2,sno);
				int y = ps.executeUpdate();
				if(y!=1)
				{
					sno=0;
					
				}else {}
				
			}catch(Exception e) {e.printStackTrace();}
			return sno;
		}
		public boolean check(String name)
		{
				boolean flag=true;
			try {
				String sql="select * from ANSWER where USERNAME='"+name+"'";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					flag=false;
				}

			}catch(Exception e) {e.printStackTrace();}
			return flag;
		}
		public int correctAns(String name)
		{
			int c=0;
			try {
				String sql="select count(*) from ANSWER,DATA where ANSWER.CA=DATA.ANS and ANSWER.SNO=DATA.SNO and ANSWER.USERNAME='"+name+"'";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{
					c=rs.getInt(1);
				}
			}catch(Exception e) {e.printStackTrace();}
			return c;
		}
		
}



