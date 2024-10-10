import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PeticionJSON {
    public JSONObject procesarPeticion() {
        String urlString = "https://dummyjson.com/products";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                stringBuffer.append(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new JSONObject(stringBuffer.toString());
    }

    public void leerProductos(JSONObject peticionProductos) {
        JSONArray listaProductos = peticionProductos.getJSONArray("products");
        for (Object item : listaProductos) {
            JSONObject producto = (JSONObject) item;
            System.out.println(producto.get("title"));
            System.out.println(producto.get("price"));
            System.out.println(producto.get("stock"));
            System.out.println(producto.get("description"));
            System.out.println();
        }
    }

    public void buscarProductoPorID(JSONObject peticionProductos) {
        JSONArray listaProductos = peticionProductos.getJSONArray("products");
        boolean productoEncontrado = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("Intrduzca el numero de ID del producto que desea buscar");

        try {
            int itemID = Integer.parseInt(scan.nextLine());
            for (Object item : listaProductos) {
                JSONObject producto = (JSONObject) item;
                if (producto.get("id").equals(itemID)) {
                    System.out.println(producto.get("title"));
                    System.out.println(producto.get("price"));
                    System.out.println(producto.get("stock"));
                    System.out.println(producto.get("description"));
                    productoEncontrado = false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un numero entero");
        }
    }

    public void buscarProductosPorPrecio (JSONObject peticionProductos) {
        JSONArray listaProductos = peticionProductos.getJSONArray("products");
        Scanner scan = new Scanner(System.in);

        System.out.println("Elija si quiere filtrar por precio mínimo (min) o máximo (max)");
        String userOpcion = scan.nextLine();

        switch (userOpcion) {
            case "min":
                System.out.println("Establezca el precio");
                try {
                    double precioFiltrar = Double.parseDouble(scan.nextLine());
                    for (Object item : listaProductos) {
                        JSONObject producto = (JSONObject) item;
                        if (producto.getDouble("price") > precioFiltrar) {
                            System.out.println(producto.get("title"));
                            System.out.println(producto.get("price"));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Introduzca un precio");
                }
                break;

            case "max":
                System.out.println("Establezca el precio");
                try {
                    double precioFiltrar = scan.nextDouble();
                    for (Object item : listaProductos) {
                        JSONObject producto = (JSONObject) item;
                        if (producto.getDouble("price") < precioFiltrar) {
                            System.out.println(producto.get("title"));
                            System.out.println(producto.get("price"));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Introduzca un precio");
                }
                break;

            default:
                System.out.println("Elija una opción (min/max)");
        }


    }
    public void guardarJSON (JSONObject jsonFile) {
            String filePath = "src/main/resources/json.txt";
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
                bufferedWriter.write(procesarPeticion().toString());
            } catch (IOException e) {
                System.out.println("Error en la escritura");
            }
    }
}


