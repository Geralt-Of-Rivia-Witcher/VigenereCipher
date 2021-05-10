public class CaesarCracker
{
    char mostCommon;
    public CaesarCracker(char c)
    {
        mostCommon = c;
    }

    public int dkey(String encrypted)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int counts[] = new int[26];
        for(int i = 0; i < encrypted.length(); i++)
        {
            int index = alphabet.indexOf(Character.toLowerCase(encrypted.charAt(i)));
            if(index != -1)
            {
                counts[index]++;
            }
        }
        int maxIndex = 0;
        for(int i = 0; i < counts.length; i++)
        {
            if(counts[i] > counts[maxIndex])
            {
                maxIndex = i;
            }
        }
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxIndex - mostCommonPos;
        if(maxIndex < mostCommonPos)
        {
            dkey = 26 - (mostCommonPos - maxIndex);
        }
        return dkey;
    }

    public String decrypt(String encrypted)
    {
        int key = dkey(encrypted);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
    }
}