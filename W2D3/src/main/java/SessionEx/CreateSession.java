package SessionEx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateSession extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("text/html");
            PrintWriter pwriter = resp.getWriter();

            String name = req.getParameter("userName");
            String password = req.getParameter("userPassword");
            pwriter.print("Hello "+name);
            pwriter.print("Your Password is: "+password);
            HttpSession session=req.getSession();
            session.setAttribute("uname",name);
            session.setAttribute("upass",password);
            pwriter.print("<a href='welcome'>view details</a>");
            pwriter.close();
        }catch(Exception exp){
            System.out.println(exp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
