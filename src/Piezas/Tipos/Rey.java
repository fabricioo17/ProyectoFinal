package Piezas.Tipos;

import Piezas.Pieza;
import Piezas.movimientosReutilizables.jacke;
import Tablero.Tablero;

import java.util.Scanner;

public class Rey extends Pieza implements jacke {

    public Rey(Boolean blancas, int posicionX, int y) {
        super(blancas, posicionX, y);
    }


    public int movimientoRey(Scanner teclado, Tablero tablero) {
        System.out.println("ingrese a que fila quiere mover el rey ");
        int x = teclado.nextInt()-1;
        System.out.println("ingresa la columna");
        int y = teclado.nextInt()-1;
            int opcion=    verificarMovimiento(tablero,x,y);

            if ( opcion==0){
                System.out.println("pieza movida");
                return 0;
            }
            else if (opcion==1){
                System.out.println("pieza comida");
                return 0;
            }
            else if (opcion==2){
                System.out.println("no puedes comer tu propia pieza");
                return 1;
            }
            else  {
                System.out.println(" error movimiento");
                return 1;
            }

        //verificarMovimiento(tablero, x, y);


    }

   public int verificarMovimiento(Tablero tablero, int movimientoX, int movimientoY) {// si devuelve  no se puede mover ahi
       int posicionOriginalX = posicionX;
       int posicionOriginalY = posicionY;
       Pieza piezaComida;
       Pieza[][] table = tablero.getTable();

       //-------------horizontal---------------------//
           if (movimientoX == posicionX) {
               if (movimientoY == posicionY - 1 || movimientoY == posicionY + 1) {
                   if (table[movimientoX][movimientoY]== null) {
                      cambiarPosicion(tablero,movimientoX,movimientoY);
                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                               return 3;
                           }
                       }


                       return 0; // pieza movida
                   }
                   ///-------------comer pieza---------------------//
                    else {
                       if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                           piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                           table[movimientoX][movimientoY] = table[posicionX][posicionY];
                           table[posicionX][posicionY] = null;
                           table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                           table[movimientoX][movimientoY].setPosicionY(movimientoY);
                           if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                               if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento
                                   return 3;
                               }
                           }
                           return 1; // pieza comida
                       }

                   }



               }
           }


           //----------------vertical-------------------------------
           else if (posicionY == movimientoY) {
               if (movimientoX == posicionX - 1 || movimientoX == posicionX + 1) {
                   if (table[movimientoX][movimientoY] == null) {
                      cambiarPosicion(tablero,movimientoX,movimientoY);

                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                               return 3;
                           }
                       }

                       return 0;
                   }
                   else {
                       if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                           piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                           table[movimientoX][movimientoY] = table[posicionX][posicionY];
                           table[posicionX][posicionY] = null;
                           table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                           table[movimientoX][movimientoY].setPosicionY(movimientoY);
                           if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                               if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                                   return 3;
                               }
                           }

                           return 1; // pieza comida
                       }
                   }

               }
           }
//-------------------------------------------------------------------------------------------------------------/


           //----------------------------------diagonal arriba derecha------------------------------------//
           else if (posicionX - 1 == movimientoX && posicionY + 1 == movimientoY) {
               if (table[movimientoX][movimientoY] == null) {
                   cambiarPosicion(tablero,movimientoX,movimientoY);

                   if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                       if (table[movimientoX][movimientoY].regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                           return 3;
                       }
                   }

                   return 0;
               }
               else {
                   if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                       piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                       table[movimientoX][movimientoY] = table[posicionX][posicionY];
                       table[posicionX][posicionY] = null;
                       table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                       table[movimientoX][movimientoY].setPosicionY(movimientoY);
                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                               return 3;
                           }
                       }

                       return 1; // pieza comida
                   }
               }
           }

           //----------------------------------------------------------------------------------------------//


           //-----------------------------diagonal arriba izquierda---------------------------------------------------//
           else if (posicionX - 1 == movimientoX && posicionY - 1 == movimientoY) {
               if (table[movimientoX][movimientoY] == null) {
                   cambiarPosicion(tablero,movimientoX,movimientoY);

                   if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                       if (table[movimientoX][movimientoY].regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                           return 3;
                       }
                   }

                   return 0;
               }
               else {
                   if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                       piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                       table[movimientoX][movimientoY] = table[posicionX][posicionY];
                       table[posicionX][posicionY] = null;
                       table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                       table[movimientoX][movimientoY].setPosicionY(movimientoY);
                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                               return 3;
                           }
                       }

                       return 1; // pieza comida
                   }
               }
           }
           //----------------------------------------------------------------------------------------------//


           //--------------------------diagonal abajo derecha--------------------------------------------------------//
           else if (posicionX + 1 == movimientoX && posicionY + 1 == movimientoY) {
               if (table[movimientoX][movimientoY] == null) {
                   cambiarPosicion(tablero,movimientoX,movimientoY);

                   if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                       if (table[movimientoX][movimientoY].regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                           return 3;
                       }
                   }

                   return 0;
               }
               else {
                   if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                       piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                       table[movimientoX][movimientoY] = table[posicionX][posicionY];
                       table[posicionX][posicionY] = null;
                       table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                       table[movimientoX][movimientoY].setPosicionY(movimientoY);
                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                               return 3;
                           }
                       }

                       return 1; // pieza comida
                   }
               }
           }
           //----------------------------------------------------------------------------------------------//


           //----------------------------diagonal abajo izquierda------------------------------------------------//
           else if (posicionX + 1 == movimientoX && posicionY - 1 == movimientoY) {
               if (table[movimientoX][movimientoY] == null) {
                   cambiarPosicion(tablero,movimientoX,movimientoY);

                   if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                       if (table[movimientoX][movimientoY].regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY)) {// si el valor es verdadero  habremos anulado el movimiento
                           return 3;
                       }
                   }

                   return 0;
               }
               else {
                   if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                       piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                       table[movimientoX][movimientoY] = table[posicionX][posicionY];
                       table[posicionX][posicionY] = null;
                       table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                       table[movimientoX][movimientoY].setPosicionY(movimientoY);
                       if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                           if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                               return 3;
                           }
                       }

                       return 1; // pieza comida
                   }
               }
           }

       return  3;
   }

/*

    public boolean jackeMate(){
        Pieza  [][] table= tablero.getTable();
        Rey rey= (Rey) tablero.obtenerPiezaReyBlanco(blanco);
        int posicionReyX= rey.getPosicionX();
        int posicionReyY=rey.getPosicionY();
        //hacia arriba
        for (int i=posicionReyX-1;i>=0;i--) {
            if ((table[i][posicionReyY] instanceof Torre || table[i][posicionReyY] instanceof Reina)) {
                if (table[i][posicionReyY].isBlancas()!=table[posicionReyX][posicionReyY].isBlancas()){// si el color de la torre en la recta vertical es diferente al  color del rey devuelve un true
                    return true;
                }

                else {
                    break;
                }
            }
            else if (table[i][posicionReyY] instanceof Pieza && table[i][posicionReyY].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }

        }


        // hacia abajo
        for (int i=posicionReyX+1;i<8;i++){
            if (table[i][posicionReyY] instanceof Torre || table[i][posicionReyY] instanceof Reina){
                if (table[i][posicionReyY].isBlancas()!=table[posicionReyX][posicionReyY].isBlancas()){
                    return true;
                }
                else {
                    break;
                }
            }
            else if (table[i][posicionReyY] instanceof Pieza && table[i][posicionReyY].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }
        }




        //hacia la derecha
        for (int i=posicionReyY+1;i<8;i++){
            if (table[posicionReyX][i] instanceof Torre || table[posicionReyX][i] instanceof Reina) {
                if (table[posicionReyX][i].isBlancas()!=table[posicionReyX][posicionReyY].isBlancas()){
                    return true;
                }


                else {
                    break;
                }
            }

            else if (table[posicionReyX][i] instanceof Pieza && table[posicionReyX][i].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){

                break;
            }
        }


        //hacia la izquierda
        for (int i=posicionReyY-1;i>=0;i--){
            if (table[posicionReyX][i] instanceof Torre || table[posicionReyX][i] instanceof Reina) {
                if (table[posicionReyX][i].isBlancas()!=table[posicionReyX][posicionReyY].isBlancas()){
                    return true;
                }
                else {
                    break;
                }
            }

            else if (table[posicionReyX][i] instanceof Pieza && table[posicionReyX][i].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){

                break;
            }
        }





        //------------------------diagonal----------------------------------------------//
        for (int i = posicionReyX-1, j = posicionReyY-1  ; i >=0 && j >=0; i--,j--) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil) {

                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
            else if (table[i][j] instanceof Pieza && table[i][j].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }




        }

        //arriba a la derecha
        for (int i = posicionReyX-1, j = posicionReyY+1  ; i >=0 && j <8; i--,j++) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }

            }
            else if (table[i][j] instanceof Pieza && table[i][j].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }
        }



        //abajo a la izquierda

        for (int i = posicionReyX+1, j = posicionReyY-1  ; i <8 && j >=0; i++,j--) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
            else if (table[i][j] instanceof Pieza && table[i][j].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }
        }




        for (int i = posicionReyX+1, j = posicionReyY+1  ; i <8 && j <8; i++,j++) {
            //abajo derecha
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
            else if (table[i][j] instanceof Pieza && table[i][j].isBlancas()==table[posicionReyX][posicionReyY].isBlancas()){
                break;
            }

        }


        //------------------------------------------------------------------------------------//






//----------------------------evitar caballo-----------------------//


        // hacia arriba derecha
        if (posicionReyX-2>=0 && posicionReyY + 1<=7) {// por si al querer identificar el caballo en un lugar que este fuera del tablero usamos un if
            if (table[posicionReyX - 2][posicionReyY + 1] instanceof Caballo) {
                if (table[posicionReyX - 2][posicionReyY + 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


        //arriba izquierda
        if (posicionReyX-2>=0 && posicionReyY - 1>=0) {
            if (table[posicionReyX - 2][posicionReyY - 1] instanceof Caballo) {
                if (table[posicionReyX - 2][posicionReyY - 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }





// derecha arriba
        if (posicionReyX-1>=0 && posicionReyY + 2<=7) {
            if (table[posicionReyX - 1][posicionReyY + 2] instanceof Caballo) {
                if (table[posicionReyX - 1][posicionReyY + 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


        //derecha abajo
        if (posicionReyX+1<=7 && posicionReyY + 2<=7) {
            if (table[posicionReyX + 1][posicionReyY + 2] instanceof Caballo) {
                if (table[posicionReyX + 1][posicionReyY + 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }




        //abajo derecha
        if (posicionReyX+2<=7 && posicionReyY + 1<=7) {
            if (table[posicionReyX + 2][posicionReyY + 1] instanceof Caballo) {
                if (table[posicionReyX + 2][posicionReyY + 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//abajo izquierda
        if (posicionReyX+2<=7 && posicionReyY - 1>=0) {
            if (table[posicionReyX + 2][posicionReyY - 1] instanceof Caballo) {
                if (table[posicionReyX + 2][posicionReyY - 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }

        }



// izquierda arriba
        if (posicionReyX-1>=0 && posicionReyY - 2>=0) {
            if (table[posicionReyX - 1][posicionReyY - 2] instanceof Caballo) {
                if (table[posicionReyX - 1][posicionReyY - 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//izquierda abajo
        if (posicionReyX+1<=7 && posicionReyY -2>=0) {
            if (table[posicionReyX + 1][posicionReyY - 2] instanceof Caballo) {
                if (table[posicionReyX + 1][posicionReyY - 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//---------------------------------------------------------------------------------------------------------------------//



        return false;





    }
    */

    public int jaqueMateRodeado(Tablero tablero, Boolean blanco){ // devuelve los limites de la pieza
        int contador = 0;
        int posicionOriginalX= posicionX;
        int posicionOriginalY=posicionY;
        Pieza rey=this;
        Pieza comida;
        Pieza [][ ]table = tablero.getTable();
        int movimientoX;
        int movimientoY;
        //limite arriba//
        if(posicionX-1 <0){
            contador++;
        }
        // limite abajo//
        if(posicionX+1>7){
            contador++;
        }
        //limite izquierda
        if (posicionY-1<0){
            contador++;
        }

        //limite derecha
        if (posicionY+1>7){
            contador++;
        }

        // limite aariba izquierda
        if (table[posicionX-1][posicionY-1] instanceof  Pieza){

        }




        return contador;
    }
  public  boolean jaqueMateSinMovimientos(Tablero tablero, Boolean blanco) {
      int contador = 0;
      int posicionOriginalX= posicionX;
      int posicionOriginalY=posicionY;
      Pieza rey=this;
      Pieza comida;
    Pieza [][ ]table = tablero.getTable();
int movimientoX;
int movimientoY;

          // movimiento arriba
      if (posicionX-1 >=0) {
          if (table[posicionX - 1][posicionY] == null) {
              movimientoX = posicionX - 1;
              movimientoY = posicionY;
              table[posicionX - 1][posicionY] = table[posicionX][posicionY];// al confirmar que se puede mover a esa posicion,
              //igualamos el contenido de la ubicacion orignal de la pieza al nuevo lugar
              table[posicionX][posicionY] = null; // la ubicacion original la dejamos en nulo
              table[movimientoX][movimientoY].setPosicionX(movimientoX);
              table[movimientoX][movimientoY].setPosicionY(movimientoY);
              if ((identificarJacke(tablero, blanco, posicionX, posicionY) == true)) {// ahora posicionX = a movimientoX
                  contador++;
              }
              regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
//hacer un if y un else if donde if sera que si el espacio donde se podria mover es nulo y veremos si añade 1 al contador
              // el else if es para si puede comer una pieza y se comprobara si añade mas uno al contador
          }
          else {
              if (table[posicionX - 1][posicionY].isBlancas() != this.blancas && !(table[posicionX - 1][posicionY] instanceof Rey)) {
                  movimientoX = posicionX - 1;
                  movimientoY = posicionY;
                  comida = tablero.obtenerPieza(posicionX - 1, posicionY);

                  table[posicionX - 1][posicionY] = table[posicionX][posicionY];
                  table[posicionX][posicionY] = null;
                  table[movimientoX][movimientoY].setPosicionX(movimientoX);
                  table[movimientoX][movimientoY].setPosicionY(movimientoY);

                  if ((identificarJacke(tablero, blanco, posicionX, posicionY) == true)) { // la posicion en esta pieza de rey ya cambio y ahora es la poisicion original-1
                      contador++;
                  }
                  regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);
              }
          }
      }
      else {
          contador++;
      }

                //---------------------------abajo---------------------//
      if (posicionX+1<=7) {
          if (table[posicionX + 1][posicionY] == null) {
              movimientoX = posicionX + 1;
              movimientoY = posicionY;
              table[posicionX + 1][posicionY] = table[posicionX][posicionY];
              table[posicionX][posicionY] = null; // la ubicacion original la dejamos en nulo
              table[movimientoX][movimientoY].setPosicionX(movimientoX);
              table[movimientoX][movimientoY].setPosicionY(movimientoY);
              // abajo

              if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                  contador++;
              }
              regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
          } else {
              if (table[posicionX + 1][posicionY].isBlancas() != this.blancas && !(table[posicionX + 1][posicionY] instanceof Rey)) {
                  movimientoX = posicionX + 1;
                  movimientoY = posicionY;
                  comida = tablero.obtenerPieza(posicionX + 1, posicionY);
                  table[posicionX + 1][posicionY] = table[posicionX][posicionY];
                  table[posicionX][posicionY] = null;
                  table[movimientoX][movimientoY].setPosicionX(movimientoX);
                  table[movimientoX][movimientoY].setPosicionY(movimientoY);

                  if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                      contador++;
                  }
                  regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

              }

          }
      }
      else {
          contador++;
      }

          //----------------------izquierda-----------------------------------//
        if (posicionY-1>=0) {
            if (table[posicionX][posicionY - 1] == null) {
                movimientoX = posicionX;
                movimientoY = posicionY - 1;
                table[posicionX][posicionY - 1] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX);
                table[movimientoX][movimientoY].setPosicionY(movimientoY);

                //izquierda
                if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                    contador++;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX][posicionY - 1].isBlancas() != this.blancas && !(table[posicionX][posicionY - 1] instanceof Rey)) {
                    movimientoX = posicionX;
                    movimientoY = posicionY - 1;
                    comida = tablero.obtenerPieza(posicionX, posicionY - 1);
                    table[posicionX][posicionY - 1] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX);
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);

                    if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                        contador++;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

                }
            }
        }
        else {
            contador++;
        }


          //-----------------derecha------------------------------------------//
      if (posicionY+1<=7) {
          if (table[posicionX][posicionY + 1] == null) {
              // derecha
              movimientoX = posicionX;
              movimientoY = posicionY + 1;
              table[posicionX][posicionY + 1] = table[posicionX][posicionY];
              table[posicionX][posicionY] = null;
              table[movimientoX][movimientoY].setPosicionX(movimientoX);
              table[movimientoX][movimientoY].setPosicionY(movimientoY);

              if (identificarJacke(tablero, blanco, posicionX, posicionY )) {
                  contador++;
              }
              regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

          } else {
              if (table[posicionX][posicionY + 1].isBlancas() != this.blancas && !(table[posicionX][posicionY + 1] instanceof Rey)) {
                  movimientoX = posicionX;
                  movimientoY = posicionY + 1;
                  comida = tablero.obtenerPieza(posicionX, posicionY + 1);
                  table[posicionX][posicionY + 1] = table[posicionX][posicionY];
                  table[posicionX][posicionY] = null;
                  table[movimientoX][movimientoY].setPosicionX(movimientoX);
                  table[movimientoX][movimientoY].setPosicionY(movimientoY);

                  if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                      contador++;
                  }
                  regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

              }

          }

      }
      else {
          contador++;
      }

          // -------------------------------------------arriba derecha --------------------------------------------------/
        if (posicionX-1>=0 && posicionY-1<=7) {

            if (table[posicionX - 1][posicionY + 1] == null) {
                // diagonal arriba derecha
                movimientoX = posicionX - 1;
                movimientoY = posicionY + 1;
                table[posicionX - 1][posicionY + 1] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX);
                table[movimientoX][movimientoY].setPosicionY(movimientoY);

                if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                    contador++;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

            } else {
                if (table[posicionX - 1][posicionY + 1].isBlancas() != this.blancas && !(table[posicionX - 1][posicionY + 1] instanceof Rey)) {
                    movimientoX = posicionX - 1;
                    movimientoY = posicionY + 1;
                    comida = tablero.obtenerPieza(posicionX - 1, posicionY + 1);
                    table[posicionX - 1][posicionY + 1] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX);
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);

                    if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                        contador++;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

                }

            }

        }
        else {
            contador++;
        }
          //------------arriba izquierda----------------------------------------------------------------------------//
          if (posicionX-1>=0 && posicionY-1>=0) {
              if (table[posicionX - 1][posicionY - 1] == null) {
                  // diagonal arriba izquierda
                  movimientoX = posicionX - 1;
                  movimientoY = posicionY - 1;
                  table[posicionX - 1][posicionY - 1] = table[posicionX][posicionY];
                  table[posicionX][posicionY] = null;
                  table[movimientoX][movimientoY].setPosicionX(movimientoX);
                  table[movimientoX][movimientoY].setPosicionY(movimientoY);

                  if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                      contador++;
                  }
                  regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

              } else {
                  if (table[posicionX - 1][posicionY - 1].isBlancas() != this.blancas && !(table[posicionX - 1][posicionY - 1] instanceof Rey)) {
                      movimientoX = posicionX - 1;
                      movimientoY = posicionY - 1;
                      comida = tablero.obtenerPieza(posicionX - 1, posicionY - 1);
                      table[posicionX - 1][posicionY - 1] = table[posicionX][posicionY];
                      table[posicionX][posicionY] = null;
                      table[movimientoX][movimientoY].setPosicionX(movimientoX);
                      table[movimientoX][movimientoY].setPosicionY(movimientoY);

                      if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                          contador++;
                      }
                      regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

                  }
              }
          }
          else {
              contador++;
          }
          //------------------------------------abajo derecha--------------------------------//

         if (posicionX+1<=7 && posicionY +1<=7) {
             if (table[posicionX + 1][posicionY + 1] == null) {
                 // diagonal abajo derecha
                 movimientoX = posicionX + 1;
                 movimientoY = posicionY + 1;
                 table[posicionX + 1][posicionY + 1] = table[posicionX][posicionY];
                 table[posicionX][posicionY] = null;
                 table[movimientoX][movimientoY].setPosicionX(movimientoX);
                 table[movimientoX][movimientoY].setPosicionY(movimientoY);

                 if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                     contador++;
                 }
                 regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

             } else {
                 if (table[posicionX + 1][posicionY + 1].isBlancas() != this.blancas && !(table[posicionX + 1][posicionY + 1] instanceof Rey)) {
                     movimientoX = posicionX + 1;
                     movimientoY = posicionY + 1;
                     comida = tablero.obtenerPieza(posicionX + 1, posicionY + 1);
                     table[posicionX + 1][posicionY + 1] = table[posicionX][posicionY];
                     table[posicionX][posicionY] = null;
                     table[movimientoX][movimientoY].setPosicionX(movimientoX);
                     table[movimientoX][movimientoY].setPosicionY(movimientoY);

                     if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                         contador++;
                     }
                     regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

                 }

             }
         }
         else {
             contador++;
         }

            //-------------------abajo izquierda-------------------------------//
         if (posicionX +1 <=7 && posicionY -1 >=0) {

             if (table[posicionX + 1][posicionY - 1] == null) {
                 // diagonal abajo izquierda
                 movimientoX = posicionX + 1;
                 movimientoY = posicionY - 1;
                 table[posicionX + 1][posicionY - 1] = table[posicionX][posicionY];
                 table[posicionX][posicionY] = null;
                 table[movimientoX][movimientoY].setPosicionX(movimientoX);
                 table[movimientoX][movimientoY].setPosicionY(movimientoY);

                 if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                     contador++;
                 }
                 regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

             } else {
                 if (table[posicionX + 1][posicionY - 1].isBlancas() != this.blancas && !(table[posicionX + 1][posicionY - 1] instanceof Rey)) {
                     movimientoX = posicionX + 1;
                     movimientoY = posicionY - 1;
                     comida = tablero.obtenerPieza(posicionX + 1, posicionY - 1);
                     table[posicionX + 1][posicionY - 1] = table[posicionX][posicionY];
                     table[posicionX][posicionY] = null;
                     table[movimientoX][movimientoY].setPosicionX(movimientoX);
                     table[movimientoX][movimientoY].setPosicionY(movimientoY);

                     if (identificarJacke(tablero, blanco, posicionX, posicionY)) {
                         contador++;
                     }
                     regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, comida);

                 }
             }
         }
         else {
             contador++;
         }

                    if (contador == 8) {
                        return true;
                    }


      return false;
  }

/*public  boolean  jaqueMateRodeadoPiezas (Tablero tablero, Boolean blanco){
    int posicionOriginalX= posicionX;
    int posicionOriginalY=posicionY;
    Pieza rey=this;
    Pieza comida;
    Pieza [][ ]table = tablero.getTable();
    int movimientoX;
    int movimientoY;
    //------------------espacio libre arriba-------------------//
      if (table[posicionX-1][posicionY] == null ){// arriba vacio
          if (table[posicionX-1][posicionY-1].isBlancas()==blanco){//izquierda arriba
              if (table[posicionX-1][posicionY+1].isBlancas()==blanco){ // izquierda derecha
                  if (table[posicionX][posicionY+1].isBlancas()==blanco){ // derecha
                      if (table[posicionX+1][posicionY+1].isBlancas()==blanco){  // derecha abajo
                          if (table[posicionX+1][posicionY-1].isBlancas()==blanco){ // izquieeda abajo
                              if (table[posicionX][posicionY-1].isBlancas()==blanco){ // izquierda
                                  if (table[posicionX+1][posicionY].isBlancas()==blanco){// abajo
                                      for (int i = posicionX-1; i>=0; i--){
                                          if (table[i][posicionY] instanceof Torre || table[i][posicionY] instanceof Reina ){
                                                    return true;
                                          }
                                          else if (table[i][posicionY] instanceof  Pieza) {
                                                return false;
                                          }

                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
          }

      //----------------------------espacio libre abajo------------------//
    if (table[posicionX+1][posicionY] == null ){// arriba vacio
        if (table[posicionX-1][posicionY-1].isBlancas()==blanco){//izquierda arriba
            if (table[posicionX-1][posicionY+1].isBlancas()==blanco){ // izquierda derecha
                if (table[posicionX][posicionY+1].isBlancas()==blanco){ // derecha
                    if (table[posicionX+1][posicionY+1].isBlancas()==blanco){  // derecha abajo
                        if (table[posicionX+1][posicionY-1].isBlancas()==blanco){ // izquieeda abajo
                            if (table[posicionX][posicionY-1].isBlancas()==blanco){ // izquierda
                                if (table[posicionX-1][posicionY].isBlancas()==blanco){// arriba
                                    for (int i = posicionX+1; i<=7;i++){
                                        if (table[i][posicionY] instanceof Torre || table[i][posicionY] instanceof Reina ){
                                            return true;
                                        }
                                        else if (table[i][posicionY] instanceof Pieza){
                                            return false;
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }




    //----------------- espacio libre derecha ------------------------------//
    if (table[posicionX][posicionY+1] == null ){// derecha vacio
        if (table[posicionX-1][posicionY-1].isBlancas()==blanco){//izquierda arriba
            if (table[posicionX-1][posicionY+1].isBlancas()==blanco){ // izquierda derecha
                if (table[posicionX+1][posicionY].isBlancas()==blanco){ //  abajo
                    if (table[posicionX+1][posicionY+1].isBlancas()==blanco){  // derecha abajo
                        if (table[posicionX+1][posicionY-1].isBlancas()==blanco){ // izquieeda abajo
                            if (table[posicionX-1][posicionY].isBlancas()==blanco){ // izquierda
                                if (table[posicionX-1][posicionY].isBlancas()==blanco){// arriba
                                    for (int i = posicionY+1; i<=7;i++){
                                        if (table[posicionX][i] instanceof Torre || table[posicionX][i] instanceof Reina ){
                                            return true;
                                        }
                                        else if (table[posicionX][i] instanceof Pieza){
                                            return false;
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }























    //----------------- espacio libre izquierda ------------------------------//
    if (table[posicionX][posicionY-1] == null ){// derecha vacio
        if (table[posicionX-1][posicionY-1].isBlancas()==blanco){//izquierda arriba
            if (table[posicionX-1][posicionY+1].isBlancas()==blanco){ // izquierda derecha
                if (table[posicionX+1][posicionY].isBlancas()==blanco){ //  abajo
                    if (table[posicionX+1][posicionY+1].isBlancas()==blanco){  // derecha abajo
                        if (table[posicionX+1][posicionY-1].isBlancas()==blanco){ // izquieeda abajo
                            if (table[posicionX][posicionY].isBlancas()==blanco){ //
                                if (table[posicionX-1][posicionY].isBlancas()==blanco){// arriba
                                    for (int i = posicionY+1; i<=7;i++){
                                        if (table[posicionX][i] instanceof Torre || table[posicionX][i] instanceof Reina ){
                                            return true;
                                        }
                                        else if (table[posicionX][i] instanceof Pieza){
                                            return false;
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    return false;
      }


*/

//--------------------espacio abajo
public int  comerRey(Tablero tablero, int movimientoX,int movimientoY) {
    int posicionOriginalX = posicionX;
    int posicionOriginalY = posicionY;
    Pieza piezaComida;
    Pieza[][] table = tablero.getTable();
    //horizontal
    if (table[movimientoX][movimientoY] != null) {
        if (movimientoX == posicionX) {
            if (movimientoY == posicionY - 1 || movimientoY == posicionY + 1) {
                if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                    piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);
                    if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                        if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                            return 3;

                        }
                    }
                } else {
                    return 2;
                }
            }
        }


        //----------------vertical-------------------------------
        else if (posicionY == movimientoY) {
            if (movimientoX == posicionX - 1 || movimientoX == posicionX + 1) {
                if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                    piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);
                    if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                        if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                            return 3;

                        }
                    }
                }
                else {
                    return 2;
                }
            }
        }
//-------------------------------------------------------------------------------------------------------------/


        //----------------------------------diagonal arriba derecha------------------------------------//

        else if (posicionX -1== movimientoX && posicionY+1==movimientoY) {
            if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                table[movimientoX][movimientoY].setPosicionY(movimientoY);
                if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                    if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                        return 3;

                    }
                }
            }
            else {
                return 2;
            }
        }

        //----------------------------------------------------------------------------------------------//


        //-----------------------------diagonal arriba izquierda---------------------------------------------------//
        else if (posicionX -1== movimientoX && posicionY+1==movimientoY) {
            if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                table[movimientoX][movimientoY].setPosicionY(movimientoY);
                if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                    if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                        return 3;

                    }
                }
            }
            else {
                return 2;
            }
        }
        //----------------------------------------------------------------------------------------------//



        //--------------------------diagonal abajo derecha--------------------------------------------------------//
        else if (posicionX -1== movimientoX && posicionY+1==movimientoY) {
            if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                table[movimientoX][movimientoY].setPosicionY(movimientoY);
                if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                    if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                        return 3;

                    }
                }
            }
            else {
                return 2;
            }
        }
        //----------------------------------------------------------------------------------------------//




        //----------------------------diagonal abajo izquierda------------------------------------------------//
        else if (posicionX -1== movimientoX && posicionY+1==movimientoY) {
            if (table[movimientoX][movimientoY].isBlancas() != this.blancas) {
                piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                table[posicionX][posicionY] = null;
                table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                table[movimientoX][movimientoY].setPosicionY(movimientoY);
                if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), movimientoX, movimientoY)) {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                    if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                        return 3;

                    }
                }
            }
            else {
                return 2;
            }
        }

    }


























    else {
        return 3;
    }
    return 3;
}


}



