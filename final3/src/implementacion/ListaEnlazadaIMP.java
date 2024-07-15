package implementacion;
import TDA.listaEnlazadaTDA;

public class ListaEnlazadaIMP implements listaEnlazadaTDA {
	
	class Nodo{
		int valor1;
		Nodo sig;
	}
	Nodo cabeza;

	@Override
	public void InicializarLista() {
		cabeza = null;

	}

	@Override
	public void Agregar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.valor1 = x;
		nuevo.sig = cabeza;
		cabeza = nuevo;

	}

	@Override
	public void Sacar(int x) {
		if (cabeza.valor1 == x) {
			cabeza = cabeza.sig;
		}
		else {
			Nodo aux = cabeza;
			while (aux.sig != null && aux.sig.valor1 != x) {
				aux = aux.sig;
			}
			if (aux.sig != null) {
				aux.sig = aux.sig.sig;
			}
		}
	}

	

	@Override
	public boolean ListaVacia() {
		return (cabeza == null);
	}

	@Override
	public int Head() {
		return cabeza.valor1;
	}

}
