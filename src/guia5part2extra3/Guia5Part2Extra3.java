/*
Implemente un programa para una Librería haciendo uso de un HashSet para evitar datos
repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de cada uno
de los libros de una Biblioteca. La clase Libro debe guardar el título del libro, autor, número de
ejemplares y número de ejemplares prestados. También se creará en el main un HashSet de tipo
Libro que guardará todos los libros creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus datos y
los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le pregunta al usuario
si quiere crear otro Libro o no.
La clase Librería contendrá además los siguientes métodos:
• Constructor por defecto.
• Constructor con parámetros.
• Métodos Setters/getters
20
• Método prestamo(): El usuario ingresa el título del libro que quiere prestar y se lo busca en el
conjunto. Si está en el conjunto, se llama con ese objeto Libro al método. El método se incrementa
de a uno, como un carrito de compras, el atributo ejemplares prestados, del libro que ingresó el
usuario. Esto sucederá cada vez que se realice un préstamo del libro. No se podrán prestar libros

de los que no queden ejemplares disponibles para prestar. Devuelve true si se ha podido realizar
la operación y false en caso contrario.
• Método devolucion(): El usuario ingresa el título del libro que quiere devolver y se lo busca en
el conjunto. Si está en el conjunto, se llama con ese objeto al método. El método decrementa de a
uno, como un carrito de compras, el atributo ejemplares prestados, del libro seleccionado por el
usuario. Esto sucederá cada vez que se produzca la devolución de un libro. No se podrán devolver
libros donde que no tengan ejemplares prestados. Devuelve true si se ha podido realizar la
operación y false en caso contrario.
• Método toString para mostrar los datos de los libros.
 */
package guia5part2extra3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Guia5Part2Extra3 {

   public static void main(String[] args) {
        Set<Libro> libros = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1) {
            System.out.print("Ingrese el título del libro: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el autor del libro: ");
            String autor = scanner.nextLine();
            System.out.print("Ingrese el número de ejemplares: ");
            int numEjemplares = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            Libro libro = new Libro(titulo, autor, numEjemplares);
            libros.add(libro);

            System.out.print("¿Desea agregar otro libro? (1: Sí, 0: No): ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
        }

        System.out.println("Libros en la librería:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }

        int opcionMenu = 0;
        while (opcionMenu != 4) {
            System.out.println("\nMenú:");
            System.out.println("1. Realizar préstamo");
            System.out.println("2. Realizar devolución");
            System.out.println("3. Mostrar libros en la librería");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcionMenu = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcionMenu) {
                case 1:
                                        System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    Libro libroPrestamo = buscarLibro(libros, tituloPrestamo);
                    if (libroPrestamo != null) {
                        libroPrestamo.prestamo();
                    } else {
                        System.out.println("El libro no está disponible en la librería.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    Libro libroDevolucion = buscarLibro(libros, tituloDevolucion);
                    if (libroDevolucion != null) {
                        libroDevolucion.devolucion();
                    } else {
                        System.out.println("El libro no está disponible en la librería.");
                    }
                    break;
                case 3:
                    System.out.println("Libros en la librería:");
                    for (Libro libro : libros) {
                        System.out.println(libro);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private static Libro buscarLibro(Set<Libro> libros, String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}