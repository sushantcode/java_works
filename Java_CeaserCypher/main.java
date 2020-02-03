import javax.swing.*;
import java.io.*;

public class CeaserCypher {

	public static String encrypt(String inputMsg, int key) {
		//Create new String with inputMsg named encrypted
		StringBuilder encrypted = new StringBuilder(inputMsg);
		//Write down alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//Find shiftedAlphabets
		String shiftedAlphabets = alphabets.substring(key,26) + alphabets.substring(0, key) + alphabets.substring(key+26) + alphabets.substring(26,key+26);
		//For each character of inputMSG
		for(int i=0; i < encrypted.length(); i++) {
			//Take out the current character from encrypted string
			char currChar = encrypted.charAt(i);
			//Find the index of the current character in alphabet
			int idx = alphabets.indexOf(currChar);
			//If the character falls in the shiftedAlphabets
			if (idx != -1) {
				//Find the alternative character in shiftedAlphabets
				char newChar = shiftedAlphabets.charAt(idx);
				//Replace the corresponding character in encrypted at the same position
				encrypted.setCharAt(i, newChar);
			}
			//Otherwise do nothing
		}
		//Return the string of encrypted
		return encrypted.toString();		
	}
	
	//this method will return the encrypted message using two keys
	public static String encryptTwoKeys(String input, int key1, int key2) {
		//Create new String with inputMsg named encrypted
		StringBuilder encrypted = new StringBuilder(input);
		//Write down alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//Find first shiftedAlphabets
		String shiftedAlphabets1 = alphabets.substring(key1,26) + alphabets.substring(0, key1) + alphabets.substring(key1+26) + alphabets.substring(26,key1+26);
		//Find second shiftedAlphabets
		String shiftedAlphabets2 = alphabets.substring(key2,26) + alphabets.substring(0, key2) + alphabets.substring(key2+26) + alphabets.substring(26,key2+26);
		//For each character of inputMSG
		for(int i=0; i < encrypted.length(); i++) {
			//Take out the current character from encrypted string
			char currChar = encrypted.charAt(i);
			int idx = alphabets.indexOf(currChar);
			//If the character falls in the shiftedAlphabets
			if (idx != -1) {
				//if i%2==0 then
				if (i % 2 == 0) {
					//Find new char from shiftedAlphabets1
					char newChar = shiftedAlphabets1.charAt(idx);
					//Replace the ith character in the encrypted string
					encrypted.setCharAt(i, newChar);
				}
				//else
				else {
					//Find new char from shiftedAlphabets2
					char newChar = shiftedAlphabets2.charAt(idx);
					//Replace the ith character in the encrypted string
					encrypted.setCharAt(i, newChar);
				}
			//else do nothing
			}
		}
		//return encrpted as String
		return encrypted.toString();
	}
	
	public static void main(String[] args) throws Exception{
		int key = 15;
		int key1 = 20;
		int key2 = 2;
		//FileReader file = new FileReader("C:\\Users\\gupta\\Desktop\\readme.txt");
		//JFileChooser fileChooser = new JFileChooser();
		//fileChooser.showOpenDialog(null);
		//File f = fileChooser.getSelectedFile();
		//FileReader file = new FileReader(f);
		//BufferedReader reader = new BufferedReader(file);
		String text ="Akag tjw Xibhr awoa aoee xakex znxag xwko";
		//String line = reader.readLine();
		//while(line != null) {
			//text += line;
			//line = reader.readLine();
		//}
		System.out.println("Your Original Message is: " + text);
		String encrypted1 = encrypt(text, key);
		System.out.println("Your encrypted message with one key is: " + encrypted1);
		String decrypted1 = encrypt(encrypted1, 26-key);
		System.out.println("Your decrypted message of encrypted by one key one is: " + decrypted1);
		String encrypted2 = encryptTwoKeys(text, key1, key2);
		System.out.println("Your encrypted message with two keys is: " + encrypted2);
		String decrypted2 = encryptTwoKeys(text, 26-key1, 26-key2);
		System.out.println("Your decrypted message of encrypted by two keys one is: " + decrypted2);
		//reader.close();
	}

}
