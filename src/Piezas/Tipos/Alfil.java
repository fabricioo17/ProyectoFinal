package Piezas.Tipos;

import Piezas.Pieza;
import Piezas.movimientos.Movimientos;
import java.util.Scanner;

public class Alfil extends Pieza  implements Movimientos {

    public Alfil(boolean blancas) {
        super(blancas);
    }


    @Override
    public int movimientoDiagonal(Pieza[][] table, int movimientoX, int movimientoY, int posicionX, int posicionY) {
        return Movimientos.super.movimientoDiagonal(table, movimientoX, movimientoY, posicionX, posicionY);
    }


    public  void movimientoAlfil(Scanner teclado, Pieza [][] table) {
        System.out.println("ingrese a que fila quiere mover el alfil");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;

int opcion=  movimientoDiagonal(table,x,y,posicionX,posicionY);

    if (opcion==0){
        System.out.println("pieza movida");
    } else if (opcion==1) {
        System.out.println("pieza comida");
    }
    else {
        System.out.println(" error de movimiento");
    }
    }


    public void imprimirAlfil(){
        if (this.blancas) {
            System.out.print(red + "♗" + reset);
        }
        else {
            System.out.print(green + "♗" + reset);
        }
    }



}