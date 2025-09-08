package empaquetadora;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class EmpaquetarEntero {
      // Atributos según el UML
    private int max;
    private int contador;
    private int[] almacen;
    private List<int[]> paquetesCompletos;
    
    // Constructor
    public EmpaquetarEntero(int m) {
        this.max = m;
        this.contador = 0;
        this.almacen = new int[m];
        this.paquetesCompletos = new ArrayList<>();
    }
    
    // Método para agregar elemento
    public void agregarElemento(int e) {
        if (contador < max) {
            almacen[contador] = e;
            contador++;
            System.out.println(" Elemento " + e + " agregado. [" + contador + "/" + max + "]");
            
            if (estaLista()) {
                System.out.println(" PAQUETE COMPLETO Listo para empaquetar.");
            }
        } else {
            System.out.println(" Almacen lleno. Empaquete primero.");
        }
    }
    
    // Método para empaquetar (retorna arreglo de enteros)
    public int[] empaquetar() {
        if (estaLista()) {
            int[] paquete = Arrays.copyOf(almacen, contador);
            paquetesCompletos.add(paquete);
            System.out.println(" Empaquetando... Paquete formado");
            reiniciar();
            return paquete;
        } else {
            System.out.println("️  Paquete incompleto. Faltan " + (max - contador) + " elementos.");
            return new int[0];
        }
    }
    
    // Método para verificar si está lista para empaquetar
    public boolean estaLista() {
        return contador == max;
    }
    
    // Método privado para reiniciar el contador y almacén
    private void reiniciar() {
        contador = 0;
        almacen = new int[max];
    }
    
    // Método para mostrar todos los paquetes completados
    public void mostrarPaquetesCompletos() {
        if (paquetesCompletos.isEmpty()) {
            System.out.println(" No hay paquetes completados aun.");
            return;
        }
        
        System.out.println("\n PAQUETES COMPLETADOS:");
        System.out.println("_________________________");
        for (int i = 0; i < paquetesCompletos.size(); i++) {
            int[] paquete = paquetesCompletos.get(i);
            System.out.println("Paquete " + (i + 1) + ": " + Arrays.toString(paquete) + 
                             " (" + paquete.length + " elementos)");
        }
        System.out.println("Total: " + paquetesCompletos.size() + " paquetes");
    }
    
    // Método para mostrar el estado actual
    public void mostrarEstado() {
        System.out.println("\n ESTADO ACTUAL:");
        System.out.println("__________________________");
        System.out.println("Capacidad maxima: " + max + " elementos");
        System.out.println("Elementos actuales: " + contador + "/" + max);
        System.out.println("Contenido actual: " + Arrays.toString(Arrays.copyOf(almacen, contador)));
        System.out.println("¿Listo para empaquetar? " + (estaLista() ? "Si" : "NO"));
        System.out.println("Paquetes completados: " + paquetesCompletos.size());
    }
    
    // Métodos getter para acceso a los atributos
    public int getMax() {
        return max;
    }
    
    public int getContador() {
        return contador;
    }
    
    public int[] getAlmacen() {
        return Arrays.copyOf(almacen, contador);
    }
    
    public int getTotalPaquetes() {
        return paquetesCompletos.size();
    }
    
    public List<int[]> getPaquetesCompletos() {
        return new ArrayList<>(paquetesCompletos);
    }
}