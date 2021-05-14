package proyecto;

public class Jarra {

    private final short capacidad;
    private short contentido;

    public Jarra(short capacidad) {
        this.capacidad = capacidad;
        this.contentido = 0;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public short getContentido() {
        return contentido;
    }
}
