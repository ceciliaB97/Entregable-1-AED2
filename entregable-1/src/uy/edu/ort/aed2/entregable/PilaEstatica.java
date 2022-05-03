package uy.edu.ort.aed2.entregable;

public class PilaEstatica implements Pila {
    private int[] vector;
    private int cantElentosVector;
    private int ultimaPosicion;

    public PilaEstatica(int cantidadMaximaElementos) {
        this.vector = new int[cantidadMaximaElementos];
        this.cantElentosVector = 0;
        this.ultimaPosicion = -1;
    }

    @Override
    public void push(int valor) {
        if(this.ultimaPosicion == -1) {
            this.vector[this.ultimaPosicion + 1] = valor;
        } else {
            if(this.ultimaPosicion < this.vector.length) {
                this.vector[this.ultimaPosicion + 1] = valor;
            }
        }
        this.ultimaPosicion++;
        this.cantElentosVector++;
    }

    @Override
    public int pop() {
        int aux = this.vector[ultimaPosicion];
        this.vector[ultimaPosicion] = 0;
        this.ultimaPosicion --;
        this.cantElentosVector--;
        return aux;
    }

    @Override
    public int top() {
        return this.vector[ultimaPosicion];
    }

    @Override
    public int getLargo() {
        return this.cantElentosVector;
    }

    @Override
    public boolean estaVacia() {
        return this.cantElentosVector == 0;
    }

    @Override
    public boolean estaLlena() {
        return this.cantElentosVector == this.vector.length;
    }
}
