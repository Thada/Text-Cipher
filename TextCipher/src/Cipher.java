import java.util.Scanner;
public class Cipher {

	//Method for encrypting messages using a Caesar cipher
	public static String caesarEncode(String in, int x) {
		//Check for valid input
		if (x < 1 || x > 25) {
			System.out.println("Invalid cipher value.");
			System.exit(1);
		}
		
		//This loop changes the string to an upper case char array, then modifies unicode values
		StringBuilder text = new StringBuilder();	//Will hold the encoded ciphertext
		for (char c : in.toUpperCase().toCharArray()) {
			if (Character.isLetter(c)) {
				if (c >= 91 - x)
					text.append((char) (c - 26 + x));
				else
					text.append((char) (c + x));
			}
			else
				text.append((char) (c));
		}
		return text.toString();
	}
	
	public static String caesarDecode(String in, int x) {
		//Check for valid input
		if (x < 1 || x > 25) {
			System.out.println("Invalid cipher value.");
			System.exit(1);
		}
		
		//This loop changes the string to an upper case char array, then modifies unicode values
		StringBuilder text = new StringBuilder();	//Will hold the decoded plaintext
		for (char c : in.toUpperCase().toCharArray()) {
			if (Character.isLetter(c)) {
				if (c <= 64 + x)
					text.append((char) (c + 26 - x));
				else
					text.append((char) (c - x));
			}
			else
				text.append((char) (c));
		}
		return text.toString();
	}
	
	// *** CURRENTLY IN PROGRESS ***
	//Method for encrypting messages using a Vigenere cipher
	public static String vigenereEncode(String in, String key) {
		StringBuilder text = new StringBuilder();	//Will hold the encoded ciphertext
		StringBuilder cipher = new StringBuilder();	//Will hold the cipher key 
		
		while (cipher.length() < in.length()) 
			cipher.append(key.toUpperCase());		
		
		for (int i = 0; i < in.length(); i++) {
			in.toUpperCase().toCharArray();
			System.out.println(64 + (cipher.charAt(i) % 26));
			if (Character.isLetter(in.charAt(i))) {
				if (in.charAt(i) <= 64 + (cipher.charAt(i) % 26))
					text.append((char) (in.charAt(i) - 26 + (cipher.charAt(i) % 26)));
				else
					text.append((char) (in.charAt(i) + (cipher.charAt(i) % 26)));
			}
			else
				text.append((char) (in.charAt(i)));
		}
		return text.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	//Variable for taking user input
		
		//Prompt for user input, to choose what cipher to use
		System.out.println("Choose a cipher (Caesar)");
		String selection = input.nextLine();
		
		//Options for using a Caesar cipher
		if (selection.equalsIgnoreCase("CAESAR") || selection.equalsIgnoreCase("C")) {
			System.out.println("Encode or Decode a message?");
			selection = input.nextLine();
			
			if (selection.equalsIgnoreCase("ENCODE") || selection.equalsIgnoreCase("E")) {
				System.out.println("Please enter the plaintext you would like to encode.");
				String plain = input.nextLine();
				System.out.println("Please enter an integer between 1 and 25 as the cipher key.");
				int key = input.nextInt();
				System.out.println(caesarEncode(plain, key));
			}
			else if (selection.equalsIgnoreCase("DECODE") || selection.equalsIgnoreCase("D")) {
				System.out.println("Please enter the ciphertext you would like to decode.");
				String ctext = input.nextLine();
				System.out.println("Please enter an integer between 1 and 25 as the cipher key.");
				int key = input.nextInt();
				System.out.println(caesarDecode(ctext, key));
			}
			else
				System.out.println("Invalid selection.");
			
		}
/*		
		else if (selection.equalsIgnoreCase("VIGENERE") || selection.equalsIgnoreCase("V")) {
			System.out.println("Encode or Decode a message?");
			selection = input.nextLine();
			
			if (selection.equalsIgnoreCase("ENCODE") || selection.equalsIgnoreCase("E")) {
				System.out.println("Please enter the plaintext you would like to encode.");
				String plain = input.nextLine();
				System.out.println("Please enter a word as the cipher key.");
				String key = input.nextLine();
				System.out.println(vigenereEncode(plain, key));
			}
			else if (selection.equalsIgnoreCase("DECODE") || selection.equalsIgnoreCase("D")) {
				System.out.println("Please enter the ciphertext you would like to decode.");
				String ctext = input.nextLine();
				System.out.println("Please enter a word as the cipher key.");
				int key = input.nextInt();
				//System.out.println(vigenereDecode(ctext, key));
			}
			else
				System.out.println("Invalid selection.");
		}*/
		else 
			System.out.println("Invalid selection.");
		
		input.close();
	}

}
