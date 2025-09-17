package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n********** MENÚ DE JUGADORES **********");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Modificar jugador");
            System.out.println("3 - Eliminar jugador");
            System.out.println("4 - Mostrar todos los jugadores");
            System.out.println("5 - Cantidad de jugadores");
            System.out.println("6 - Limpiar lista");
            System.out.println("7 - Salir");
            System.out.print("/n/n********** Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1: 
                    Jugador j = new Jugador(); 
                    System.out.print("Ingrese DNI: ");
                    j.setDni(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    j.setNombre(sc.nextLine());
                    System.out.print("Ingrese equipo: ");
                    j.setEquipo(sc.nextLine());
                    System.out.print("Ingrese nacionalidad: ");
                    j.setNacionalidad(sc.nextLine());
                    System.out.print("Ingrese estatura (cm): ");
                    j.setEstatura(sc.nextInt());
                    sc.nextLine();
                    jugadores.add(j);
                    System.out.println("Jugador agregado!");
                    break;

                case 2:
                    System.out.print("/n ********** /n Ingrese el DNI del jugador a modificar: ");
                    int dniMod = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getDni() == dniMod) {
                            System.out.println("Jugador encontrado!! :)");
                            jugador.mostrarDatos();

                            System.out.print("Nuevo nombre: ");
                            jugador.setNombre(sc.nextLine());
                            System.out.print("Nuevo equipo: ");
                            jugador.setEquipo(sc.nextLine());
                            System.out.print("Nueva nacionalidad: ");
                            jugador.setNacionalidad(sc.nextLine());
                            System.out.print("Nueva estatura (cm): ");
                            jugador.setEstatura(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Datos modificados!!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró el jugador con DNI: " + dniMod);
                    }
                    break;

                case 3:
                    System.out.print("/n ********** /n Ingrese el DNI del jugador a eliminar: ");
                    int dniDel = sc.nextInt();
                    sc.nextLine();
                    Jugador jugadorEliminar = null;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getDni() == dniDel) {
                            jugadorEliminar = jugador;
                            break;
                        }
                    }
                    if (jugadorEliminar != null) {
                        jugadores.remove(jugadorEliminar);
                        System.out.println("Jugador eliminado!!");
                    } else {
                        System.out.println("No se encuentra el DNI :(");
                    }
                    break;

                case 4: 
                    if (jugadores.isEmpty()) {
                        System.out.println("No hay jugadores en la lista :(");
                    } else {
                        for (Jugador jugador : jugadores) {
                            jugador.mostrarDatos();
                        }
                    }
                    break;

                case 5: 
                    System.out.println("Cantidad de jugadores: " + jugadores.size());
                    break;

                case 6: 
                    jugadores.clear();
                    System.out.println("Lista vaciada!!");
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}
