package proyecto;
import java.util.ArrayList;
public class Nodo {

    private short objetivo;
    private Jarra jarra1;
    private Jarra jarra2;
    private Nodo padre;
    ArrayList<Nodo> hijos = new ArrayList<>();
    public Jarra getJar1() {
        return jarra1;
    }
    public void setJar1(Jarra jar1) {
        this.jarra1 = jar1;
    }

    public Jarra getJar2() {
        return jarra2;
    }
    public void setJar2(Jarra jar2) {
        this.jarra2 = jar2;
    }

    public short getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(short objetivo) {
        this.objetivo = objetivo;
    }

    public boolean VerificarOperaciones (String op, Jarra A, Jarra B) throws JarraVaciaE, JarraLlenaE {
        switch(op)
        {
            case "vaciarA":
                if(A.getContent()>0){
                    return true;
                }
                else{
                    throw new JarraVaciaE();
                }
            case "vaciarB":
                if(B.getContent()>0){
                    return true;
                }
                else{
                    throw new JarraVaciaE();
                }
            case "llenaA":
                if(A.getContent()!=A.getCapacidad()){
                   return true;
                }
                else{
                    throw new JarraLlenaE();
                }
            case "llenarB":
                if(B.getContent()!=B.getCapacidad()){
                    B.setContent(B.getCapacidad());
                }
                else{
                    throw new JarraLlenaE();
                }
                break;
            case "AtoB":
                if(A.getContent()!=0&&B.getContent()!=B.getCapacidad()){
                    return true;
                }
                else{
                    return false;
                }
            case "BtoA":
                if(B.getContent()!=0&&A.getContent()!=A.getCapacidad()){
                    return true;
                }
                else{
                    return false;
                }

        }
        return false;


    }

}