import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {
        FileWriter file = null;
        try {
            file = new FileWriter("src/peliculas.txt");
        } catch (IOException e) {
            System.out.println("No se puede abrir el archivo.");
        }

        BufferedWriter buffer = new BufferedWriter(file);
        try {
            buffer.write("¡Bienvenido, Mister Marshall!");
            buffer.newLine();
            buffer.write("Con la muerte en los talones");
            buffer.newLine();
            buffer.write("Muerte de un ciclista");
            buffer.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }

        try {
            buffer.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo");
        }
    }
}
