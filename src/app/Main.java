/*
*Paul Vetter
*Mr. Ewbank
*APCS A - Period 5
*October 9, 2019
*/

package app;

/*
 * Paul Vetter
 * Mr. Ewbank
 * APCS A - period 5
 * October 9, 2019
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Lexicon lex = new Lexicon();

		System.out.println("example translations");
		System.out.println();
		
	    String newWord1 = lex.translate("food");
	    System.out.println(newWord1);
	    
	    String transWord1 = decode(newWord1);
	    System.out.println(transWord1);
	    
	    String newWord2 = lex.translate("A");
	    System.out.println(newWord2);
	    
	    String transWord2 = decode(newWord2);
	    System.out.println(transWord2);
	    
	    System.out.println();
	    System.out.println("Lexicon sentences translated");
		System.out.println();
	    
	    for (int a = 0; a < 16; a++)
	    {
	    String transMessage = decodeMessage(lex.getSample(a));
	    System.out.println(transMessage);
	    }
	    System.out.println();
	    encodeInput();
		decodeInput();
	  }
	/**
	 * allows you to input a word you would like to be translated
	 */
	  public static void encodeInput()
	  {
		Lexicon lexi = new Lexicon();  
		Scanner code = new Scanner(System.in);
		System.out.println("input a english word you would like to me translated, lowercase please.");
		String encode = code.next();
		String newWord3 = lexi.translate(encode);
		System.out.println(newWord3);
	  }
	  /**
	   * allows you to translate lexicon back to English
	   */
	  public static void decodeInput()
	  { 
			Scanner code = new Scanner(System.in);
			System.out.println("input a lexicon word to be translated to English, lowercase please.");
			String decode = code.next();
			String transWord3 = decodeMessage(decode);
			System.out.println(transWord3);
	  }
	  /**
	   * This method decodes a single word taking into consideration if it has punctuation
	   * 
	   * @param word The single word to be decoded.
	   */
	  public static String decode(String word)
	  {
		
		  int a = 0;
			if(word.charAt(word.length() - 1) == '.') 
			{
				a = 1;
				word = word.substring(0, word.length()-1);
				
			}
			else if(word.charAt(word.length() - 1) == ',')
			{
				a = 2;
				word = word.substring(0, word.length()-1);
			}
			else {}
			
		    if (word.indexOf("ingy") >= 0)
		    {
		    	word = word.substring(0, word.length()-4);
		    	if(word.indexOf("ent") >= 0)
		    	{
		    		String part1 = word.substring(0, word.indexOf("ent"));
		    		String part2 = word.substring(word.indexOf("ent")+3, word.length());
		    		word = part1 + part2;
		    	}
		    }
		    else if(word.indexOf("ent") >= 0)
		    {
		    	String part1 = word.substring(0, word.indexOf("ent"));
				String part2 = word.substring(word.indexOf("ent")+3, word.length());
				word = part1 + part2;
		    }
		    else {}
		    
		    if(a == 1)
		    {
		    	word += ".";
		    }
		    else if(a == 2)
		    {
		    	word += ",";
		    }
		    else {}
			  return word;
	  }
	  /**
	   * Separates sentences then sends them to be decoded then returns the sentence
	   * 
	   * @param message The sentence (multiple words) to be decoded.
	   */
	  public static String decodeMessage(String message)
	  {
		String m = message;
		String finalWord = null;
		String word = null;
		int wordCount = indexRepeat(' ', m) + 1;		
		for (int a = 0; a < wordCount; a++)
		{
			int pos = message.indexOf(' ');
			if(message.indexOf(' ') == -1)			
			{
				word = message;
			}
			else {
			word = message.substring(0, pos);
			}
			word = decode(word); 
			finalWord += word + " "; 
			message = message.substring(pos+1);
		}
		finalWord = finalWord.substring(4,finalWord.length()-1);  
		return finalWord;
	  }
	  /**
	   * Tells you how many times a letter repeats
	   * @param letter
	   * @param word
	   * @return
	   */
	  public static int indexRepeat(char letter, String word)		
	  {
		  int a;
		  int num = 0;
		  for(a = 0; a < word.length()-1; a++)
		  {
			  if(word.charAt(a) == letter)
			  {
				  num++;
			  }
		  }	  
		return num;
	  }
	}
