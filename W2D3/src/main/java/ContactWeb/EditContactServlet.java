package ContactWeb;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/edit")
public class EditContactServlet extends HttpServlet
{
    private static final String NAME_PARAM = "name";
    private static final String GSM_PARAM = "gsm";
//    private static final String DEST = "/ContactWeb/";

    private String name;
    private String gsm;

    @Override
    public void init() throws ServletException {
        name = getServletConfig().getInitParameter("name");
        gsm = getServletConfig().getInitParameter("gsm");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        String name = req.getParameter(NAME_PARAM);
//        String gsm = req.getParameter(GSM_PARAM);
//
//        String forwardDestination = DEST + "edit-contact.jsp";
//
//        if(!StringUtils.isNullOrEmpty(name) && !StringUtils.isNullOrEmpty(gsm))
//        {
//            req.setAttribute(NAME_PARAM, name);
//            req.setAttribute(GSM_PARAM, gsm);
//        }
//        req.getRequestDispatcher(forwardDestination).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ename = req.getParameter(NAME_PARAM);
        String egsm = req.getParameter(GSM_PARAM);

        name = req.getParameter("ename");
        gsm = req.getParameter("egsm");

        PrintWriter out = resp.getWriter();
        out.print(" Name : " + name);
        out.println(" GSM : " + gsm);
        out.print(" New Name : " + ename);
        out.println(" New GSM : " + egsm);

        doUpdate(name, gsm , ename, egsm);
    }

    public void doUpdate(String name, String gsm,String newName, String newGSM)
    {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "root");
            PreparedStatement ps = conn.prepareStatement("UPDATE contacts SET name='" +newName+ "', gsm='"+ newGSM + "' WHERE name='"+ name + "' OR gsm='" + gsm + "'");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
