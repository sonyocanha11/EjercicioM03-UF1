import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicito patrón al usuario
        System.out.print("Introduce el patrón para las casillas: ");
        String patron = scanner.next();

        // Solicito tamaño de la casilla
        int size = solicitarTamaño(scanner);

        // Generar e imprimir el tablero
        crearTablero(patron, size);

    }

    // Solicitar el tamaño de la casilla con validación
    public static int solicitarTamaño(Scanner scanner) {
        int size;
        do{
            System.out.print("Introduce el tamaño de la casilla (1-15): ");
            size = scanner.nextInt();
            if (size < 1 || size > 15) {
                System.out.println("Por favor, introduza un tamaño válido entre 1 y 15.");
            }
        } while (size < 1 || size > 15);
        return size;
    }

    // generar e imprimir el tablero de ajedrez
    public static void crearTablero(String patron, int size) {
        for (int fila = 0; fila < 8; fila++) { // 8 filas
            for (int line = 0; line < size; line++) { // cada fila tiene ´size´líneas
                for (int columna = 0; columna < 8; columna++) { // 8 columnas
                    if ((fila + columna) % 2 == 0) {
                        printPatron(patron, size);
                    } else {
                        printPatron(" ", size);
                    }

                }
                System.out.println(); // Nueva línea tras completar una fila
            }
        }
    }

    // Imprimir el patrón repetido
    public static void printPatron(String patron, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(patron);
        }
    }
}