package Piezas.Tipos;

import Piezas.Pieza;
import Piezas.movimientosReutilizables.MovimientoHorizontalVertical;
import Tablero.Tablero;

import java.util.Scanner;

public class Torre extends Pieza implements MovimientoHorizontalVertical {
    public Torre(Boolean blancas, int posicionX, int posicionY) {super(blancas, posicionX,posicionY);
    }
    public void imprimirTorre(){

        if (this.roja) {
            System.out.print(red + "♖" + reset);
        }
        else {
            System.out.print(green + "♖" + reset);
        }
    }
    public int movimientoTorre(Scanner teclado, Tablero table) {

        System.out.println("ingrese a que fila quiere mover la torre");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
    int opcionMovimiento=      movimientoVertical(table,x,y,posicionX,posicionY);
    if (opcionMovimiento==0){
        System.out.println("pieza movida");
        return 0;
    }
    else if (opcionMovimiento==1) {
        System.out.println("pieza comida");
        return 0;
    }
    else if (opcionMovimiento==2){
        System.out.println("no puedes comer tu propia pieza");
        return 1;
        }
        else {
        System.out.println("movimiento invalido");
        return 1;
            }
    }


    @Override
    public boolean protegerRey(Tablero tablero, int posicionX, int posicionY, boolean blanco) {
        return false;
    }

    public String mostrarDatosTorre(){


        return toString() + ",Torre";
    }
}
