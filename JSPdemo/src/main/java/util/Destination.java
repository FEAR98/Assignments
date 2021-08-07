package util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Destination extends HttpServlet {

    private String methodType;
    private static Set<String> destSet;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        this.methodType = getServletConfig().getInitParameter("methodType");

    }
    static {
        destSet = new HashSet<String >();
        destSet.add("school");
        destSet.add("work");
        destSet.add("home");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
    {
        response.setContentType("text/html");
        String param = request.getParameter("destination");

        if(destSet.contains(param))
        {
            if("redirect".equals(methodType))
            {

            }
        }

    }

}
