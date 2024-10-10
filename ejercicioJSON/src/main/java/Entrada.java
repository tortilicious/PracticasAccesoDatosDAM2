import org.json.JSONObject;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PeticionJSON peticionJSON = new PeticionJSON();
        JSONObject peticionPedidos = peticionJSON.procesarPeticion();

        while (true) {
            Interfaz.mostrarMenu();
            System.out.println("Introduzca una opción");
            try {
                int input = Integer.parseInt(scan.nextLine());
                switch (input) {
                    case 1:
                        peticionJSON.leerProductos(peticionPedidos);
                        break;
                    case 2:
                        peticionJSON.buscarProductoPorID(peticionPedidos);
                        break;
                    case 3:
                        peticionJSON.buscarProductosPorPrecio(peticionPedidos);
                        break;
                    case 4:
                        peticionJSON.guardarJSON(peticionPedidos);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Placeholder");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduzca un numero entero");
            }
        }
    }
}
