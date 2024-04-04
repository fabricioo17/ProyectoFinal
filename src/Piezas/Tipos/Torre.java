package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

public class Torre extends Pieza {
    protected  int limitegeneral=0;
    protected int limititeArriba=0;
    protected   int limiteAbajo=0;

    protected   int limiteIzquierda=0;
    public Torre(Jugadores propietario) {
        super(propietario);
    }

    public  void espaciosDisponibles(Pieza[][]table){
        //hacia la derecha
        for (int i =posicionY+1; i<8;i++) {
            if (table[posicionX][i] instanceof Bloqueo) {
                table[posicionX][i] = null;
                    if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                       limitegeneral = 7;
                    }
            } else {
               // en los casos anteriores se iniciaba a 1 el limite de derecha porque al moverla pieza hacia abajo  no se actualizaba el limitederecha ya que se iba hasata la columna 7 entonces no ingresaba y se actualizaba con la i
                   limitegeneral = i;
                break;
            }
        }

       /* if (super.limitegeneral ==0){
           super.limitegeneral =7;
        }*/

        //a la izquierda
        for (int i =posicionY-1; i>=0;i--)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
                if (i == 0) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                   limiteIzquierda = 0;
                }
            }
            else {limiteIzquierda=i;
                break;}
        }


        //hacia arriba
        for (int i =posicionX-1; i>=0;i--)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 0) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limititeArriba = 0;
                }
            }
            else {limititeArriba=i;
                break;}

        }


        //hacia abajo
        for (int i =posicionX+1; i<8;i++)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteAbajo = 7;
                }
            }
            else {limiteAbajo=i; // 
                break;}
        }
    }


    /**
     *
     * @param movimientoX es la variable que indica en que fila queremos mover la pieza
     * @param movimientoY es la variable que indica en que columna queremos mover la pieza
     * @param table necesitamos llamar al array para identificar el valor de cada elemento del array
     */
    public void comerPiezaTorre(int movimientoX, int movimientoY, Pieza[][]table){
       if (table[posicionX][posicionY].getPropietario()!=table[movimientoX][movimientoY].getPropietario()) {
           if (posicionX == movimientoX || posicionY == movimientoY) {
               if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
                   if (movimientoX >= limititeArriba && movimientoX <= limiteAbajo) { // el limite de arriba debe ser comparado con el movimiento X, ya que para saber en que fila (recta horizontal) estamos contamos de arriba hacia abajo por eso el minomo es el limite de arriba ya que empieza en 0 y el limeteabajo es mayor osea 7
                       if (movimientoY <= limitegeneral && movimientoY >= limiteIzquierda) {
                           table[movimientoX][movimientoY] = table[posicionX][posicionY];
                           table[posicionX][posicionY] = null;
                       }
                   }


               }
           }
       }
       else {
           System.out.println("no puedes comer una pieza propia");
       }

    }




}
