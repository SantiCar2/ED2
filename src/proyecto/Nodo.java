package proyecto;

public class Nodo {

    private short objetivo;
    private Jarra jarra1;
    private Jarra jarra2;
    private Nodo padre;
    ArrayList<Nodo> hijos = new ArrayList<>();
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

    public boolean VerificarOperaciones (String op, Jarra A, Jarra B) throws JarraVaciaE, JarraLlenaE {
        switch(op)
        {
            case "vaciarA":
                if(A.getContent()>0){
                    return true;
                }
                else{
                    throw new JarraVaciaE();
                    return false;
                }
            case "vaciarB":
                if(B.getContent()>0){
                    return true;
                }
                else{
                    throw new JarraVaciaE();
                    return false;
                }
            case "llenaA":
                if(A.getContent()!=A.getCapacidad()){
                   return true;
                }
                else{
                    throw new JarraLlenaE();
                    return false;
                }
            case "llenarB":
                if(B.getContent()!=B.getCapacidad()){
                    B.setContent(B.getCapacidad());
                }
                else{
                    throw new JarraLlenaE();
                    return false;
                }
            case "AtoB":
                if(A.getContent()!=0&&B.getContent()!=B.getCapacidad()){
                    return true;
                }
                else{

                }
            case "BtoA":
                if(B.getContent()!=0&&A.getContent()!=A.getCapacidad()){
                    return true;
                }
                else{

                }
        }

    }

}