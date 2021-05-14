package proyecto;

public class Arbol {

    private Nodo root;
    private final short objetivo;

    public Arbol(Nodo root, short objetivo) {
        this.root = root;
        this.objetivo = objetivo;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public short getObjetivo() {
        return objetivo;
    }
}
