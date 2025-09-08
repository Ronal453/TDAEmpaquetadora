package empaquetadora;

import java.util.Arrays;
import java.util.Scanner;

public class Empaquetadora {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        
        System.out.println("MaQUINA EMPACADORA INTERACTIVA");
        System.out.println("______________________________");
        
        // Configurar capacidad del paquete
        System.out.print("Ingrese la capacidad de cada paquete (ej: 6): ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        EmpaquetarEntero empacadora = new EmpaquetarEntero(capacidad);
        
        boolean ejecutando = true;
        
        while (ejecutando) {
            System.out.println("\n" + "_".repeat(40));
            System.out.println("MENu PRINCIPAL");
            System.out.println("_".repeat(40));
            System.out.println("1. Agregar elemento");
            System.out.println("2. Empaquetar (si esta completo)");
            System.out.println("3. Mostrar estado actual");
            System.out.println("4. Mostrar paquetes completados");
            System.out.println("5. Salir");
            System.out.println("_".repeat(40));
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero a agregar: ");
                    int elemento = scanner.nextInt();
                    scanner.nextLine();
                    empacadora.agregarElemento(elemento);
                    break;
                    
                case 2:
                    int[] paquete = empacadora.empaquetar();
                    if (paquete.length > 0) {
                        System.out.println("Paquete creado: " + Arrays.toString(paquete));
                    }
                    break;
                    
                case 3:
                    empacadora.mostrarEstado();
                    break;
                    
                case 4:
                    empacadora.mostrarPaquetesCompletos();
                    break;
                    
                case 5:
                    ejecutando = false;
                    System.out.println("Hasta pronto");
                    break;
                    
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
            
            // Pequeña pausa para mejor visualización
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        scanner.close();
        
        // Mostrar resumen final
        System.out.println("\n" + "_".repeat(40));
        System.out.println("          RESUMEN FINAL");
        System.out.println("_".repeat(40));
        empacadora.mostrarPaquetesCompletos();
        System.out.println("Total de elementos procesados: " + 
                          (empacadora.getTotalPaquetes() * capacidad + empacadora.getContador()));
    }
}