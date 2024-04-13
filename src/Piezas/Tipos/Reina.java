package Piezas.Tipos;
import Piezas.Jugadores;
import Piezas.Pieza;
import Piezas.movimientos.Diagonal;
import Piezas.movimientos.Vertical;

import java.util.Scanner;

public class Reina extends Pieza implements Vertical, Diagonal {


    public Reina(Jugadores propietario) {
        super(propietario);
    }



    public  void movimientoReina(Scanner teclado, Pieza[][ ]table) {
        System.out.println("ingrese a que fila quiere mover la reina");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
        int opcion = movimientoTotalTorre(table,x,y,posicionX,posicionY);
        int opcion2=movimientoDiagonal(table,x,y,posicionX,posicionY);
        if (opcion==0){
            System.out.println("pieza movida");
        } else if (opcion==1) {
            System.out.println("pieza comida");

        }
        else {
            if (opcion2==0){
                System.out.println("pieza movida");
            }
            else if(opcion2==1){
                System.out.println("pieza comida");
            }
            else {
                System.out.println("movimiento invalido");
            }
        }
    }






    @Override
    public int movimientoTotalTorre(Pieza[][] table, int movimientoX, int movimientoY, int posicionX, int posicionY) {
        return Vertical.super.movimientoTotalTorre(table, movimientoX, movimientoY, posicionX, posicionY);
    }







}
