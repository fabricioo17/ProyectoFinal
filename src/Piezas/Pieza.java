package Piezas;

public abstract  class Pieza {
    protected boolean blancas;
    protected int posicionX;
    protected int posicionY;

    protected final String red = "\u001B[31m";
    protected final String green = "\u001B[32m";
    protected final String reset = "\u001B[0m";

    public boolean isBlancas() {
        return blancas;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public Pieza(Boolean blancas) {
        this.blancas =blancas;
    }
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





}








