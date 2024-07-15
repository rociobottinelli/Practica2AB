package implementacion;

import TDA.ArbolTDA;

public class ABB implements ArbolTDA {
	
	class nodoABB {
		int info;
		ArbolTDA hijoizquiero;
		ArbolTDA hijoderecho;
			
	}
	nodoABB raiz;

	@Override
	public void InicializarArbol() {
		raiz = null;
	}

	@Override
	public int Raiz() {
		
		return raiz.info;
	}

	@Override
	public ArbolTDA HijoIzq() {
		
		return raiz.hijoizquiero;
	}

	@Override
	public ArbolTDA HijoDer() {
		
		return raiz.hijoderecho;
	}

	@Override
	public boolean ArbolVacio() {
		// TODO Auto-generated method stub
		return (raiz == null);
	}

	@Override
	public void AgregarElem(int x) {if (raiz == null){
		raiz = new nodoABB();
		raiz.info = x;
		raiz.hijoderecho = new ABB();
		raiz.hijoizquiero = new ABB();
		raiz.hijoderecho.InicializarArbol();
		raiz.hijoizquiero.InicializarArbol();
	}
	else if(raiz.info > x) {
		raiz.hijoizquiero.AgregarElem(x);	//recursivo
	}
	else if (raiz.info < x) {
		raiz.hijoderecho.AgregarElem(x); //recursivo
	
	}

}
private int mayor(ArbolTDA arbol) { //devuelve el elemento mas alto de todo el arbol
		if (arbol.HijoDer().ArbolVacio()) { //si no tiene hijo derecho
			return (arbol.Raiz());
		
		}
		else {
			return (mayor(arbol.HijoDer()));//busca el mayor del arbol que no sea la raiz
		}
}
private int menor(ArbolTDA arbol) { //devuelve el elemento menos alto de todo el arbol
	if (arbol.HijoIzq().ArbolVacio()) { //si no tiene hijo izquierdo
		return (arbol.Raiz());
		
	}
	else {
		return (mayor(arbol.HijoIzq()));//busca el menor del arbol 
	}
		

	}

	@Override
	public void EliminarElem(int x) {
		if (raiz != null) {
			if (raiz.info == x && raiz.hijoizquiero.ArbolVacio() && raiz.hijoderecho.ArbolVacio()) {
				raiz = null;
				
			}
			else if (raiz.info == x && !raiz.hijoizquiero.ArbolVacio()) {
				raiz.info = this.mayor(raiz.hijoizquiero);
				raiz.hijoizquiero.EliminarElem(raiz.info);
				
			}
			else if (raiz.info == x && !raiz.hijoderecho.ArbolVacio()) {
				raiz.info = this.menor(raiz.hijoderecho);
				raiz.hijoderecho.EliminarElem(raiz.info);
			}
			else if (raiz.info > x ) {
				raiz.hijoizquiero.EliminarElem(x);
			}
			else if (raiz.info < x) {
				raiz.hijoderecho.EliminarElem(x);
			}
		}
	}
		
}
		
