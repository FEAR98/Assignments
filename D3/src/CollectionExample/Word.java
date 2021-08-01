package CollectionExample;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Word implements Comparable<Word>
{
    private String word;

    public Word(String word)
    {
        this.word=word;
    }

    @Override
    public boolean equals(Object o)
    {
        if( this == o )
        {
            return true;
        }
        if( o == null  || getClass() != o.getClass())
        {
            return false;
        }
        Word words = (Word) o;
        return Objects.equals(word,words.word);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(word);
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.word);
    }
}
