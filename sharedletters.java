import java.util.Scanner;

public class SharedLettersBetweenTwoWords {
	
  // Returns the number of letters that both user-input words have in common
	static int sharedLetters(String w1, String w2) {
		int count = 0;
		
		for (int i = 0; i < w1.length(); i++) {
			for (int j = 0; j < w2.length(); j++) {
				if (w1.charAt(i) == w2.charAt(j)) {
					count++;
					String ch = Character.toString(w2.charAt(j));
					w2 = w2.replaceFirst(ch, "");
					break;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter two space-separated words: ");
		String str = scan.nextLine();
		
    // Validates input to allow letters and spaces
		for (int i = 0; i < str.length(); i++) {
			while (!Character.isLetterOrDigit(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i))) {
				System.out.println("\nError: Only letters are allowed.");
				System.out.print("Enter two space-separated words: ");
				str = scan.nextLine();
			}
		}
		scan.close();
		
    // Assigns index value of first space found
		int index = str.indexOf(' ');
    
    // Splits string into two words
		String word1 = str.substring(0, index);
		String word2 = str.substring(index + 1, str.length());
		
    // Prints the result
		System.out.println("Number of letters shared between \"" + word1 + "\" and \"" + word2 + "\": " + sharedLetters(word1, word2));
	}
}
