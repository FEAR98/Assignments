package Generics;

import java.io.*;

public class Utility<T>
{
    public Utility(T u) {

    }

    public boolean serialize(T type, String fileName) {

        try(FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(type);
        }catch(IOException inputOutputException){
            return false;
        }

        return true;
    }

    public T deSerialize(String fileName) {

        T user = null;
        try(FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            user = (T)objectStream.readObject();
        }catch(IOException | ClassNotFoundException inputOutputException){

        }

        return user;
    }
}
