package com.exampleD3.W2D3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/OriginServlet")
public class OriginServlet extends HttpServlet
{
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Destination was accessed");
//        req.setAttribute("msg","hello");
//        req.getRequestDispatcher("/DestinationServlet").forward(req,resp);
//    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.1.2
        request.setAttribute("name","Emre");
        request.setAttribute("surname","Omer");

        //1.2.2
//        ServletContext servletContext = getServletContext();
//        servletContext.setAttribute("name","Omer");
//        servletContext.setAttribute("surname","Emre");

        //1.1.3 - 1.2.3
        RequestDispatcher dispatcher = request.getRequestDispatcher("/destination");
        dispatcher.forward(request,response);

        //1.1.4 - 1.2.4
        //response.sendRedirect("/destination");

    }
}
