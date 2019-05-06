

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class f2
 */
@WebServlet("/f2")
public class f2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public f2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	static int count;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	HttpSession s=request.getSession();
    	Connect c=new Connect();
    	int cnt;
    	String op1="";
    	String op2="";
    	String op3="";
    	String op4="";
    	
		String name=(String)s.getAttribute("uname");
		cnt=Integer.parseInt(request.getParameter("c"));
		String a=c.getANS(cnt,name);
			if(a!=null)
			{
				if(a.equals("A"))
				{
					op1="checked";
					System.out.println("A");
				}
				else if(a.equals("B"))
				{
					op2="checked";
					System.out.println("B");
				}
				else if(a.equals("C"))
				{
					op3="checked";
					System.out.println("C");
				}
				else if(a.equals("D"))
				{
					op4="checked";
					System.out.println("D");
				}
			}
		count=cnt;
		int tmp=c.getCount();
		boolean flag2=c.check(name);
		if(flag2==true)
		{
			c.setSno(tmp,name);
		}
		if(count==(tmp+1))
			count=1;
		Question ob=c.getQuestion(count);
		int row=(int)Math.ceil(tmp/3);
		int ans=0;
		if((request.getParameter("d")!=null))
		{
			ans=Integer.parseInt(request.getParameter("d"));	
		}
		String option=request.getParameter("op");
		if(option!=null)
		{
			int g=c.update(ans,option);
			
		}
		if((request.getParameter("submit")!=null))
		{
			response.sendRedirect("f3");	
			
		}
		out.println("<html>");
    	out.println("<head>");
    	out.println("<title>QUIZ</title>");
    	out.println("<body bgcolor=\"cyan\">");
    	out.println("<form name=\"f2\" method=\"post\">");
    	out.println("<table border=\"1\" bordercolor=\"black\" align=\"center\" cellspacing=\"2\" cellpadding=\"10\" width=\"100%\">");
    	out.println("<tr>");
    	out.println("<td height=\"42\" colspan=\"5\" align=\"center\"><font color=\"blue\"><h2><###CODETHON QUIZ COMPETITION###></font></h2></td>");
    	out.println("</tr>");
    	out.println("<tr align=\"center\">");
    	out.println("<td height=\"42\" width=\"25%\"><h1>NAME</h1></td>");
   		out.println(" <td height=\"42\"width=\"13%\"><h1>:</h1></td>");
   		out.println("<td height=\"42\" colspan=\"5\" align=\"left\"><h1>"+name+"<h1></td>");
    	out.println(" </tr>");
    	out.println("<tr>");
        out.println("<td height=\"204\" colspan=\"4\"><b>"+count+")"+ob.getQues()+"</b></td>");
        out.println("<td>");
        out.println("<table border=\"1\" bordercolor=\"black\" align=\"center\" cellspacing=\"2\" cellpadding=\"10\" width=\"100%\">");
        for(int i=1;i<=row;i++)
        {
        	out.println("<tr>");
        	for(int j=1;j<=5;j++)
        	{
				if(((5*i)+j)>tmp)
				{
					break;
				}
        		String flag1=c.getANS((j*i),name);
        		String color=null;
        		if(flag1==null)
        		color="red";	
        		else
        		color="green";
        		out.println("<th bgcolor=\""+color+"\"><a href=\"f2?c="+(j)+"\">"+j+"</th>");
        	}
        	out.println("</tr>");
        }
        out.println("</table>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"25%\">1)"+ob.getOp1()+"</td>");
        out.println("<td height=\"25\" colspan=\"3\">2)"+ob.getOp2()+"</td>");
        out.println("<td width=\"38%\" rowspan=\"2\">"
        		+ "<input type=\"submit\" value=\"SAVE AND NEXT\" onclick=\"form.action='f2'\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>3)"+ob.getOp3()+"</td>");
        out.println("<td height=\"42\" colspan=\"3\">4)"+ob.getOp4()+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td height=\"47\" colspan=\"4\">");
        out.println("<input type=\"radio\" name=\"op\" value=\"A\" "+op1+">A"
        		+ "<input type=\"radio\" name=\"op\" value=\"B\" "+op2+">B"
        		+ "<input type=\"radio\" name=\"op\" value=\"C\" "+op3+">C"
        		+ "<input type=\"radio\" name=\"op\" value=\"D\" "+op4+">D"
        		+ "</td>");
        out.println("<td height=\"47\" colspan=\"1\"><input type=\"submit\" value=\"SUBMIT\"  name=\"submit\" onclick=\"form.action='f3'\"></td>");
        out.println("</tr>");
        out.print("<input type=\"hidden\" name=\"c\" value=\""+(count+1)+"\">");
        out.print("<input type=\"hidden\" name=\"d\" value=\""+ob.getSno()+"\">");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
