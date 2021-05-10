import java.util.*;
import java.io.*;

public class VigenereBreaker
{
    public static String sliceString(String message, int whichSlice, int totalSlices)
    {
        StringBuilder sb = new StringBuilder("");
        for(int i = whichSlice; i < message.length(); i += totalSlices)
        {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public static int[] tryKeyLength(String encrypted, int kLength, char mostCommon)
    {
        CaesarCracker cracker = new CaesarCracker(mostCommon);
        int key[] = new int[kLength];
        for(int i = 0; i < kLength; i++)
        {
            String slice = sliceString(encrypted, i, kLength);
            key[i] = cracker.dkey(slice);
        }
        return key;
    }

    public static int countWords(String message, HashSet <String> dictionary)
    {
        String words[] = message.split("\\W+");
        int count = 0;
        for(String word : words)
        {
            if(dictionary.contains(word.toLowerCase()))
            {
                count++;
            }
        }
        return count;
    }

    public static String breakForLanguage(String encrypted, HashSet <String> dictionary, char mostCommonChar)
    {
        int fianlCount = 0;
        String decrypted = "";
        for(int i = 1; i <= 10; i++)
        {
            int key[] = tryKeyLength(encrypted, i, mostCommonChar);
            VigenereCipher vigenere = new VigenereCipher(key);
            String temp = vigenere.decrypt(encrypted);
            int count = countWords(temp, dictionary);
            if(count > fianlCount)
            {
                decrypted = temp;
                fianlCount = count;
                //System.out.println(key.length);
                // for(int j = 0; j < key.length; j++)
                // {
                //     System.err.print(key[j] + " ");
                // }
                // System.out.println();
            }
        }
        return decrypted;
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("encrypted.txt");
        Scanner sc = new Scanner(file);
        StringBuilder encrypted = new StringBuilder("");
        while(sc.hasNext())
        {
            encrypted.append(sc.next() + " ");
        }
        sc.close();
        File newFile = new File("decrypted.txt");
        newFile.createNewFile();
        HashMap <String, HashSet <String>> dictionary = otherLanguage.readDictionary();
        HashMap <String, String> decryptedStrings = otherLanguage.breakForAllLangs(encrypted.toString(), dictionary);
        
        int count = 0;
        String finalAnswer = "";
        for(String language : decryptedStrings.keySet())
        {
            System.out.println(language);
            int temp = countWords(decryptedStrings.get(language), dictionary.get(language));
            if(temp > count)
            {
                temp = count;
                finalAnswer = decryptedStrings.get(language);
            }
        }
        FileWriter writer = new FileWriter("decrypted.txt");
        writer.write(finalAnswer);
        writer.close();
    }
}