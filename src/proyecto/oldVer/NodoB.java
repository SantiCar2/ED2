package proyecto.oldVer;

public class NodoB {

    private String estado;

    private NodoB hijoIzq, hijoDer;

    public NodoB(Nodo node) {
        this.estado = node.getEstado();
    }

    @Override
    public String toString() {
        return estado;
    }

    public NodoB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoB hijoDer) {
        this.hijoDer = hijoDer;
    }
}