# VigenereCipher

An encryption programmer that can encrypt or decrypt text based on random keys of random length, based on user's choice. It can detect the language to decrypt in with support of 8 languages. 

> The Vigenère cipher is a method of encrypting alphabetic text by using a series of interwoven Caesar Ciphers, based on the letters of a keyword. It employs a form of polyalphabetic substitution.

## Languages supported
Danish, Dutch, English, French, German, Italian, Portuguese and Spanish

## How to use

**_Encrypt -_** Put the text to be encrypted in a '.txt' file called "decrypted.txt" in the root folder. The key(s) to be used can be assigned to the 'key' array on line 55. The length can be changed. Then run "VigenereCipher.java". Encrypted text will be placed in a file called "encrypted.txt".

**_Decrypt -_** Put the text to be decrypted in a '.txt' file called "decrypted.txt" in the root folder. Then run "VigenereBreaker.java". It will detect the language and place the decrypted text in a file called "decrypted.txt".
