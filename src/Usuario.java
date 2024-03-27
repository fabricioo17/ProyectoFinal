import java.util.Scanner;

public class Usuario {
    private String nombre;
    public  Usuario(Scanner teclado){
        System.out.println("ingrese su nombre: ");
        nombre=teclado.next();

    }
}
