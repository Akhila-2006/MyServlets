//Home.html:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet4">
<h1>Welcome to JDBC</h1>
<h2> To create a Student Database</h2>
<h3><a href="Add.html" style="color:red;">ADD Student Data Table</a></h3>
<br>
<h3><a href="update.html" style="color:blue;">Update Student Table</a></h3><br>
<h3><a href="delete.html"style="color:green;">Delete the data in Student Table</a></h3><br>
<h4>To display the Student Table Click display</h4>
<input type="submit" value="Display">
</form>
</body>
</html>
//Add.html:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet1">
<h1 style="background-color:blue;color:red;">Enter student Details: </h1>
<br><br>
Enter Studentname:<input type="text" name="name"><br>
<br>
Enter StudentId:<input type="text" name="id"><br>
<br>
Enter StudentDept:<input type="text" name="dept"><br>
<br>
<input type="submit" value="ADD">
</form>
</body>
</html>
//Update.html:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet2 ">
Enter Student dept to update: <input type="text" name="dpt"><br><br>

Enter  New Dept name: <input type="text" name="dpt1">
<br>
<br>
<input type="submit" value="Update">
</form>
</body>
</html>
//Delete.html:
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet3">
Enter Delete Id:<input type="text" name="delid"><br><br>
<input type="submit" value="Delete">
</form>
</body>
</html>
//Servlet1:
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Servlet1")
public class JServlet1 extends HttpServlet {   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "dbms");
            /* Statement st=con.createStatement();
            st.executeUpdate("CREATE TABLE std (name varchar(20) , id number(6) , dept varchar(5))"); */
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO std (name, id, dept) VALUES (?, ?, ?)");
            ps.setString(1, request.getParameter("name"));
            ps.setInt(2, Integer.parseInt(request.getParameter("id")));
            ps.setString(3, request.getParameter("dept"));
            ps.executeUpdate();  
                out.print("<h2>Data inserted successfully into the table...</h2>");
           
            con.close();
        } catch (Exception e) {
            
        }
    }
}
//Servlet2:
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class JServlet2 extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {     
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "dbms");
           Statement st=con.createStatement();
            String olddept=request.getParameter("dpt");
           String newdept=request.getParameter("dpt1");
           st.executeUpdate("UPDATE std SET dept='" + newdept + "' WHERE dept='" + olddept +"'");
           
                out.print("<h2>Updated data in table is Successfull....</h2>");
           
            con.close();
        } catch (Exception e) {
            
        }
    }
}
//Servlet3 : 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class JServlet3 extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "dbms");
           Statement st=con.createStatement();
            int id= Integer.parseInt (request.getParameter("delid"));
           String sql="delete from std  where id= ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);  
           ps.executeUpdate();
           out.print("<h2>" + id + " is deleted Successfully...</h2>");
           out.print("<h3>To display the Student Database</h3>");
            out.print("<form action='Servlet4'>");
            out.print("<input type='submit' value='Clickhere' >");
            out.print("</form>");
           
            con.close();
        } catch (Exception e) {
            
        }
    }
}
//Servlet4:
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet4")
public class JServlet4 extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "dbms");
           Statement st=con.createStatement();
           out.print("The Student table is ");
           ResultSet rs=st.executeQuery("select * from std");
			out.print("<table border=2px>");
			out.print("<tr><td>Name</td><td>Id</td><td>Dept</td><tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getString(1)+"</td><td> "+rs.getInt(2)+"</td><td> "+rs.getString(3)+"</td></tr><br>");
			}
			out.print("</table>");
        } catch (Exception e) {        
        }
    }
}
