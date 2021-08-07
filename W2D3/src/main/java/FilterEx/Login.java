package FilterEx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");

        try {
            if (checkUser(username, password)) {
                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession newSession = req.getSession();
                newSession.setMaxInactiveInterval(5 * 60);

                Cookie message = new Cookie("message", "Welcome");
                resp.addCookie(message);
                resp.sendRedirect("private/secured.jsp");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/public.html");
                PrintWriter out = resp.getWriter();
                out.println("<font color=red>Either username or password is wrong.</font>");
                rd.include(req, resp);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean checkUser(String username, String password) throws ClassNotFoundException, SQLException {
        boolean status = false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
        PreparedStatement ps = connection.prepareStatement("Select * From user Where username=? and password=?");

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet resultSet = ps.executeQuery();
        status = resultSet.next();
        return status;
    }
}
