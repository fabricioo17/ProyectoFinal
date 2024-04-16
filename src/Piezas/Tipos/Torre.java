package Piezas.Tipos;

import Piezas.Pieza;
import Piezas.movimientos.Movimientos;

import java.util.Scanner;

public class Torre extends Pieza implements Movimientos {
    public Torre(Boolean blancas) {super(blancas);
    }
    public void imprimirTorre(){
        if (this.blancas) {
            System.out.print(red + "♖" + reset);
        }
        else {
            System.out.print(green + "♖" + reset);
        }
    }
    public  void movimientoTorre(Scanner teclado,Pieza [ ][] table) {
        System.out.println("ingrese a que fila quiere mover la torre");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
int opcionMovimiento=      movimientoTotalTorre(table,x,y,posicionX,posicionY);
    if (opcionMovimiento==0){
        System.out.println("pieza movida");
    } else if (opcionMovimiento==1) {
        System.out.println("pieza comida");

    }
else {
        System.out.println("error de movimiento");
    }
    }

    @Override
    public int movimientoTotalTorre(Pieza[][] table, int movimientoX, int movimientoY, int posicionX, int posicionY) {
        return Movimientos.super.movimientoTotalTorre(table, movimientoX, movimientoY, posicionX, posicionY);
    }


}
