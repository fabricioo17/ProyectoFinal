package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

public class Alfil extends Pieza {
    protected  int limitederecha1=0;

    protected  int limitederecha2=0;
    protected int limiteArriba1 =0;
    protected int limititeArriba2=0;
    protected   int limiteAbajo1=0;

    protected   int limiteAbajo2=0;
    protected   int limiteIzquierda=0;
    protected   int limiteIzquierda2=0;
    public Alfil(Jugadores propietario) {
        super(propietario);
    }

    public  void espaciosDisponibleAlfil(Pieza[][]table){
        //hacia abajo derecha
        for (int i=posicionX+1,j=posicionY+1;i<8 & j<8;i++,j++){
                if (table[i][j] instanceof Bloqueo) {
                    table[i][j] = null;
                                   if(i==7){
                                       limiteAbajo1=i;
                                       limitederecha1=j;
                                   }
                                   if (j==7) {
                                       limitederecha1=j;
                                       limiteAbajo1=i;
                                   }

                }
                else {
                   limiteAbajo1 = i;
                   limitederecha1=j;
                    break;
                }
        }

        //hacia abajo izquierda
        for (int i=posicionX+1,j=posicionY-1;i<8 & j>=0;i++,j--){
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;
                if(i==7){
                    limiteAbajo2=i;
                    limiteIzquierda=j;
                }
                if (j==0) {
                    limiteAbajo2=i;
                    limiteIzquierda=j;
                }

            }
            else {
                limiteAbajo2=i;
                limiteIzquierda=j;
                break;
            }
        }



        //hacia arriba derecha
        for (int i=posicionX-1,j=posicionY+1;i>=0 & j<8;i--,j++){
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;

                if(i==0){
                    limiteArriba1 =i;
                    limitederecha2=j;
                }
                if (j==7) {
                    limitederecha2=j;
                    limiteArriba1=i;
                }
            }
            else {
               limiteArriba1=i;
               limitederecha2=j;
                break;
            }
        }

        //hacia arriba izquierda
        for (int i=posicionX-1,j=posicionY-1;i>=0 & j>=0;i--,j--){
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;
                if(i==0){
                    limititeArriba2=i;
                    limiteIzquierda2=j;
                }
                if (j==0) {
                    limiteIzquierda2=j;
                    limititeArriba2=i;
                }
            }
            else {
               limititeArriba2 = i;
               limiteIzquierda2=j;
                break;
            }
        }


    }

    public void comerPiezaAlfil(int movimientoX, int movimientoY, Pieza[][]table) {
        if (table[posicionX][posicionY].getPropietario() != table[movimientoX][movimientoY].getPropietario()) {
            if (posicionX != movimientoX && posicionY != movimientoY){
            if (posicionX + 1 == movimientoX || posicionY + 1 == movimientoY && posicionX - 1 == movimientoX || posicionY - 1 == movimientoY) {
                if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
//si la pieza que come esta en el cuadrante de arriba a la izquieda
                    if (movimientoX >= limititeArriba2 && movimientoY >= limiteIzquierda2) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                    }
                    //cuadrante de arriba a la derecha
                    else if (movimientoX >= limiteArriba1 && movimientoY <= limitederecha2) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                    }
                    // abajo derecha
                    else if (movimientoX <= limiteAbajo1 && movimientoY <= limitederecha1) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                    } else if (movimientoX <= limiteAbajo2 && movimientoY >= limiteIzquierda) {
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
