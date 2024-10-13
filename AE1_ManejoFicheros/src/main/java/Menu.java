import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("""
                1. Añadir nuevo coche
                2. Borrar coche por id
                3. Consulta coche por id
                4. Listado de coches
                5. Terminar el programa
                """);
        System.out.println();
        System.out.println("Elige una opción: ");
    }


    // métodos que implementan funcionalidad del menú

    public void añadirCoche(ArrayList<Coche> listaCoches) {
        Scanner entrada = new Scanner(System.in);
        Coche nuevoCoche = new Coche();

        // Pedimos datos al usuario para poder crear el objeto Coche

        System.out.println("Introduce la marca del coche:");
        String marca = entrada.nextLine();
        nuevoCoche.setMarca(marca);

        System.out.println("Introduce el modelo del coche:");
        String modelo = entrada.nextLine();
        nuevoCoche.setModelo(modelo);

        System.out.println("Introduce el color del coche:");
        String color = entrada.nextLine();
        nuevoCoche.setColor(color);

        System.out.println("Introduce la id del coche");

        // bloque try-catch para evitar error en caso de que usuario no introduzca un numero
        try {
            int id = entrada.nextInt();
            // consideramos que la id nunca puede ser un numero negativo
            if (id <= 0) {
                System.out.println("Error, la id debe ser un número entero y positivo");
                return;
            }
            nuevoCoche.setId(id);
        } catch (InputMismatchException e) {
            System.out.println("Error, la id debe ser un número entero y positivo");
            return;
        }

        System.out.println("Introduce la matrícula del coche:");
        String matricula = entrada.nextLine();
        nuevoCoche.setMatricula(matricula);

        // Comprobamos que el coche no exista ya en nuestro ArrayList
        for (Coche coche : listaCoches) {
            if (coche.getId() == nuevoCoche.getId() || coche.getMatricula().equals(matricula)) {
                System.out.println("El coche ya existe");
            }
        }

        listaCoches.add(nuevoCoche);
        System.out.println("El coche se ha añadido con éxito.");
    }


    public void borrarCoche(ArrayList<Coche> listaCoches) {
        Scanner entrada = new Scanner(System.in);
        int id;

        // bloque try-catch para evitar error en caso de que usuario no introduzca un numero
        System.out.println("Introduzca la id del coche que desea borrar:");
        try{
            id = entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error, la id debe ser un número entero y positivo");
            return;
        }
        // Comprobamos que el coche exista en el ArrayList para poder eliminarlo
        for (Coche coche : listaCoches) {
            if (coche.getId() == id) {
                listaCoches.remove(coche);
                System.out.println("Se ha eliminado el coche con éxito");
            }
            System.out.println("No se ha encontrado un coche con esa 'id'");
        }
    }

    public void consultaCoche (ArrayList<Coche> listaCoches) {
        Scanner entrada = new Scanner(System.in);
        int id;

        // bloque try-catch para evitar error en caso de que usuario no introduzca un numero
        System.out.println("Introduzca la id del coche que desea borrar:");
        try{
            id = entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error, la id debe ser un número entero y positivo");
            return;
        }

        for (Coche coche : listaCoches) {
            if (coche.getId() == id) {
                System.out.println(coche.toString());;
                return;
            }
        }

        // en caso de que no se encuentre un coche con la id proporcionada
        System.out.println("No se ha encontrado el coche con esa 'id'");
    }

    public void listadoCoches (ArrayList<Coche> listaCoches) {
        // comprobamos que la lista no este vacía
        if (listaCoches.isEmpty()) {
            System.out.println("Todavía no se ha añadido ningún coche en la lista");
            return;
        }
        for (Coche coche : listaCoches) {
            System.out.println(coche.toString());
        }
    }

    public void terminarPrograma(){
        System.exit(0);
    }
}
