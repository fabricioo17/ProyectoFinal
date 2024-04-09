package Tablero;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private  int edad;
    private String dni;
    public  Usuario(Scanner teclado){
        System.out.println("ingrese su nombre: ");
        nombre=teclado.nextLine();
        System.out.println("ingrese su edad ");
        edad=teclado.nextInt();
        System.out.println("ingresa tu dni");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
