package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			return ' ';
		} catch (Exception e) {
			System.out.println(e);
		}
		return ' ';
	}

	public static Double lexemeToReal(String str){
		try {
			Double.parseDouble(str);
		} catch (Exception e){
			System.out.println(e);
		}
		return -1.0;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
