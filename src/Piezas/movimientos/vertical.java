package Piezas.movimientos;

import Piezas.Pieza;
import Piezas.Tipos.Bloqueo;

public interface vertical {
    default void espacioDisponible(Pieza[][]table,int posicionX , int posicionY, int limiteAbajo1,int limiteAbajo2,int limitederecha1,int limitederecha2, int limiteIzquierda, int limiteIzquierda2,int limiteArriba1,int limititeArriba2){
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
}
