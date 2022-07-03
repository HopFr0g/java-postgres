package arrays;

public class Arrays {
	// Método genérico (templatizado): escribir <T> adelante del tipo de la función.
	
	public <T> void arrPrint(T[] arr) {
		System.out.print("{ ");
		// For each, forma más rápida de recorrer un arreglo:
		for (T a : arr)
			System.out.print(a + " ");
		System.out.print("}\n");
	}
	
	// NOTA: Cuando se pide un array como parámetro, lo que se recibe es la dirección de memoria.
	// Por lo tanto, si el método modifica el array recibido, el array original también será modificado.
	// No se considera un pasaje por referencia pero funciona de la misma manera.
	
	public void bubbleSort(Integer[] arr) {
		for(Integer i = 0; i < arr.length; ++i)
			for (Integer j = 0; j < arr.length - 1 - i; ++j)
				if (arr[j] > arr[j+1]) {
					Integer aux = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = aux;
				}
	}
}