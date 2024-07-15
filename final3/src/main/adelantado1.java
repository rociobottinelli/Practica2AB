package main;

import TDA.ArbolTDA;
import TDA.listaEnlazadaTDA;
import implementacion.ABB;
import implementacion.ListaEnlazadaIMP;

public class adelantado1 {
	
	public static listaEnlazadaTDA CopiarLista(listaEnlazadaTDA original) {
		listaEnlazadaTDA aux = new ListaEnlazadaIMP();
		aux.InicializarLista();
		listaEnlazadaTDA copia = new ListaEnlazadaIMP();
		copia.InicializarLista();
		while (! original.ListaVacia()) {
			aux.Agregar(original.Head());
			original.Sacar(original.Head());
		}
		while (! aux.ListaVacia()) {
			original.Agregar(aux.Head());
			copia.Agregar(aux.Head());
			aux.Sacar(aux.Head());
		}
		return copia;
	}
	
	public static void MostrarLista(listaEnlazadaTDA original) {
		listaEnlazadaTDA copia = CopiarLista(original);
		System.out.print("[");
		while (! copia.ListaVacia()) {
			System.out.print(copia.Head());
			copia.Sacar(copia.Head());
			if (copia.ListaVacia()) 
				System.out.println("]");
			else
				System.out.print(" - ");
						
		}
	}
	
	public static void obtenerHojas (ArbolTDA nodo, listaEnlazadaTDA lista) {
		if (nodo.HijoIzq().ArbolVacio() && nodo.HijoDer().ArbolVacio()) {
			lista.Agregar(nodo.Raiz());
		}
		else {
			if(!nodo.HijoDer().ArbolVacio()) {
				obtenerHojas(nodo.HijoDer(),lista);
			}
			if (!nodo.HijoIzq().ArbolVacio()) {
				obtenerHojas(nodo.HijoIzq(), lista);
				
			}
		}
		
	}

	public static void main(String[] args) {
		ArbolTDA prueba = new ABB();
		prueba.InicializarArbol();
		prueba.AgregarElem(8);
		prueba.AgregarElem(5);
		prueba.AgregarElem(3);
		prueba.AgregarElem(2);
		prueba.AgregarElem(7);
		prueba.AgregarElem(9);
		prueba.AgregarElem(10);
		
		listaEnlazadaTDA lista = new ListaEnlazadaIMP();
		
		obtenerHojas(prueba,lista);
		MostrarLista(lista);
		
		

	}

}
