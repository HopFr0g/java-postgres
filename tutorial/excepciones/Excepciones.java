package excepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import java.net.URL;

public class Excepciones {
	// IOException: se produce cuando hay una falla al leer un archivo.
	// Es obligación tratar con estas excepciones.
	
	// Declarar la excepción usando la palabra clave "throws" en el header de una función:
	private String leerArchivo() throws IOException {
		URL url = this.getClass().getResource("texto.txt");
		String path = url.getPath();
		
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String firstLine = br.readLine();
		
		br.close();
		
		return firstLine;
	}
	
	/// throws declara la excepción pero no la evita, usar throws implica que el método no resolverá el error;
	/// cuando se utiliza throws en un método, la función que invoque a ese método deberá capturar la excepción con "try catch".
	
	// Usar try catch:
	public void imprimirArchivo() {
		try {
			String rd = leerArchivo();
			System.out.println(rd);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}