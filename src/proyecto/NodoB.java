package proyecto;

public class NodoB {

    private Jarra jar1;
    private Jarra jar2;

    private short objetivo;

    private NodoB hijoIzq, hijoDer, padre;

    public NodoB(Nodo node) {
        // TODO: info del nodo
    }

    public NodoB(NodoB padre, NodoB hijoIzq, NodoB hijoDer) {
        this.padre=padre;
        this.hijoIzq=hijoIzq;
        this.hijoDer=hijoDer;
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

    public void setHijoIzq(NodoB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    public NodoB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoDer(NodoB hijoDer) {
        this.hijoDer = hijoDer;
    }
    public NodoB getHijoDer() {
        return hijoDer;
    }

    public NodoB getPadre() {
        return padre;
    }
    public void setPadre(NodoB padre) {
        this.padre = padre;
    }

    //    public void inOrder() {
//        if (left != null) {
//            left.inOrder();
//        }
//        System.out.print(e + " , ");
//        if (right != null) {
//            right.inOrder();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return e.toString();
//    }
}