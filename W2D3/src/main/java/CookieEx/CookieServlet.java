package CookieEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        Cookie cookie1 = new Cookie("id","12345");
//        resp.addCookie(cookie1);
//        Cookie cookie2 = new Cookie("userno","123456");
//        resp.addCookie(cookie2);
//
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>CookieServlet</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>CookieServlet</h1>");
//        out.println("<h2>");
//        out.println("<form method=POST action=CookieServlet");
//        out.println("I have sent you a piece of cookie.<br>");
//        out.println("<p><input type submit value=\"Click here to see it");
//        out.println("</form>");
//        out.println("</body>");
//        out.println("</html>");
//
//        out.close();

        if(!Objects.isNull(req.getParameter("displayCookies")))
        {
            displayCookies(req.getCookies(), resp.getWriter());
        }
        else
        {
            Cookie cookie = new Cookie("JSS2021" + System.nanoTime(), "some-value");

            if(!Objects.isNull("httpOnly"))
            {
                cookie.setHttpOnly(true);
            }
            resp.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count=0;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null) count = cookies.length;
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>CookieServlet</h1>");
        out.println("<h2>");
        out.println("There are");
        out.println(count);
        out.println("cookies associated with this site.<br>");
        if(count > 0)
        {
            out.println("Here they are: <br></h2>");
            for(int i=0; i<count; i++)
            {
                out.println("<p><b> Cookie name:</b>" + cookies[i].getName());
                out.println("<b> Cookie value:</b>" + cookies[i].getValue());
            }
        }
        out.println("</body");
        out.println("</html>");
        out.close();
    }

    private void displayCookies(Cookie[] cookies, PrintWriter writer)
    {
        if(!Objects.isNull(cookies))
        {
            for(Cookie cookie: cookies)
            {
                writer.println("Cookie name: " + cookie.getName() + " Cookie value: " + cookie.getValue());
            }

        }
        else
        {
            writer.println("No Cookie exists!");
        }
    }
}
