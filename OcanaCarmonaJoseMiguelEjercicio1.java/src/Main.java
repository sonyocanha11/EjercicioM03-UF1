
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el número de filas: ");
        int filas = in.nextInt();
        System.out.println("Introduce el número de columnas: ");
        int columnas = in.nextInt();

        while (filas <= 0 || columnas <= 0) {
            System.out.print("Introduce el número de filas (mayor que 0): ");
            if (in.hasNextInt()) {
                filas = in.nextInt();
            } else {
                System.out.println("Entrada no válida, por favor introduzca otro número entero: ");
                in.next();
                continue;
            }
            System.out.print("Introduce el número de columnas (mayor que 0): ");
            if (in.hasNextInt()) {
                columnas = in.nextInt();
            } else {
                System.out.println("Entrada no válida, introduzca otro número entero: ");
                in.next();
                filas = 0;
                continue;
            }
            if (filas <= 0 || columnas <= 0) {
                System.out.println("Los valores deben de ser mayores que 0. Inténtalo de nuevo");


            }


        }
        System.out.println("Filas: " + filas + ", Columnas: " + columnas);

        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        System.out.println("Matriz generada:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> rankingExplosiones = new ArrayList<>();


        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú de opciones:");
            System.out.println("[3] Ranking");
            System.out.println("[2] Poner bomba");
            System.out.println("[1] Mostrar matriz");
            System.out.println("[0] Salir");
            System.out.print("Elige una opción: ");
            int opcion = in.nextInt();

            switch (opcion) {
                case 0:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;

                case 1:
                    System.out.println("Matriz actual: ");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            System.out.print(matriz[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Introduce la coordenada x (fila): ");
                    int x = in.nextInt();
                    System.out.print("Introduce la coordenada y (columna): ");
                    int y = in.nextInt();
                    if (x >= 0 && x < filas && y >= 0 && y < columnas) {
                        int valorExplosión = 0;
                        boolean sePuedeExplodir = true;

                        for (int j = 0; j < columnas; j++) {
                            if (matriz[x][j] == 0) {
                                sePuedeExplodir = false;
                            }
                            valorExplosión += matriz[x][j];
                        }
                        for (int i = 0; i < filas; i++) {
                             if (matriz[i][y] == 0) {
                                 sePuedeExplodir = false;
                             }
                             valorExplosión += matriz[i][y];
                        }
                        if (sePuedeExplodir) {
                            System.out.println("Valor explosión: " + valorExplosión);

                            for (int j = 0; j < columnas; j++) {
                                matriz[x][j] = 0;
                            }
                            for (int i = 0; i < filas; i++) {
                                matriz[i][y] = 0;
                            }
                            boolean juegoTerminado = true;
                            for (int i = 0; i < filas; i++) {
                                for (int j = 0; j < columnas; j++){
                                    if (matriz[i][j] != 0) {
                                        juegoTerminado = false;
                                    }
                                }
                            }
                            if (juegoTerminado) {
                                System.out.println("¡Fin del juego!");
                                continuar = false;
                            }

                        } else {
                            System.out.println("La bomba no se puede colocar ya hay un 0 en la fila o columa");
                        }
                    } else {
                        System.out.println("Coordenadas fuera del rango de la matriz. Deben de estar entre 0 y " + ( filas - 1) + " para filas y 0 y " + (columnas - 1) + " para columnas.");
                    }
                    break;
                case 3:
                    System.out.println("Ranking de explosiones: ");
                    if (rankingExplosiones.isEmpty()) {
                        System.out.println("No se ha podido registrar ninguna explosión.");

                    } else {
                        for (int i = 0; i < rankingExplosiones.size(); i++) {
                            System.out.println((i + 1) + ". Explosión de valor: " + rankingExplosiones.get(i));
                        }
                    }
                    break;


                default:
                    System.out.println("Error. inténtalo de nuevo");
                    break;
            }
        }
        in.close();
    }
    public static void mostrarMatriz (int[][] matriz, int filas, int columnas) {
        for ( int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz [i][j] + " ");
            }
            System.out.println();
        }

    }
}
