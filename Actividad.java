public class Actividad {
    private String nombre;
    private int importancia;
    private boolean estado;
    private int puntuacion;
    private Horario horario;
    public void setEstado(boolean e){
        this.estado=e;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public Actividad(String n,int i,Horario h){
        this.nombre=n;
        this.importancia=i;
        this.horario=h;
        this.puntuacion= i*5;
    }
    public Actividad(String n,Horario h){
        this.nombre=n;
        this.horario=h;
    }
    


}
