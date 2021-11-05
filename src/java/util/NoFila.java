
package util;


public class NoFila {
    private Vertice v1;
    private Vertice v2;
    private int valor;
    private NoFila prox;

    public NoFila(Vertice v1, Vertice v2,int valor) {
        this.v1 = v1;
        this.v2 = v2;
        this.valor=valor;
        this.prox = prox;
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
