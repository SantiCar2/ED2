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

    public void setContent(short c){ this.content = c;}

    public void llenar(){
        this.content = getCapacidad();
    }

    public void vaciar(){
        this.content = 0;
    }

    public void pasarContenido(Jarra j){
        if(j.getContent() > (getCapacidad()-getContent())){
            int newContent = j.getContent()-(getCapacidad()-getContent());
            j.setContent((short) newContent);
            llenar();
        }else{
            setContent(j.getContent());
            j.vaciar();
        }

    }

}
