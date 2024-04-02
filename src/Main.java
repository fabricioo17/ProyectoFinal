import Tablero.Tablero;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
         Tablero nuevo = new Tablero();
int i =0;
         nuevo.StartTablero();
         nuevo.imprimirTablero();
do {
    nuevo.elegirPieza(teclado);
    nuevo.imprimirTablero();
    nuevo.elegirPieza(teclado);
    nuevo.imprimirTablero();
i++;
}
while (i<10);
    }
}