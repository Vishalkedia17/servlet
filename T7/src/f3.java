

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class f3
 */
@WebServlet("/f3")
public class f3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public f3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connect c=new Connect();
		HttpSession s=request.getSession();
		String name=(String)s.getAttribute("uname");
		int tq=c.getCount();
		int qa=c.getCountAns(name);
		int ca=c.correctAns(name);
		int wa=tq-ca;
		String str=null;
		if((((float)(ca/tq))*100)>=60)
		{
			str="PASS";
		}
		else
			str="FAIL";
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n" + 
				"<title>Untitled Document</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"<!--\r\n" + 
				".style1 {color: #FFFFFF}\r\n" + 
				"-->\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body bgcolor=\"#CCCCCC\">\r\n" + 
				"<form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n" + 
				"  <table width=\"70%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" align=\"center\">\r\n" + 
				"  <tr bgcolor=\"#FFFFFF\">\r\n" + 
				"  <td>\r\n" + 
				"  <table width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" align=\"center\">\r\n" + 
				"    <tr bgcolor=\"#00FF66\">\r\n" + 
				"      <td><h2 align=\"left\">CODETHON RESULT 2019-2020 </h2>\r\n" + 
				"        <p align=\"left\">&nbsp;</p>\r\n" + 
				"        <p align=\"left\"><strong>Name : "+name+" </strong></p>\r\n" + 
				"      <p align=\"left\"><strong>Session Id :"+s.getId()+"</strong></p>\r\n" + 
				"      <p align=\"left\"><strong>Session Time :"+s.getCreationTime()+"</strong></p>\r\n" + 
				"      <h4 align=\"left\">College name : ASANSOL ENGINEERING COLLEGE </h4></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr bgcolor=\"#FFFFFF\">\r\n" + 
				"      <td>\r\n" + 
				"        <div align=\"left\">\r\n" + 
				"          <table width=\"100%\" border=\"1\" align=\"left\" cellpadding=\"10\" cellspacing=\"0\" bordercolor=\"#0066FF\">\r\n" + 
				"            <tr>\r\n" + 
				"              <td><div align=\"center\"><strong>TOTAL NO. OF QUESTION</strong></div></td>\r\n" +
				"				<td><div align=\"center\"><strong>"+tq+"</strong></div></td>\r\n" +
				"            <tr>\r\n" +
				"			<tr>" +
				"				<td><div align=\"center\"><strong>TOTAL NO. OF QUESTION ATTEMPTED</strong></div></td>\r\n"+
				"				<td><div align=\"center\"><strong>"+qa+"</strong></div></td>"+
				"			</tr>"+
				"			<tr> "+ 
				"				<td><div align=\"center\"><strong>CORRECT ANSWER</strong></div></td>"+ 
				"				<td><div align=\"center\"><strong></strong>"+ca+"</div></td>"+ 
				"			</tr>"+
				"			<tr>"+ 
				"				<td><div align=\"center\"><strong>WRONG ANSWER</strong></div></td>" + 
				"				<td><div align=\"center\"><strong>"+wa+"</strong></div></td>" + 
				"			</tr>"+
				"			<tr>" + 
				"			<td><div align=\"center\"><strong>ROUND 1</strong></div></td>" + 
				"			<td><div align=\"center\"><strong></strong>"+str+"</div></td>" + 
				"			</tr>"+
				"  </table>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
