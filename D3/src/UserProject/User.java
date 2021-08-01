package UserProject;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = -9144335091427925092L;

    private int id;
    private String name;
    private String surname;
    transient private String password;
    private int age;

    public User(int id, String name, String surname, String password, int age)
    {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.age=age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
