package proyecto.oldVer;

public class Arbol {

    private Nodo raiz;
    private final short objetivo;

    public Arbol(Nodo root, short objetivo) {
        this.raiz = root;
        this.objetivo = objetivo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public short getObjetivo() {
        return objetivo;
    }
}
