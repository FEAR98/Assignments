package org.example;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class JavaLambda
{
    public static void main(String[] args) throws Exception {

        mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jss_demo?characterEncoding=utf-8","root","root");


        PersonDAOImp p = new PersonDAOImp(mysqlConnection);
        p.findAll();
        Person p1 = new Person(5,"Ata","gmail.com",12);
        int ID = 5;
        System.out.println("Find by ID:" +ID);
        p.save(p1);
        p.findById(ID);
        p.update(ID,p1);
        p.findById(ID);
        p.findAll();
        p.delete(ID);
        p.findAll();

    }

    static Connection mysqlConnection = null;
    static PreparedStatement preparedStatement = null;



    public static void makeJDBCConnection()
    {
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }

        try{
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jss_demo?characterEncoding=utf-8","root","root");
            if(mysqlConnection != null){
                System.out.println("Connection: True");
            }
            else{
                System.out.println("Connection: False");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
