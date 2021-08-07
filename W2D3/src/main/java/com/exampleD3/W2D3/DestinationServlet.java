package com.exampleD3.W2D3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/DestinationServlet")
public class DestinationServlet extends HttpServlet
{
    String name;
    String surname;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");

//        ServletContext  servletContext = getServletContext();
//        String name = (String) servletContext.getAttribute("name");
//        String surname = (String) servletContext.getAttribute("surname");
//        servletContext.removeAttribute("name");
//        servletContext.removeAttribute("surname");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + name + " " + surname + "</h1>");
        out.println("</body></html>");
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
