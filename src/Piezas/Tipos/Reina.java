package Piezas.Tipos;
import Piezas.Jugadores;
import Piezas.Pieza;

import java.util.Scanner;

public class Reina extends Pieza {
    public Reina(Jugadores propietario) {
        super(propietario);
    }



    public  void movimientoReina(Scanner teclado, Pieza[][ ]table) {
        System.out.println("ingrese a que fila quiere mover la reina");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
        if (table[x][y] instanceof Bloqueo || table[x][y] == table[posicionX][posicionY]) {
            System.out.println("movimiento invalido");
        } else if ((table[x][y] == null)) {
            table[x][y] = table[posicionX][posicionY];
            table[posicionX][posicionY] = null;

        } else if ((table[x][y] != null)) {// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
          table[posicionX][posicionY].comerHorizontalVertical(x,y,table);
            table[posicionX][posicionY].comerDiagonal(x,y,table);
        }
    }
















}
