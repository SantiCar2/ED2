package proyecto;

public class NodoB {

    private Jarra jar1;
    private Jarra jar2;

    private short objetivo;

    private NodoB hijoIzq, hijoDer;

    public NodoB(Nodo node) {
        this.jar1 = node.getJarra1();
        this.jar2 = node.getJarra2();
        this.objetivo = node.getObjetivo();

    }

    public Jarra getJar1() {
        return jar1;
    }

    public void setJar1(Jarra jar1) {
        this.jar1 = jar1;
    }

    public Jarra getJar2() {
        return jar2;
    }

    public void setJar2(Jarra jar2) {
        this.jar2 = jar2;
    }

    public short getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(short objetivo) {
        this.objetivo = objetivo;
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