package Piezas.Tipos;

import Piezas.Piezas;

import java.util.Scanner;

public class Torre extends Piezas {

private Jugadores jugador;

    public Torre(Jugadores jugador) {
        this.jugador=jugador;
    }




    public void casillasDisponibles(Piezas [][] table,int posicionX, int posicionY){
        for (int i =posicionY+1; i<8;i++)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
            }
            else {break;}
        }
        //a la izquierda
        for (int i =posicionY-1; i>=0;i--)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
            }
            else {break;}
        }


        //hacia arriba
        for (int i =posicionX-1; i>=0;i--)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
            }
            else {break;}

        }

        //hacia abajo
        for (int i =posicionX+1; i<8;i++)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
            }
            else {break;}
        }
    }

    public void movimientoTorres(Scanner teclado, int posicionX, int posicionY,Piezas [][] table){
        System.out.println("ingrese a que fila quiere mover la torre");
        int x = teclado.nextInt();
        System.out.println("ingrese la columna");
        int y = teclado.nextInt();
     this.bloquearespacios(table);
       casillasDisponibles(table,posicionX,posicionY);
        if(table[x-1][y-1]instanceof Bloqueo || table [x-1][y-1]==table[posicionX][posicionY]){
            System.out.println("movimiento invalido");
        }

        else if ((table[x-1][y-1] ==null)){// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
            table[x-1][y-1]=table[posicionX][posicionY];
          this.liberarEspacios(table);
            table[posicionX][posicionY]=null;

        }
        else if ((posicionX==x-1 || posicionY==y-1)&&!(table[x-1][y-1] instanceof Bloqueo)){
            table[x-1][y-1]=table[posicionX][posicionY];
            table[posicionX][posicionY]=null;
            table[posicionX][posicionY].liberarEspacios(table);
        }


    }




}
