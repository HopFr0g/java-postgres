package vectores;

import java.util.Vector;
import java.util.Collections;

public class Main {
	private static Vector<Integer> numeros;
	
	public static void main(String[] args) {
		// En este caso el vector que se utilizará es un atributo de la clase, inicializarlo primero:
		numeros = new Vector<Integer>(5);
		
		// Cuando declaro un vector con una capacidad inicial, por ejemplo Vector<Integer>(5)
		// EL VECTOR NO TENDRÁ ELEMENTOS, Y SU .size() SERÁ DE 0
		// PERO SU .capacity() SERÁ DE 5
		
		// Ver el archivo "Vectores.java".
		Vectores v = new Vectores();
		
		// Se llamará a un método que llene al vector con números aleatorios:
		v.fillRandom(numeros);
		
		// Mostrar el vector:
		System.out.println(numeros);
		
		// Ordenar elementos del vector con un método predefinido:
		Collections.sort(numeros);
		
		// Mostrar el vector:
		System.out.println(numeros);
		
		// Insertar odenado:
		v.insertarOrdenado(numeros, 2);
		
		// Mostrar el vector
		System.out.println(numeros);
	}
}