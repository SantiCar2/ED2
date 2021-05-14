package proyecto;

public class Jarra {

    private final short capacidad;
    private short content;

    public Jarra(short capacidad) {
        this.capacidad = capacidad;
        this.content = 0;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public short getContent() {
        return content;
    }
}
