import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Creamos nuestra lista de coches llamando a la clase GestorFicheros.
        GestorFicheros gf = new GestorFicheros();
        ArrayList<Coche> listaCoches = gf.comprobarFichero();

        // Iniciamos el menú
        Menu menu = new Menu();
        String opcion;
        do {
            menu.mostrarMenu();
            System.out.println("Elige una opcion: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    menu.añadirCoche(listaCoches);
                    break;

                case "2":
                    menu.borrarCoche(listaCoches);
                    break;

                case "3":
                    menu.consultaCoche(listaCoches);
                    break;

                case "4":
                    menu.listadoCoches(listaCoches);
                    break;

                case "5":
                    menu.terminarPrograma(listaCoches);
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (!opcion.equals("5"));

        // Cierre del Scanner
        entrada.close();
    }
}
