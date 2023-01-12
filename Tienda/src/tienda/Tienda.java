/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import clases.Lectura;
import clases.Producto;
import java.util.Scanner;

/**
 *
 * @author damdu108
 */
public class Tienda {
    
    // añadir todo el inventario en un Array de 100 elementos, se debe buscar, añadir y borrar
    // borrado logico (atributo borrado) o array de historicos borras y vuelves a recalcular posiciones
    
    Scanner scan = new Scanner (System.in);
    private String nombre;
    private String direccion;
    private Producto[] productos;
    private static final int MAX = 100;
    private int libre;

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        productos = new Producto[MAX];
        libre = 0;
    }
    public boolean estaLlena() {
        return (libre == MAX);
    }
    
    public boolean hayEspacio() {
        return (!estaLlena());
    }
     public boolean hayProductos() {
        return (libre > 0);
    }
    /**
     * 
     * @param m
     * @throws ArrayIndexOutOfBoundsException 
     */
     public void insertaProducto(Producto m) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            productos[libre] = m;
            ++libre;
        } else {
            throw new ArrayIndexOutOfBoundsException("Se han sobrepasado la capacidad.");
        }
    }
      public String getProductos() {
        StringBuilder ret = new StringBuilder();

        if (hayProductos()) {
            for (int i = 0; i < libre; i++) {
                ret.append(productos[i]);
            }
        } else {
            ret.append("No hay productos por el momento");
        }

        return ret.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tienda{");
        sb.append("nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", productos=").append(getProductos());
        sb.append(", libre=").append(libre);
        sb.append('}');
        return sb.toString();
    }
    
    
     public static void main(String[] args) {
        Scanner scan2 = new Scanner (System.in);
        Tienda e = new Tienda("alexis", "gabriel");
        Producto m = new Producto();
        m = Lectura.leeProducto(scan2);
        e.insertaProducto(m);
         System.out.println(e);
    }
}
