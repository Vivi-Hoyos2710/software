public class Horario {
    public static Actividad[][][] temporalidad= new Actividad[12][][];

    public Horario(){
        temporalidad[0]= new Actividad[31][24];
        temporalidad[1]= new Actividad[28][24];
        temporalidad[2]= new Actividad[31][24];
        temporalidad[3]= new Actividad[30][24];
        temporalidad[4]= new Actividad[31][24];
        temporalidad[5]= new Actividad[30][24];
        temporalidad[6]= new Actividad[31][24];
        temporalidad[7]= new Actividad[31][24];
        temporalidad[8]= new Actividad[30][24];
        temporalidad[9]= new Actividad[31][24];
        temporalidad[10]= new Actividad[30][24];
        temporalidad[11]= new Actividad[31][24];
    }
}

