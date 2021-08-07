package ContactWeb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



@WebServlet("/search")
public class SearchContactServlet extends HttpServlet
{
    private static final String NAME_PARAM = "name";
    private static final String GSM_PARAM = "gsm";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ContactWeb/search-contact.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        doSearch(request,response);
    }
    public void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter(NAME_PARAM);
        String gsm = request.getParameter(GSM_PARAM);

        PrintWriter out = response.getWriter();
        Connection conn = null;

        if (name != null || gsm != null) {
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts", "root", "root");
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM (contacts)  WHERE name='"+ name + "' OR gsm='" + gsm + "'");

                    ResultSet resultSet = ps.executeQuery();

                    while (resultSet.next())
                    {

                        out.print(" Name : " + resultSet.getString("name"));
                        out.println(" GSM : " + resultSet.getString("gsm"));


                    }
                    request.getSession().setAttribute("ename",name);
                    request.getSession().setAttribute("egsm",gsm);
                    request.getRequestDispatcher("ContactWeb/edit-contact.jsp").forward(request,response);

                }
                catch (ClassNotFoundException | SQLException | ServletException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (conn != null)
                    {
                        try
                        {
                            conn.close();
                        }
                        catch (SQLException throwables)
                        {
                            throwables.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}


//    public void old()
//    {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        System.out.println("MySQL Connect Example.");
//        Connection conn = null;
//        String url = "jdbc:mysql://localhost:3306/contacts";
//        String dbName = "contacts";
//        String driver = "com.mysql.jdbc.Driver";
//        String userName = "root";
//        String password = "root";
//
//
//        Statement st;
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url+dbName,userName,password);
//            System.out.println("Connected to the database");
//            String  name  = request.getParameter("name");
//            int  gsm  = Integer.parseInt(request.getParameter("gsm"));
//
//
//            ArrayList al=null;
//            ArrayList contact_list =new ArrayList();
//            String query = "select * from contacts where name='"+name+"' or gsm='"+gsm+"'";
//
//            System.out.println("query " + query);
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//
//            while(rs.next()){
//                al  = new ArrayList();
//
//                al.add(rs.getString(1));
//                al.add(rs.getString(2));
//                al.add(rs.getString(3));
//                al.add(rs.getString(4));
//                al.add(rs.getString(5));
//                al.add(rs.getString(6));
//                al.add(rs.getString(7));
//                al.add(rs.getString(8));
//                al.add(rs.getString(10));
//                System.out.println("al :: "+al);
//                contact_list.add(al);
//            }
//
//            request.setAttribute("contactList",contact_list);
//
//            System.out.println("contactList " + contact_list);
//
//            // out.println("emp_list " + emp_list);
//
//            String nextJSP = "/viewSearch.jsp";
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//            dispatcher.forward(request,response);
//            conn.close();
//            System.out.println("Disconnected from database");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

