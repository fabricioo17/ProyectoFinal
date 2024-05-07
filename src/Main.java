import Tablero.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tablero nuevo = new Tablero();
      /*  System.out.println("bienvenidos ");
        System.out.println("jugador 1");
        Usuario jugador1  = new Usuario(teclado);
        System.out.println("jugador 2 :");
        Usuario jugador2= new Usuario(teclado);*/
        nuevo.Play(teclado);

    }
}