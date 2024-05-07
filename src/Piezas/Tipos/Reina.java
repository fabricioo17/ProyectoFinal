package Piezas.Tipos;
import Piezas.Pieza;
import Piezas.movimientosReutilizables.MovimientoDiagonal;
import Piezas.movimientosReutilizables.MovimientoHorizontalVertical;
import Tablero.Tablero;

import java.util.Scanner;

public class Reina extends Pieza implements MovimientoDiagonal, MovimientoHorizontalVertical {


    public Reina(Boolean blancas) {
        super(blancas);
    }


    public int movimientoReina(Scanner teclado, Tablero table) {
        System.out.println("ingrese a que fila quiere mover la reina");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
        int opcion = movimientoVertical(table, x, y, posicionX, posicionY);
        int opcion2 = movimientoDiagonal(table, x, y, posicionX, posicionY);
        if (opcion == 0) {
            System.out.println("pieza movida");
            return 0;
        } else if (opcion == 1) {
            System.out.println("pieza comida");
            return 0;

        } else if (opcion==3 && opcion2==3) {
            System.out.println("movimiento invalido");
            return 1;
        } else {
            if (opcion2 == 0) {
                System.out.println("pieza movida");
                return 0;
            } else if (opcion2 == 1) {
                System.out.println("pieza comida");
                return 0;
            } else {
                System.out.println("movimiento invalido");
                return 1;
            }
        }
    }
}
