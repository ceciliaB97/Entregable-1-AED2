package uy.edu.ort.aed2.entregable;

class NodoListaSimple {
    private int dato;
    private NodoListaSimple sig;

    public NodoListaSimple(int dato) {
        this.dato = dato;
        this.sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoListaSimple getSig() {
        return sig;
    }

    public void setSig(NodoListaSimple sig) {
        this.sig = sig;
    }

}

public class ListaSimpleEncadenada implements Lista {
    private NodoListaSimple primero;
    private NodoListaSimple ultimo;
    private int cantidadNodos;

    @Override
    public void agregarAlPrincipio(int valorNuevo) {
        NodoListaSimple nuevo = new NodoListaSimple(valorNuevo);
        if(this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            nuevo.setSig(this.primero);
            this.primero = nuevo;
        }
        this.cantidadNodos++;
    }

    @Override
    public void agregarAlFinal(int elementoNuevo) {
        NodoListaSimple nuevo = new NodoListaSimple(elementoNuevo);
        if(this.ultimo == null){
            this.ultimo = nuevo;
            this.primero = nuevo;
        } else {
            this.ultimo.setSig(nuevo);
            this.ultimo = nuevo;
        }
        this.cantidadNodos++;
    }

    @Override
    public int eliminarPrincipio() {
        NodoListaSimple aux = this.primero;
        if(this.primero.getSig() == null) {
            this.primero = null;
        } else {
            this.primero = this.primero.getSig();
        }
        this.cantidadNodos--;
        return aux.getDato();
    }

    @Override
    public int getLargo() {
        return this.cantidadNodos;
    }

    @Override
    public boolean estaVacia() {
        return this.cantidadNodos == 0;
    }

    @Override
    public int obtener(int indice) {
        return recorrerREC(this.primero, indice, 0);
    }

    public int recorrerREC(NodoListaSimple actual, int indice, int contador){
        if(contador == indice && actual != null) {
            return actual.getDato();
        } else {
            if(contador < indice && actual.getSig() != null) {
                return recorrerREC(actual.getSig(), indice, contador + 1);
            }
        }
        return 0;
    }
}
