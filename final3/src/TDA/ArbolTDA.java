package TDA;

public interface ArbolTDA {
	void InicializarArbol();
	int Raiz();
	// siempre que el árbol esté inicializado y no esté vacío
	ArbolTDA HijoIzq();
	// siempre que el árbol esté inicializado y no esté vacío
	ArbolTDA HijoDer();
	// siempre que el árbol esté inicializado
	boolean ArbolVacio();
	// siempre que el árbol esté inicializado
	void AgregarElem(int x);
	// siempre que el árbol esté inicializado
	void EliminarElem(int x);

}
