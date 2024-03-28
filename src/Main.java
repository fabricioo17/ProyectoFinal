import Piezas.Piezas;
import Piezas.Tipos.Peon;
import Tablero.Tablero;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
         Tablero nuevo = new Tablero();

         nuevo.StartTablero();
         nuevo.imprimirTablero();

nuevo.elegirMovimiento(teclado);
nuevo.imprimirTablero();
nuevo.elegirMovimiento(teclado);
nuevo.imprimirTablero();
    }
}