package proyecto;

import java.util.ArrayList;

import static proyecto.JarraExceptions.*;


public class Nodo {

    private static boolean completo = false;
    private final String estado;
    private short objetivo;
    private Jarra jarra1;
    private Jarra jarra2;
    private Nodo padre;
    private final ArrayList<Nodo> hijos = new ArrayList<>();

    public Nodo(short objetivo, Jarra jarra1, Jarra jarra2, Nodo padre) {
        this.objetivo = objetivo;
        this.jarra1 = jarra1;
        this.jarra2 = jarra2;
        this.padre = padre;

        this.estado = "(" + jarra1.getContent() + ", " + jarra2.getContent() + ")";
        //Agregar estado a la lista de casos analizados

    }

    //TODO VERIFICAR OPERACIONES YA HECHAS

    public boolean VerificarOperaciones(String op, Jarra A, Jarra B) throws JarraVaciaE, JarraLlenaE {
        if (A.getContent() == objetivo && B.getContent() == objetivo) completo = true;
        if (!completo) {
            switch (op) {
                case "vaciarA":
                    String temp = "(" + 0 + ", " + B.getContent() + ")";
                    if (A.getContent() > 0) { //A la condicion agregar verificacion de casos analizados
                        return true;
                    } else {
                        throw new JarraVaciaE();
                    }
                case "vaciarB":
                    String temp1 = "(" + A.getContent() + ", " + 0 + ")";
                    if (B.getContent() > 0) { //A la condicion agregar verificacion de casos analizados
                        return true;
                    } else {
                        throw new JarraVaciaE();
                    }
                case "llenaA":
                    String temp2 = "(" + A.getCapacidad() + ", " + B.getContent() + ")";
                    if (A.getContent() != A.getCapacidad()) { //A la condicion agregar verificacion de casos analizados
                        return true;
                    } else {
                        throw new JarraLlenaE();
                    }
                case "llenarB":
                    String temp3 = "(" + A.getContent() + ", " + B.getCapacidad() + ")";
                    if (B.getContent() != B.getCapacidad()) { //A la condicion agregar verificacion de casos analizados
                        B.setContent(B.getCapacidad());
                    } else {
                        throw new JarraLlenaE();
                    }
                    break;
                case "AtoB":
                    int t = A.getContent() - (B.getCapacidad() - B.getContent());
                    int t2; if(A.getContent() + B.getContent() > B.getCapacidad()) t2 = B.getCapacidad(); else t2 = A.getContent() + B.getContent();
                    String temp4 = "(" + t + ", " + t2 + ")";
                    return A.getContent() != 0 && B.getContent() != B.getCapacidad(); //A la condicion agregar verificacion de casos analizados
                case "BtoA":
                    int t0 = B.getContent() - (A.getCapacidad() - A.getContent());
                    int t02; if(B.getContent() + A.getContent() > A.getCapacidad()) t02 = A.getCapacidad(); else t02 = B.getContent() + A.getContent();
                    String temp5 = "(" + t0 + ", " + t02 + ")";
                    return B.getContent() != 0 && A.getContent() != A.getCapacidad(); //A la condicion agregar verificacion de casos analizados

            }
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

    public String getEstado() {
        return this.estado;
    }

    public static boolean isCompleto() {
        return completo;
    }
}