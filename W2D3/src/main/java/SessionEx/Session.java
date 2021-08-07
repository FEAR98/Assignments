package SessionEx;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class Session extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            HttpSession session=request.getSession(false);
            String myName=(String)session.getAttribute("uname");
            String myPass=(String)session.getAttribute("upass");
            pwriter.print("Name: "+myName+" Pass: "+myPass);
            pwriter.close();
        }catch(Exception exp){
            System.out.println(exp);
        }
    }
}