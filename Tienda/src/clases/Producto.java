/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author damdu108
 */
public class Producto {

    public static enum Categoria {
        ORDENADOR, TELEFONOS, LAVADORAS, FRIGORIFICOS, COCINAS, TELEVISIONES
    };
    private String nombre;
    private Categoria cat;
    private int numSerie;
    private String marca;
    private int cantidad;
    private int precio;
    private boolean borrado;
    private static int cont = 0;

    public Producto() {
    }

    public Producto(String nombre, Categoria cat, String marca, int cantidad, int precio) {
        this.nombre = nombre;
        this.cat = cat;
        this.numSerie = ++cont; //esto es un contador que se incrementa cada vez que se crea un producto.
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
        this.borrado = false;
    }
    public void restarCantidad(int cantidad){
        this.cantidad-=cantidad;
    }

    
/**
 * //cambia el atributo borrado a true.
 */
    public void borrado() {
        this.borrado = true;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos:");
        sb.append("\n-nombre= ").append(nombre);
        sb.append("\n-categoria= ").append(cat);
        sb.append("\n-numSerie= ").append(numSerie);
        sb.append("\n-cantidad= ").append(cantidad);
        sb.append("\n-marca= ").append(marca);
        return sb.toString();
    }

}
