import java.io.*;
import java.util.*;

public class otherLanguage
{
    public static char mostCommonCharIn(HashSet <String> dictionary)
    {
        HashMap <Character, Integer> map = new HashMap <Character, Integer>();
        for(String word : dictionary)
        {
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if(map.containsKey(c))
                {
                    map.put(c, map.get(c) + 1);
                }
                else
                {
                    map.put(c, 1);
                }
            }
        }
        int count = 0;
        char mostCommonChar = '\0';
        for(char c : map.keySet())
        {
            if(map.get(c) > count)
            {
                count = map.get(c);
                mostCommonChar = c;
            }
        }
        return mostCommonChar;
    }

    public static HashMap <String, HashSet <String>> readDictionary() throws IOException
    {
        HashMap <String, HashSet <String>> map = new HashMap <String, HashSet <String>>();
        HashSet <String> set = new HashSet <String>();
        File file = new File("dictionaries\\Danish");
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("Danish", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\Dutch");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("Dutch", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\English");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("English", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\French");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("French", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\German");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("German", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\Italian");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("Italian", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\Portuguese");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("Portuguese", set);

        set = new HashSet <String>();
        file = new File("dictionaries\\Spanish");
        sc.close();
        sc = new Scanner(file);
        while(sc.hasNext())
        {
            set.add(sc.nextLine());
        }
        map.put("Spanish", set);
        sc.close();

        for(String s : map.keySet())
        {
            System.out.println(s + " = " + map.get(s).size());
        }
        return map;
    }

    public static HashMap <String, String> breakForAllLangs(String encrypted, HashMap <String, HashSet<String>> languages)
    {
        HashMap <String, String> map = new HashMap <String, String>();
        for(String language : languages.keySet())
        {
            HashSet <String> dictionary = languages.get(language);
            char mostCommonChar = mostCommonCharIn(dictionary);
            map.put(language, VigenereBreaker.breakForLanguage(encrypted, dictionary, mostCommonChar));
        }
        return map;
    }
}