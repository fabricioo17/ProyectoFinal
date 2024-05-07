package Tablero;


import Piezas.Pieza;
import Piezas.Tipos.*;

import java.util.Scanner;

public class Tablero {
    private Pieza[][] table;

    public Tablero()
    {
        table = new Pieza[8][8];
    }

    public Pieza[][] getTable() {
        return table;
    }

    public void setTable(Pieza[][] table) {
        this.table = table;
    }



    public  void  Play(Scanner teclado){


        int contador =0;
        startTablero();
        int salir1  ;
        int salir2;
      do {
          imprimirTablero();
          salir1=jugarPlayer1(teclado);


          imprimirTablero();

          salir2=jugarPlayer2(teclado);

      }
      while (salir1!=1 && salir2!=1);
      }

    public void  startTablero(){
        table[0][0] = new Torre(true,0,0) ;
        table[0][1]=new Caballo(true,0,1);
        table[0][2]=new Alfil(true);
        table[0][3] = new Rey(true,0,3) ;
        table[0][4]=new Reina(true);
        table[0][5]=new Alfil(true);
        table[0][6]=new Caballo(true,0,6);
        table[0][7] = new Torre(true,0,7) ;
/*
        for (int i =1;i<2;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(true,i,j);
            }
        }
        table[1][7]= new  Peon(false,1,7);


        for (int i =2;i<6;i++){
            for (int j=0; j<8;j++){
                table[i][j]=null;
            }
        }


        for (int i =6;i<7;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(false,i,j);
            }
        }
*/

        table[7][0] = new Torre(false,7,0) ;
        table[7][1]=new Caballo(false,7,1);
        table[7][2]=new Alfil(false);
        table[7][3] = new Rey(false,7,3) ;
        table[7][4]=new Reina(false);
        table[7][5]=new Alfil(false);
        table[7][6]=new Caballo(false,7,6);
        table[7][7] = new Torre(false,7,7) ;

    }






    public void imprimirTablero(){
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("     " + (i + 1) + "     ");
        }
        System.out.println();
        dibujarLineas();
        diferenciarContenidoTablero();
    }


    public void diferenciarContenidoTablero(){

        for (int i = 0; i < table.length; i++) {
            System.out.print((i + 1) + "  ┃");
            for (int j = 0; j < 8; j++) {
                if (table[i][j]==null){
                    System.out.print("    " + " " + "    "); // cantidad de rayas por numero es 3
                    System.out.print("  ┃");
                }
                if(table[i][j] instanceof Peon){
                    System.out.print( "    ");
                    ((Peon) table[i][j]).imprimirPeon();
                    System.out.print("    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Rey){
                    System.out.print("    " +"♔"+ "    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Reina){
                    System.out.print("    " +"♕"+ "    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Caballo){
                    System.out.print("    " );
                    ((Caballo) table[i][j]).imprimirCaballo();
                    System.out.print("    ");
                    System.out.print(" ┃");
                }
                else if (table [i][j]instanceof  Torre){
                    System.out.print("    ");
                    ((Torre) table[i][j]).imprimirTorre();
                    System.out.print("    " );
                    System.out.print(" ┃");
                }
                else if (table [i][j]instanceof  Alfil){
                    System.out.print("    ");
                    ((Alfil) table[i][j]).imprimirAlfil();
                    System.out.print("    " );
                    System.out.print(" ┃");
                }
            }
            System.out.println();
            dibujarLineas();
        }
    }






    public int  jugarPlayer1(Scanner teclado) {
        int num;
        if (obtenerPiezaReyBlanco(true).jaqueMateSinMovimientos(this, true)) {
            System.out.println("gano jugador 2  ");
            return 1;
        }
       /* if (obtenerPiezaReyBlanco(true).jaqueMateRodeadoPiezas(this,true)){
            System.out.println("gana jugador 2 ");
            return 1;
        }*/

        else {
            boolean correcto = false;
            do {
                System.out.println(" jugador 1 ");// blancas
                System.out.println("ingrese las coordenadas de la pieza");
        int posicionX = teclado.nextInt() - 1;
                int posicionY = teclado.nextInt() - 1;
                if (table[posicionX][posicionY] == null) {
                    System.out.print(" no hay pieza elegida  "); // cantidad de rayas por numero es 3
                    System.out.println("vuelva a ingresar las coordenadas");

                }
                else {

                    if (!table[posicionX][posicionY].isBlancas()) {
                        System.out.println(" esa pieza no es tuya");
                    } else {

                        if (table[posicionX][posicionY] instanceof Peon) {
                            table[posicionX][posicionY].setPosicionX(posicionX);
                            table[posicionX][posicionY].setPosicionY(posicionY);
                           num= ((Peon) table[posicionX][posicionY]).movimientoPeon(teclado, this);
                            if (num == 0) {
                                correcto = true;
                            }
                        } else if (table[posicionX][posicionY] instanceof Rey) {
                            num = ((Rey) table[posicionX][posicionY]).movimientoRey(teclado,this);
                            if (num == 0) {
                                correcto = true;
                            }

                        } else if (table[posicionX][posicionY] instanceof Reina) {
                            table[posicionX][posicionY].setPosicionX(posicionX);
                            table[posicionX][posicionY].setPosicionY(posicionY);
                            num = ((Reina) table[posicionX][posicionY]).movimientoReina(teclado, this);
                            if (num == 0) {
                                correcto = true;
                            }
                        } else if (table[posicionX][posicionY] instanceof Caballo) {
                            num =  ((Caballo) table[posicionX][posicionY]).movimientoCaballo(teclado,this);
                            if (num == 0) {
                                correcto = true;
                            }
                        } else if (table[posicionX][posicionY] instanceof Torre) {

                             num = ((Torre) table[posicionX][posicionY]).movimientoTorre(teclado, this);

                            if (num == 0) {
                                correcto = true;
                            }
                        } else if (table[posicionX][posicionY] instanceof Alfil) {
                            table[posicionX][posicionY].setPosicionX(posicionX);
                            table[posicionX][posicionY].setPosicionY(posicionY);
                            num =   ((Alfil) table[posicionX][posicionY]).movimientoAlfil(teclado, this);
                            if (num == 0) {
                                correcto = true;
                            }
                        }
                    }
                }
            }
            while (correcto == false);
        }
            return 0;
    }



    public int jugarPlayer2(Scanner teclado){
        boolean correcto= false;
        int num;
        if (obtenerPiezaReyBlanco(false).jaqueMateSinMovimientos(this, false)) {
            System.out.println("gano jugador 2  ");
            return 1;
        }
        else {
            do {
                System.out.println(" jugador 2 ");
                System.out.println("ingrese las coordenadas de la pieza");
                int posicionX = teclado.nextInt() - 1;
                int posicionY = teclado.nextInt() - 1;
                if (table[posicionX][posicionY] == null) {
                    System.out.print(" no hay pieza elegida  "); // cantidad de rayas por numero es 3
                    System.out.println("vuelva a ingresar las coordenadas");

                }
                else {

                    if (table[posicionX][posicionY] instanceof Peon) {
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        num= ((Peon) table[posicionX][posicionY]).movimientoPeon(teclado, this);
                        if (num == 0) {
                            correcto = true;
                        }
                    } else if (table[posicionX][posicionY] instanceof Rey) {
                        num = ((Rey) table[posicionX][posicionY]).movimientoRey(teclado,this);
                        if (num == 0) {
                            correcto = true;
                        }

                    } else if (table[posicionX][posicionY] instanceof Reina) {
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        num = ((Reina) table[posicionX][posicionY]).movimientoReina(teclado, this);
                        if (num == 0) {
                            correcto = true;
                        }
                    } else if (table[posicionX][posicionY] instanceof Caballo) {
                        num =  ((Caballo) table[posicionX][posicionY]).movimientoCaballo(teclado,this);
                        if (num == 0) {
                            correcto = true;
                        }
                    } else if (table[posicionX][posicionY] instanceof Torre) {

                        num = ((Torre) table[posicionX][posicionY]).movimientoTorre(teclado, this);

                        if (num == 0) {
                            correcto = true;
                        }
                    } else if (table[posicionX][posicionY] instanceof Alfil) {
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        num =   ((Alfil) table[posicionX][posicionY]).movimientoAlfil(teclado, this);
                        if (num == 0) {
                            correcto = true;
                        }
                    }
                }
            }
            while (correcto == false);
        }
        return 0;
        }






public Pieza obtenerPieza(int posicionX, int posicionY){

         return table[posicionX][posicionY];
}

public Rey obtenerPiezaReyBlanco(Boolean blanco){
        for (int i = 0 ; i< 8;i++){
            for (int j =0; j<8;j++){
                if (table[i][j] instanceof  Rey  && table[i][j].isBlancas()== blanco){
                    return (Rey) table[i][j];
                }

            }
    }
        return null;
}







    public void dibujarLineas() {
        int n = ((12) + ((7) * 11));//table.length es 10
        System.out.print("    ");
        for (int k = 1; k <= n; k++) {
            System.out.print("─");
        }
        System.out.println();
    }





}
