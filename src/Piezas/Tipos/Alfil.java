package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

import java.util.Scanner;

public class Alfil extends Pieza  {

    public Alfil(Jugadores propietario) {
        super(propietario);
    }


    public  void movimientoAlfil(Scanner teclado,Pieza [][] table) {
        System.out.println("ingrese a que fila quiere mover el alfil");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;

        //espacios disponibles//
        table[posicionX][posicionY].espaciosDiagonal(table);


        if (table[x][y] instanceof Bloqueo || table[x][y] == table[posicionX][posicionY]) {
            System.out.println("movimiento invalido");
        } else if ((table[x][y] == null)) {
            table[x][y] = table[posicionX][posicionY];
            table[posicionX][posicionY] = null;

        } else if ((table[x][y] != null)) {// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
            table[posicionX][posicionY].comerDiagonal(x, y, table);

        }
    }


    public void imprimirAlfil(){
        if (this.propietario==Jugadores.jugador1) {
            System.out.print(red + "♗" + reset);
        }
        else {
            System.out.print(green + "♗" + reset);
        }
    }



}