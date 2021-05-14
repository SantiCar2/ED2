package proyecto;

public class NodoB {

    private final Jarra jar1;
    private final Jarra jar2;

    private final short objetivo;

    private NodoB padre;
    private NodoB nodoDerecha;
    private NodoB nodoIzquierda;

    public NodoB(Jarra jar1, Jarra jar2, short objetivo) {
        this.jar1 = jar1;
        this.jar2 = jar2;
        this.objetivo = objetivo;
    }
}
