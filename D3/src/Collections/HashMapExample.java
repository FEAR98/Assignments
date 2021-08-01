package Collections;

import com.sun.source.tree.BinaryTree;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapExample
{
    public static void main(String[] args)
    {
        HashMap<Integer,String > MyMap = new HashMap<>();
        MyMap.put(1500,"Ali");
        MyMap.put(1600,"Efe");
        MyMap.put(1700,"İpek");

        System.out.println(MyMap.get(1700));

        Set MyKeySet = MyMap.keySet();

        for(Iterator iterator = MyKeySet.iterator(); iterator.hasNext();)
        {
            int key = (Integer)iterator.next();
            System.out.println(MyMap.get(key));
        }
    }
}
