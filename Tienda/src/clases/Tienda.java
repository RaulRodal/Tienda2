/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author damdu108
 */
public class Tienda {

    Scanner scan = new Scanner(System.in);
    private String nombre;
    private String direccion;
    private Producto[] productos;
    private Producto[] historicos;
    private static final int MAX = 100;
    private int libre;
    private int vacio;

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        productos = new Producto[MAX];
        historicos = new Producto[MAX];
        libre = 0;
        vacio = 0;
    }
    
    
    /**
     * devuelve el booleano de si esta lleno el array de productos
     * @return 
     */
    public boolean estaLlena() {
        return (libre == MAX);
    }
    
    
    /**
     * devuelve el booleano de si hay hueco en el array de productos
     * @return 
     */
    public boolean hayEspacio() {
        return (!estaLlena());
    }
    
    
    /**
     * devuelve el booleano de si hay algun producto en el array productos
     * @return 
     */
    public boolean hayProductos() {
        return (libre > 0);
    }
    
    /**
     * devuelve el booleano de si hay algun producto en el array historicos
     * @return 
     */
     public boolean hayBorrados() {
        return (vacio > 0);
    }

    
     /**
      * Inserta un producto(m) y controla la excepcion de si esta el array lleno
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
    
    /**
     * devuelve el producto del array productos segun la posicion(pos) que le enviemos
     * @param pos
     * @return 
     */
    public Producto getProducto(int pos) {
        Producto ret;
        ret = null;

        if (pos >= 0 && pos < libre) {
            ret = productos[pos];
        }
        return ret;
    }
  
    /**
     * devuelve el producto del array historicos segun la posicion (pos) que le enviemos
     * @param pos
     * @return 
     */
    public Producto getBorrado(int pos) {
        Producto ret;
        ret = null;

        if (pos >= 0 && pos < vacio) {
            ret = historicos[pos];
        }
        return ret;
    }
    
    /**
     * devuelve la posicion del producto el cual le pasemos su numero de serie(cod)
     * @param cod
     * @return 
     */
    public int buscarNumSerie(int cod) {
        int ret = -1;
        int cont = 0;
        while (cont >= 0 && cont < libre) {
            if (getProducto(cont).getNumSerie() == cod) {
                ret = cont;
            }
            cont++;
        }
        return ret;
    }
    
    /**
     * devuelve la posicion del producto el cual le pasemos su nombre(nombre)
     * @param nombre
     * @return 
     */
    public int buscarNombre(String nombre) {
        int ret = -1;
        for (int i = 0; i < libre; i++) {
            if (nombre.compareToIgnoreCase(productos[i].getNombre()) == 0) {
                ret = i;
            }
        }
        return ret;
    }
/**
 *  Elmina el producto del que le pasemos el numero de serie(cod),
 *  le cambia el estado de borrado a "true",
 *  desplaza las posiciones siguientes al borrado una poscion atras,
 *  envia el producto borrado al array historicos,
 *  añande 1 a la posicion "vacio" de historicos y
 *  resta 1 a la posicion "libre de productos.
 * @param cod 
 */
    public void eliminaNumS(int cod) {
        int pos = buscarNumSerie(cod);
        productos[pos].borrado();
        historicos[vacio]=productos[pos];
        ++vacio;
        for (int i = pos; i < libre; i++) {
            productos[pos] = productos[pos + 1];
        }
        libre--;
    }
    /**
     * devuelve el toString de todos los productos del array productos
     * @return 
     */
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
    /**
     * devuelve el toString de todos los productos del array historicos
     * @return 
     */
    public String getBorrados() {
        StringBuilder ret = new StringBuilder();

        if (hayBorrados()) {
            for (int i = 0; i < vacio; i++) {
                ret.append(historicos[i]);
            }
        } else {
            ret.append("No hay borrados por el momento");
        }

        return ret.toString();
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tienda{");
        sb.append(" nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", productos=").append(getProductos());
        sb.append(", libre=").append(libre);
        sb.append('}');
        return sb.toString();
    }

}
