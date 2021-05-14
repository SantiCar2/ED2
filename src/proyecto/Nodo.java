package proyecto;

public class Nodo {

    private final Jarra jar1;
    private final Jarra jar2;

    private final short objetivo;

    private Nodo padre;
    private Nodo[] hijos;

    public Nodo(Jarra jar1, Jarra jar2, short objetivo) {
        this.jar1 = jar1;
        this.jar2 = jar2;
        this.objetivo = objetivo;
    }

    public Nodo(Jarra jar1, Jarra jar2, short objetivo, Nodo padre) {
        this.jar1 = jar1;
        this.jar2 = jar2;
        this.objetivo = objetivo;
        this.padre = padre;
    }

    public Jarra getJar1() {
        return jar1;
    }

    public Jarra getJar2() {
        return jar2;
    }

    public short getObjetivo() {
        return objetivo;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }
}
