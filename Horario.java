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
    /*public void graficarHorario(int mes){
        mes = mes -1;
        String[][] dias = new String[42][];
        int diaInicialMes = 0;
        int limiteActividades = 5;
        int limiteCaracteresActividad =18;
        for (int i = 0; i < diaInicialMes; i++) {
            dias[i]= obtenerRelleno(limiteActividades,limiteCaracteresActividad);
        }
        for (int i = diaInicialMes; i < temporalidad[mes].length; i++) {
            dias[i]=obtenerActividadesDia(temporalidad[mes][i],limiteActividades);
        }
        for (int i = temporalidad[mes].length; i < 42; i++) {
            dias[i]= obtenerRelleno(limiteActividades,limiteCaracteresActividad);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 42; i += 7) {
                for (int j = 0; j < limiteActividades; j++) {
                    System.out.println(dias[i][j]);
                    System.out.println("|"+formatString(dias[i][j],limiteCaracteresActividad)+"|"+formatString(dias[i+1][j],limiteCaracteresActividad)+"|"+formatString(dias[i+2][j],limiteCaracteresActividad)+"|"+formatString(dias[i+3][j],limiteCaracteresActividad)+"|"+formatString(dias[i+4][j],limiteCaracteresActividad)+"|"+formatString(dias[i+5][j],limiteCaracteresActividad)+"|"+formatString(dias[i+6][j],limiteCaracteresActividad)+"|");
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    //obtiene las primeras n actividades del dia
    public String[] obtenerActividadesDia(Actividad[] horas, int limiteActividades){
        
        String[] actividades = new String[limiteActividades];
        int actividadesEncontradas=0;
        for (int i = 0; i < 24; i++) {
            if (horas[i] != null) {
                actividades[actividadesEncontradas] = (i+1)+"."+horas[i].getNombre();
                actividadesEncontradas ++ ;
            }
            if(actividadesEncontradas==limiteActividades-1){
                break;
            }
        }
        //rellenando espacios en dias con pocas actividades
        int aux = actividadesEncontradas;
        for (int i = aux; i < limiteActividades; i++) {
            actividades[i]=" ";
        }
        return actividades;
    }

    //Formatea o rellena con espacios un string segun un numero de caracteres requerido
    public String formatString(String cadena, int limite){
        if(cadena.length()>limite){
            cadena = cadena.substring(0, limite-1);
        }
        else{
            int aux = cadena.length();
            for (int i = 0; i < limite-aux; i++) {
                cadena = cadena+" ";
            }
        }
        return cadena;
    }
    //rellena dias con *
    public String[] obtenerRelleno (int limiteActividades,int limiteCaracteresActividad){
        String[] dia = new String[limiteActividades];
        for (int i = 0; i < limiteActividades; i++) {
            String linea = "";
            for (int j = 0; j < limiteCaracteresActividad; j++) {
                linea = linea + "*";
            }
            dia[i]=linea;
        }
        return dia;
    }*/
}
