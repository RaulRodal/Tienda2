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
        
    public static enum Categoria {ORDENADOR, TELEFONOS, LAVADORAS, FRIGORIFICOS, COCINAS, TELEVISIONES};
    private String nombre;
    private Categoria cat;
    private int numSerie;
    private String marca;
    private int cantidad;
    private int precio;
    private boolean borrado; 
    private static int cont=0;

    public Producto() {
    }
    
    

    public Producto(String nombre, Categoria cat, String marca, int cantidad, int precio) {
        this.nombre = nombre;
        this.cat = cat;
        this.numSerie = ++cont;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
        this.borrado = false;
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
        sb.append("Productos{");
        
        sb.append("nombre=").append(nombre);
        sb.append("categoria=").append(cat);
        sb.append(", numSerie=").append(numSerie);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }
    
}