package util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "atmServlet", value = "/atm-servlet")
public class ATM extends HttpServlet
{
    private String message;
    Account act;
    @Override
    public void init(ServletConfig config) throws ServletException
    {
       super.init(config);
       message="-150";
       act = new Account();
       act.balance = 200;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2> First ATM <h2>");
        out.println("Current Balance: <B>"+ act.balance +"</B><BR>");
        out.println("<button type=\"button\">-150</button>");
        out.println("</body></html>");


    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        if(req.getParameter("-150") !=null)
        {
            act.withdraw(150);
        }

        req.getRequestDispatcher("");
    }
}

