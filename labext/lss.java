import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class lss extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String n=request.getParameter("username");
String p=request.getParameter("userpass");
try {
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtl1", "root", "jaswanth");
java.sql.Statement s=conn.createStatement();
String sql= "SELECT * FROM user WHERE name=n and pass=p";
ResultSet rs = s.executeQuery(sql);
if(rs.next()){
out.println("Welcome "+n);
} else{
out.println("Sorry username or password error");
RequestDispatcher rd=request.getRequestDispatcher("/index.html");
rd.include(request,response);
}
rs.close();
s.close();
conn.close();
} catch(Exception e){
e.printStackTrace();
}
out.close();
}
}