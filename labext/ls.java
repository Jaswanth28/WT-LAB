
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ls extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
try {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtl1","root","jaswanth");
String n=request.getParameter("txtName");
String p=request.getParameter("txtPwd");
PreparedStatement ps=con.prepareStatement("select uname from login where uname='"+n+"' and password='"+p+"'");
//ps.setString(1, n);
//ps.setString(2, p);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
RequestDispatcher rd=request.getRequestDispatcher("/Welcome.jsp");
rd.forward(request, response);
}
else
{
out.println("<font color=red size=18> Login Failed!!<br>");
out.println("<a href=Login.jsp> Try AGAIN!!</a>");
}
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
