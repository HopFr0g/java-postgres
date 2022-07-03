package vectores;

import java.util.Vector;
import java.util.Random;

public class Vectores {
	// Llenar al vector con números random:
	public void fillRandom(Vector<Integer> v) {
		Random rand = new Random();
		
		for (Integer i = 0; i < v.capacity(); ++i)
			v.add(rand.nextInt(0, 40));
	}
	
	// Insertar odenado:
	public void insertarOrdenado(Vector<Integer> v, Integer elem) {
		v.add(elem);
		
		for (Integer i = v.size() - 1; i > 0; --i) {
			if (v.get(i) < v.get(i-1)) {
				Integer aux = v.get(i);
				v.set(i, v.get(i-1));
				v.set(i-1, aux);
			}
		}
	}
}
