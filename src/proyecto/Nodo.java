package proyecto;

import java.util.ArrayList;

import static proyecto.JarraExceptions.*;


public class Nodo {

    private short objetivo;
    private Jarra jarra1;
    private Jarra jarra2;
    private Nodo padre;
    private final ArrayList<Nodo> hijos = new ArrayList<>();


    public boolean VerificarOperaciones(String op, Jarra A, Jarra B) throws JarraVaciaE, JarraLlenaE {
        switch (op) {
            case "vaciarA":
                if (A.getContent() > 0) {
                    return true;
                } else {
                    throw new JarraVaciaE();
                }
            case "vaciarB":
                if (B.getContent() > 0) {
                    return true;
                } else {
                    throw new JarraVaciaE();
                }
            case "llenaA":
                if (A.getContent() != A.getCapacidad()) {
                    return true;
                } else {
                    throw new JarraLlenaE();
                }
            case "llenarB":
                if (B.getContent() != B.getCapacidad()) {
                    B.setContent(B.getCapacidad());
                } else {
                    throw new JarraLlenaE();
                }
                break;
            case "AtoB":
                return A.getContent() != 0 && B.getContent() != B.getCapacidad();
            case "BtoA":
                return B.getContent() != 0 && A.getContent() != A.getCapacidad();

        }
        return false;
    }

    public short getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(short objetivo) {
        this.objetivo = objetivo;
    }

    public Jarra getJarra1() {
        return jarra1;
    }

    public void setJarra1(Jarra jarra1) {
        this.jarra1 = jarra1;
    }

    public Jarra getJarra2() {
        return jarra2;
    }

    public void setJarra2(Jarra jarra2) {
        this.jarra2 = jarra2;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
}