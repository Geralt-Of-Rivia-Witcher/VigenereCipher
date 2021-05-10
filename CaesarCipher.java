public class CaesarCipher
{

    private String alphabet;
    private String shiftedAlphabet;

    public CaesarCipher(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    private char transformLetter(char c, String from, String to)
    {
        int index = from.indexOf(c);
        if(index != -1)
        {
            return to.charAt(index);
        }
        return c;
    }

    public char encryptLetter(char c)
    {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c)
    {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    public String transform(String input, String from, String to)
    {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            c = transformLetter(c, from, to);
            sb.append(c);
        }
        return sb.toString();
    }

    public String encrypt(String input)
    {
        return transform(input, alphabet, shiftedAlphabet);
    }

    public String decrypt(String input)
    {
        return transform(input, shiftedAlphabet, alphabet);
    }
}