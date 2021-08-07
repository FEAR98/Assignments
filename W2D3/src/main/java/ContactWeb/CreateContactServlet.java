package ContactWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/create")
public class CreateContactServlet extends HttpServlet
{
    private static final String NAME_PARAM = "name";
    private static final String GSM_PARAM = "gsm";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ContactWeb/create-contact.jsp");

    }
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
            try{
                doProcess(req,resp);
            }catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
    }
    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws  SQLException, ClassNotFoundException {

        String name = req.getParameter(NAME_PARAM);
        String gsm = req.getParameter(GSM_PARAM);

        Connection conn = null;

        if(name != null || gsm != null)
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "root");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO contacts (name, gsm) VALUES (?,?)");

                ps.setString(1, name);
                ps.setString(2, gsm);
                ps.executeUpdate();
            } finally {
                if(conn != null){
                    conn.close();
                }
            }
        }


    }

//    public void SearchAll()
//    {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        PrintWriter out = response.getWriter();
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","root");
//            stmt = conn.createStatement();
//            String query = "select * from contacts";
//            rs = stmt.executeQuery(query);
//
//            out.print("<html>");
//            out.print("<head>");
//            out.print("<title>Hello Connect Database</title>");
//            out.print("</head>");
//            out.print("<name>");
//            out.print("<h1>Name/GSM from database</h1>");
//            out.print("<br/>");
//
//            System.out.println("Get value from table contacts.");
//            while(rs.next()){
//                out.println("<tr>");
//                out.print("Name : " + rs.getString("name"));
//                out.print("\nGSM : " + rs.getInt("gsm"));
//                out.print("</tr><br/>");
//            }
//
//            out.print("</body>");
//            out.print("</html>");
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            if(stmt != null){
//                stmt.close();
//            }
//            if(conn != null){
//                conn.close();
//            }
//        }
//    }


}
