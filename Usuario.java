import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String genero;
    private int edad;
    private ArrayList<String> gustos = new ArrayList<String>();
    private String email;
    private int ranking;
    private int puntaje_total;
    private String nivel_academico;

    public Usuario() {
    }

    public Usuario(int e, String n, String m, String a, String g) {
        this.edad = e;
        this.nombre = n;
        this.email = m;
        this.nivel_academico = a;
        this.genero = g;
        Horario t = new Horario();
    }

    // setters//
    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setNivelAcademico(String n) {
        this.nivel_academico = n;
    }

    public void setRanking(int r) {
        this.ranking = r;
    }

    public void setPuntajeTotal(int n) {
        this.puntaje_total = n;
    }

    public void setEdad(int n) {
        this.edad = n;
    }

    // getters//
    public String getNombre() {
        return this.nombre;
    }

    public String getNivelAcademico() {
        return this.nivel_academico;
    }

    public int getRanking() {
        return this.ranking;
    }

    public int getPuntajeTotal() {
        return this.puntaje_total;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getEmail() {
        return this.email;
    }

    // Metodos//
    public void añadirGustos(String g) {
        gustos.add(g);
    }

    public void asignarActividad(String n, int i,int m, int d, int h) {
        
        Actividad a = new Actividad(n, i);

        if (Horario.temporalidad[m][d][h]==null) {
            Horario.temporalidad[m][d][h] = a;
        }
    }

    public String revisarInformacion() {
        String info = "Nombre: " + this.nombre + "\n" + "Edad: " + this.edad + "\n" + "Género: " + this.genero + "\n"
                + "E-mail: " + this.email + "\n" + "Nivel Academico: " + this.nivel_academico + "\n" + "Puntaje Total: "
                + this.puntaje_total + "\n" + "Ranking: " + this.ranking + "\n" + "Gustos: ";
        for (int i = 0; i < this.gustos.size(); i++) {
            info += this.gustos.get(i) + " ";
        }
        return info;
    }

}