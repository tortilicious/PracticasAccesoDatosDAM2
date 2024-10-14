import java.io.*;
import java.util.ArrayList;

public class GestorFicheros {

    // método que comprueba la existencia de un fichero y devuelve un ArrayList con los objetos Coche que encuentre en el fichero en caso de existir
    public ArrayList<Coche> comprobarFichero() {

        File fichero = new File("src/main/java/resources/coches.dat");
        ArrayList<Coche> listaCoches = new ArrayList<>();

        if (fichero.exists()) {
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(fichero));
                while (true) {
                    try {
                        listaCoches.add((Coche) objectInputStream.readObject());
                    } catch (EOFException e) {
                        // Capturamos el error cuando no quedan mas objetos Coche que leer en el fichero y salimos del bucle.
                        System.out.println("Lectura completa del fichero");
                        System.out.println();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el fichero");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: clase no encontrada");
            } catch (ClassCastException e) {
                System.out.println("Error al declarar el tipo de datos");
            }
        }
        return listaCoches;
    }

    // método para escribir objetos en un fichero
    public void escribirFichero(ArrayList<Coche> listaCoches){

        File fichero = new File("src/main/java/resources/coches.dat");
        ObjectOutputStream objectOutputStream = null;
         try {
             objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero));
             for (Coche coche : listaCoches) {
                 objectOutputStream.writeObject(coche);
             }
         } catch (IOException e) {
             System.out.println("Error en la escritura del fichero");
         } finally {
             try {
                 objectOutputStream.close();
             } catch (IOException e) {
                 System.out.println("Error al cerrar la escritura del fichero");
             }
         }
    }

    // método que vuelca el listado de coches en un archivo ".txt"
    public void exportarListadoCoches(ArrayList<Coche> listaCoches){

        File fichero = new File("src/main/java/resources/listadoCoches.txt");
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fichero));
            for (Coche coche : listaCoches) {
                bufferedWriter.write(coche.toString());

                // añadimos un salto de línea para mejorar la comodidad de la lectura en el archivo '.txt'
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error en volcado del fichero");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar la exportación del fichero");;
            }
        }
    }
}
