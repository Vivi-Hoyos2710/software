public class Actividad {
    private String nombre;
    private int importancia;
    private boolean estado;
    private int puntuacion;

    public String getNombre(){
        return this.nombre;
    }
    public void setEstado(boolean e){
        this.estado=e;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public Actividad(){}
    public Actividad(String n,int i){
        this.nombre=n;
        this.importancia=i;
        this.puntuacion= i*5;
        this.setEstado(false);
    }
    public Actividad(String n){
        this.nombre=n;
    }
    public int getPuntuacion(){
        return this.puntuacion;
    }
    public int getImportancia(){
        return this.importancia;
    }
    


}
