package CollectionExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver
{
    private static String BufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) throws IOException
    {
        String str = BufferedReader("Collection.txt");
        String[] array = str.toLowerCase().split("[ .,]+");

        HashMap<Word, Integer> myHashMap = new HashMap<>();
        TreeMap<Word, Integer> myTreeMap = new TreeMap<>();
        LinkedHashMap<Word, Integer> myLinkedHashMap = new LinkedHashMap<>();

        UniqueWords(myHashMap,array);
    }

    public static void UniqueWords( Map<Word, Integer> words, String[] array)
    {
        for(String i: array)
        {
            Word tmp = new Word(i);
            if(words.containsKey(tmp))
            {
                words.put(tmp, words.get(tmp) + 1);
            }
            else
            {
                words.put(tmp, 1);
            }
        }

        System.out.println("Number of unique words: " + words.size());
    }
}
