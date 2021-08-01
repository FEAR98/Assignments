package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImp implements PersonDAO
{
    private Connection connection;

    public PersonDAOImp(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public List<Person> findAll() throws SQLException {
        List<Person> personList = new ArrayList<>();


        Statement smt = connection.createStatement();

        String query = "Select * From persons";

        ResultSet rs = smt.executeQuery(query);

        ArrayList<Person> allPerson = new ArrayList<>();

        while(rs.next())
        {
            int personID = rs.getInt("id");
            String personName = rs.getString("name");
            String personEmail = rs.getString("email");
            int personAge = rs.getInt("age");

            Person person = new Person(personID, personName, personEmail, personAge);

            allPerson.add(person);
        }
        for(Person person : allPerson) {
            System.out.println("ID:"+ person.getId()+ " Name: " + person.getName() + " Age:" + person.getAge() + " E-Mail: " + person.getEmail());
        }

        return allPerson;
    }

    @Override
    public void save(Object entity) throws SQLException {
        Person person = (Person) entity;
        String query = "INSERT INTO persons VALUES(?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,person.getId());
        statement.setString(2, person.getName());
        statement.setString(3,person.getEmail());
        statement.setInt(4,person.getAge());

        statement.executeUpdate();
        System.out.println("\nPerson Added. "+"ID:"+ person.getId()+ " Name: " + person.getName() + " Age:" + person.getAge() + " E-Mail: " + person.getEmail());

    }

    @Override
    public int update(int id, Object entity) throws SQLException {
        Person person = (Person) entity;
        String query = "UPDATE persons SET name = ?, email = ?, age = ? WHERE id =?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, person.getName());
        statement.setString(2,person.getEmail());
        statement.setInt(3,person.getAge());
        statement.setInt(4,person.getId());

        statement.executeUpdate();
        System.out.println("\n" + id+" Person Updated");
        return 0;
    }


    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE from persons Where id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println("\n" + id+ " Deleted!");

    }

    @Override
    public Person findById(int id) {
        Person person = null;
        try {
            Statement smt = connection.createStatement();

            String query = "Select * From persons where id=" + id;

            ResultSet rsid = smt.executeQuery(query);

            while (rsid.next()) {
                int personID = rsid.getInt("id");
                String personName = rsid.getString("name");
                String personEmail = rsid.getString("email");
                int personAge = rsid.getInt("age");

                person = new Person(personID, personName, personEmail, personAge);
                System.out.println("\n\nFound! ID:" + person.getId() + " Name: " + person.getName() + " Age:" + person.getAge() + " E-Mail: " + person.getEmail());
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }
}
