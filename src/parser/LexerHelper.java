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
			// Verificar si la cadena tiene el formato de un carácter
			if (str.length() == 3 && str.charAt(0) == '\'' && str.charAt(2) == '\'') {
				// Devolver el carácter en el medio de las comillas
				return str.charAt(1);
			} else if (str.equals("'\\t'")) {
				// Devolver el carácter de tabulación si la cadena es "\t"
				return '\t';
			} else if (str.equals("'\\n'")) {
				// Devolver el carácter de nueva línea si la cadena es "\n"
				return '\n';
			} else {
				// Lanzar una excepción si la cadena no tiene el formato correcto
				throw new IllegalArgumentException("La cadena no representa un carácter válido: " + str);
			}
		} catch (Exception e) {
			// Manejar cualquier excepción y mostrar un mensaje de error
			System.out.println("Error al convertir la cadena a carácter: " + e.getMessage());
			// Devolver un valor predeterminado en caso de error
			return ' ';
		}
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
