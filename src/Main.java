import Jugadores.Jugador;
import utillidades.*;
import Tablero.Tablero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        Tablero tablero = new Tablero();
         tablero.startTablero();
        System.out.println("bienvenidoos");
        System.out.println("jugador 1 ingrese sus datos ");
         Jugador jugador1= new Jugador(teclado,true);
        System.out.println("jugador 2 ingrese sus datos ");
        Jugador jugador2= new Jugador(teclado,false);
        tablero.play(teclado);
        System.out.println("gracias por jugar");



      tablero.playGuardada(teclado);
    }

}