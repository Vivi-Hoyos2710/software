import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        Scanner entrada= new Scanner(System.in);
        System.out.println("Dinos tu nombre: ");
        String nombre= entrada.nextLine();
        System.out.println("Dinos tu género: ");
        String genero= entrada.nextLine();
        System.out.println("Dinos tu edad: ");
        int edad= entrada.nextInt();
        System.out.println("Dinos tu nivel académico: ");
        String nivel= entrada.next(); //preguntar porqué ignora esta entrada (???)
        System.out.println("Dinos tu e-mail: ");
        String email= entrada.next();
        Usuario u= new Usuario(edad,nombre,email,nivel,genero);
        System.out.println("Selecciona tu opción: ");
        System.out.println("0. Salir del sistema");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar e-mail");
        System.out.println("3. Cambiar edad");
        System.out.println("4. Cambiar nivel acádemico ");
        System.out.println("5. Añadir gustos");
        System.out.println("6. Asignar actividad nueva");
        System.out.println("7. Completar actividad");
        System.out.println("8. Ver puntaje total");
        System.out.println("9. Revisar mi información");
        System.out.println("10. Mostrar actividades pendientes");
        int seleccion= entrada.nextInt();
        while(seleccion!=0){
            switch(seleccion){
                case 1:
                    System.out.println("Dinos tu nuevo nombre de usuario: ");
                    String nombreNuevo= entrada.next();
                    u.setNombre(nombreNuevo);
                break;
                case 2:
                    System.out.println("Dinos tu nuevo email: ");
                    String nuevoEmail= entrada.next();
                    u.setEmail(nuevoEmail);
                break;
                case 3:
                    System.out.println("Dinos tu nueva edad: ");
                    int nuevaEdad= entrada.nextInt();
                    u.setEdad(nuevaEdad);
                break;
                case 4:
                    System.out.println("Dinos tu nuevo nivel academico: ");
                    String nuevoNivel= entrada.next();
                    u.setNivelAcademico(nuevoNivel);
                break;
                case 5:
                    System.out.println("Dinos tu gusto (Puedes añadir más si selecciona nuevamente la opción): ");
                    String gusto= entrada.next();
                    u.añadirGustos(gusto);
                break;
                case 6:
                System.out.println("Indique el nombre de la actividad, la importancia (medida del 1 al 10), mes, día y hora ");
                String nombreActividad= entrada.next();
                int importancia= entrada.nextInt();
                int mes= entrada.nextInt()-1;
                int dia= entrada.nextInt()-1;
                int hora= entrada.nextInt();
                u.asignarActividad(nombreActividad,importancia,mes,dia,hora);
                break;
                case 7:
                System.out.println("¿Qué actividad deseas completar? ");
                String cambio=entrada.next();
                    for(int i=0; i<Horario.temporalidad.length;i++){
                        for(int j=0; j<Horario.temporalidad[i].length;j++){
                            for(int k=0; k<Horario.temporalidad[i][j].length;k++){
                                if((Horario.temporalidad[i][j][k]!=null)&&(Horario.temporalidad[i][j][k].getNombre().equalsIgnoreCase(cambio))){
                                    Horario.temporalidad[i][j][k].setEstado(true);
                                    int puntos=u.getPuntajeTotal()+Horario.temporalidad[i][j][k].getPuntuacion();
                                    u.setPuntajeTotal(puntos);
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("Tu puntaje total es: "+u.getPuntajeTotal());
                break;
                case 9:
                    System.out.println(u.revisarInformacion());
                break;
                case 10:
                    for(int i=0; i<Horario.temporalidad.length;i++){
                        for(int j=0; j<Horario.temporalidad[i].length;j++){
                            for(int k=0; k<Horario.temporalidad[i][j].length;k++){
                                if((Horario.temporalidad[i][j][k]!=null)&& (Horario.temporalidad[i][j][k].getEstado()==false)){
                                    System.out.println("Actividad: "+Horario.temporalidad[i][j][k].getNombre()+" Importancia: "+Horario.temporalidad[i][j][k].getImportancia()+" Programada para el mes: "+(i+1)+" día: "+(j+1)+" a la hora: "+k+"\n");
                                }
                            }
                        }
                    }
                break;
            }
                System.out.println("Selecciona tu opción: ");
                System.out.println("0. Salir del sistema");
                System.out.println("1. Cambiar nombre");
                System.out.println("2. Cambiar e-mail");
                System.out.println("3. Cambiar edad");
                System.out.println("4. Cambiar nivel acádemico ");
                System.out.println("5. Añadir gustos");
                System.out.println("6. Asignar actividad nueva");
                System.out.println("7. Completar actividad");
                System.out.println("8. Ver puntaje total");
                System.out.println("9. Revisar mi información");
                System.out.println("10. Mostrar actividades pendientes");
                seleccion= entrada.nextInt();
        }

    }
}