public class Horario {
    private int dias;
    private int mes;
    private int hora;
    public static Actividad[][][] temporalidad= new Actividad[12][][24];
    temporalidad[0][31];
    temporalidad[1][28];
    temporalidad[2][31];
    temporalidad[3][30];
    temporalidad[4][31];
    temporalidad[5][30];
    temporalidad[6][31];
    temporalidad[7][31];
    temporalidad[8][30];
    temporalidad[9][31];
    temporalidad[10][30];
    temporalidad[11][31];
    public Horario(int m, int d, int h){
        this.mes=m;
        this.dias=d;
        this.hora=h;
    }
}

