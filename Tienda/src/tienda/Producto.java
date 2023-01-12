/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author damdu108
 */
public class Producto {
        public static enum Categoria {
        ORDENADOR, TELEFONOS, LAVADORAS, FRIGORIFICOS, COCINAS, TELEVISIONES 
    };
    
    private String nombre;
    private String numSerie;
    private String marca;
    private int cantidad;
    private int precio;
    private boolean borrado; 

    public Producto(String nombre, String numSerie, String marca, int cantidad, int precio, boolean borrado) {
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
        this.borrado = borrado;
    }
    
    public Producto(String nombre, String numSerie, String marca, int cantidad) {
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.marca = marca;
        this.cantidad = cantidad;
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

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
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
        sb.append(", numSerie=").append(numSerie);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }
    
}