//HtmlFile:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page:</title>
</head>
<body>
<h1>Registration Form!</h1>
<form method="get" action="Servlet1">
Enter username:<input type="text" name="uname"><br>
<br>
Enter password:<input type="password" name="pword"><br>
<br>
Enter College name : <input type="text" name="cname"><br>
<br>
Enter Email id: <input type="text" name="email"><br>
<br>
Select Branch:<select><br>
<br>
            <option value="it">IT</option>
            <option value="cse">CSE</option>
            <option value="aiml">AIML</option>
            <option value="csm">CSM</option>
            </select> 
            <br><br>
Select Course:<select><br>
<br>
            <option value="c">C</option>
            <option value="java">Java</option>
            <option value="Ds">DataStructures</option>
            <option value="python">Python</option>
            </select> 
            <br><br>
<input type ="submit" value="Register">
</form>
</body>
</html>
//Servlet1:
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie1")
public class CookieServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String cookieval=request.getParameter("uname");
		
		String cookieval1=request.getParameter("pword");
		
		Cookie ck = new Cookie("cookie1",cookieval);
		
		Cookie ck1 = new Cookie("cookie2",cookieval1);
		
		response.addCookie(ck);
		response.addCookie(ck1);
			out.print("<h3>You are Successfully Registered Course!!</h3>");
			out.print("<form action = 'CookieServlet2'>");
			out.print("<br><h2>Login to the Course: <h2>");
			out.print("<br>Enter Username : <input type='text' name='uname'<br>");
			out.print("<br><h3>Enter Password: <input type='text' name='pwrd'<br></h3>");
			out.print("<br><h3>Enter Emailid: <input type='text' name='email'<br></h3>");
			out.print("<br><input type = 'submit' value='Login'>");
			out.print("</form>");
			
		}
		
	}
//Servlet2  : 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie2")
public class CookieServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("uname");
		String pword=request.getParameter("pwrd");
		String email=request.getParameter("email");
		 Cookie ck[] = request.getCookies();
		 RequestDispatcher rd;
		 out.print("No.of Cookies created : " +ck.length);
		 if(name.equals(ck[0].getValue()) && pword.equals(ck[1].getValue())) {
				
			out.print("<h2>Welcome "+name+"! You are Successfully Login to your Course!!<br> with Emailid" +email);
				
			}
			 else
			 {
					rd=request.getRequestDispatcher("/Cookie1");
					out.print("<h2 style = 'color : red'>Invalid username/password</h2>");
					rd.include(request, response);
					
					
				}

		 		
	}

}
