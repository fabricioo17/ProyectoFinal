import Jugadores.Jugador;
import utillidades.*;
import Tablero.Tablero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int turno=1;
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();
        System.out.println("bienvenidoos");
        System.out.println("Antes de iniciar con el juego");
        System.out.println("me gustaria saber si ya estan registrados para guardar su informacion");
        System.out.println("iniciamos con el jugador " + turno );;
        System.out.println("1 ya tienes cuenta");
        System.out.println("2 no tienes cuenta");
        int opcion1=teclado.nextInt();
        switch (opcion1){
            case 1:
                System.out.println("ingrese su ID");
                String ID = teclado.next();
                if (JugadoresGuardados.verificarExistenciaJugador(ID)){
                    System.out.println(" bienvenido jugador: ");
                    JugadoresGuardados.mostrarDatosJugador(ID);
                }
                else {
                    System.out.println(" no existe un usuario con ese ID");
                }
                break;
    //----------------------------CREAR CUENTA---------------------------------//

            case 2:
                boolean salir= false;
              do {


                  System.out.println("Empezaremos a crear tu cuenta nueva");
                  System.out.println("quieres continuar?");
                  System.out.println("1 Si");
                  System.out.println("2 No");
                  int respuesta = teclado.nextInt();
                  if (respuesta == 1) {
                        Jugador jugadorNuevo= new Jugador(teclado);
                        JugadoresGuardados.añadirDatos(jugadorNuevo);
                        JugadoresGuardados.mostrarDatosJugador(jugadorNuevo.getId());
                      System.out.println("cuenta creada, por favor recordar ID");
                      salir=true;
                  }
                  else if (respuesta == 2) {
                        salir=true;
                  } else {
                      System.out.println("ingresa solo 1 o 2");
                  }
              }
              while (salir==false);
                break;


            default:
                System.out.println("error de opcion");
        }




    }
}