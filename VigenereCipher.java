import java.io.*;
import java.util.*;

public class VigenereCipher
{
    static CaesarCipher ciphers[];
    public VigenereCipher(int[] key)
    {
        ciphers = new CaesarCipher[key.length];
        for(int i = 0; i < key.length; i++)
        {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder("");
        int i = 0;
        for(char c : input.toCharArray())
        {
            int index = i++ % ciphers.length;
            CaesarCipher cipher = ciphers[index];
            encrypted.append(cipher.encryptLetter(c));
        }
        return encrypted.toString();
    }

    public String decrypt(String input)
    {
        StringBuilder decrypted = new StringBuilder("");
        int i = 0;
        for(char c : input.toCharArray())
        {
            int index = i++ % ciphers.length;
            CaesarCipher cipher = ciphers[index];
            decrypted.append(cipher.decryptLetter(c));
        }
        return decrypted.toString();
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("decrypted.txt");
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
        {
            sb.append(sc.next() + " ");
        }
        sc.close();
        File newFile = new File("encrypted.txt");
        newFile.createNewFile();
        FileWriter writer = new FileWriter("encrypted.txt");
        int key[] = {6, 9, 20, 15};
        VigenereCipher vigenere = new VigenereCipher(key);
        writer.write(vigenere.encrypt(sb.toString()));
        writer.close();       
        System.out.println("Key length = " + ciphers.length); 
    }
}