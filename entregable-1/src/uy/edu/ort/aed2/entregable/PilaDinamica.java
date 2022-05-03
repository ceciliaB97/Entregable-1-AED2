package uy.edu.ort.aed2.entregable;

class NodoPilaDinamica {
    private int dato;
    private NodoPilaDinamica anterior;

    public NodoPilaDinamica(int dato) {
        this.dato = dato;
        this.anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoPilaDinamica getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPilaDinamica anterior) {
        this.anterior = anterior;
    }
}

public class PilaDinamica implements Pila {
    private NodoPilaDinamica ultimo;
    private NodoPilaDinamica primero;
    private int cantidadNodos;

    @Override
    public void push(int valor) {
        NodoPilaDinamica nuevo = new NodoPilaDinamica(valor);
        if (this.ultimo == null) {
            this.ultimo = nuevo;
        } else {
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
        }
        this.cantidadNodos++;

    }

    @Override
    public int pop() {
        NodoPilaDinamica aux = this.ultimo;
        this.ultimo = aux.getAnterior();
        this.cantidadNodos--;
        return aux.getDato();
    }

    @Override
    public int top() {
        return this.ultimo.getDato();
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
    public boolean estaLlena() {
        return false;
    }
}
