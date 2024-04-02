package Piezas.Tipos;

import Piezas.Piezas;

public class Torre extends Piezas {
    private int posicionX;
    private  int posicionY;
    private int limititeArriba;
    private  int limiteAbajo;
    private int limiteDerecha;
    private  int limiteIzquierda;

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }


    public  void espaciosDisponibles(Piezas[][]table){
        for (int i =posicionY+1; i<8;i++)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
            }

            else { limiteDerecha=i;break;}
        }
        if (limiteDerecha==0){
            limiteDerecha=7;
        }

        //a la izquierda
        for (int i =posicionY-1; i>=0;i--)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
            }
            else {limiteIzquierda=i;
                break;}
        }


        //hacia arriba
        for (int i =posicionX-1; i>=0;i--)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
            }
            else {limititeArriba=i;
                break;}

        }


        //hacia abajo
        for (int i =posicionX+1; i<8;i++)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
            }
            else {limiteAbajo=i; // 
                break;}
        }
                if (limiteAbajo==0){
                    limiteAbajo=7;
                }
    }


    /**
     *
     * @param movimientoX es la variable que indica en que fila queremos mover la pieza
     * @param movimientoY es la variable que indica en que columna queremos mover la pieza
     * @param table necesitamos llamar al array para identificar el valor de cada elemento del array
     */
    public void comerPiezaTorre(int movimientoX, int movimientoY, Piezas [][]table){
        if (posicionX==movimientoX || posicionY==movimientoY){
            if (table[movimientoX][movimientoY] instanceof Piezas && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
                if (movimientoX >= limititeArriba && movimientoX <= limiteAbajo) { // el limite de arriba debe ser comparado con el movimiento X, ya que para saber en que fila (recta horizontal) estamos contamos de arriba hacia abajo por eso el minomo es el limite de arriba ya que empieza en 0 y el limeteabajo es mayor osea 7
                    if (movimientoY <= limiteDerecha && movimientoY >= limiteIzquierda) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                    }
                }


            }
        }

    }




}
