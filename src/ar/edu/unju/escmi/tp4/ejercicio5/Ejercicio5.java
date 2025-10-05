package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        int opcion;
final String ROSA = "\u001B[38;5;205m";// color rosa para el menu :)
        do {
            System.out.println(ROSA +"\n********** PRODUCTOS ************");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Buscar un producto");
            System.out.println("4 - Eliminar un producto");
            System.out.println("5 - Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese clave numérica: ");
                    int clave = sc.nextInt();
                    sc.nextLine();
                    if (productos.containsKey(clave)) {
                        // Validación: no se permite duplicar claves en el TreeMap
                        System.out.println("La clave ya existe, no se puede agregar.");
                    } else {
                        System.out.print("Descripción: ");
                        String desc = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                        LocalDate fecha = LocalDate.parse(sc.nextLine());
                        productos.put(clave, new Producto(desc, precio, fecha));
                        // Inserción correcta en la colección
                        System.out.println("Producto agregado con éxito.");
                    }
                    break;

                case 2:
                    // Uso de Iterator para recorrer y mostrar clave + objeto producto
                    Iterator<Map.Entry<Integer, Producto>> it = productos.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Producto> entry = it.next();
                        System.out.println("Clave: " + entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese clave a buscar: ");
                    int claveBuscar = sc.nextInt();
                    sc.nextLine();
                    if (productos.containsKey(claveBuscar)) {
                        System.out.println("Clave: " + claveBuscar + " -> " + productos.get(claveBuscar));
                    } else {
                        // Mensaje de control cuando la clave no está presente
                        System.out.println("No se encontró el producto.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese clave a eliminar: ");
                    int claveEliminar = sc.nextInt();
                    sc.nextLine();
                    if (productos.containsKey(claveEliminar)) {
                        productos.remove(claveEliminar);
                        // Eliminación directa en el TreeMap
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Clave inexistente.");
                    }
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}
