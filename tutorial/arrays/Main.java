package arrays;

public class Main {
	public static void main(String[] args) {
		// Más explicaciones dentro de la clase "Arrays.java".
		Arrays a = new Arrays();
				
		// Declarar arreglo y darle valores iniciales:
		Integer[] numeros = {7,5,1,6,4,9,3};
		
		// Métodos de Arrays.java:
		a.arrPrint(numeros);
		a.bubbleSort(numeros);
		a.arrPrint(numeros);
		
		// Declarar arreglo y darle valores posteriormente:
		String[] nombres = new String[4];
		nombres[0] = "Lionel Messi";
		nombres[1] = "Ángel Di María";
		nombres[2] = "Rodrigo De Paul";
		nombres[3] = "Lautaro Martínez";
		
		// Recorrer un array:
		for (Integer i = 0; i < nombres.length; ++i)
			System.out.println(nombres[i]);
	}
}