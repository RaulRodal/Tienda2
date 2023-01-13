/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

import clases.Lectura;
import clases.Tienda;
import java.util.Scanner;

/**
 *
 * @author damdu108
 */
public class Productos {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tienda c = new Tienda("Electrodomesticos Pepe", "Calle milagro");
        int ULT = 8;
        int op;

        do {

            op = Lectura.menuPrincipal(scan);
            switch (op) {
                case 1://Lista los productos que tenga la tienda
                    System.out.println(c.getProductos());
                    break;

                case 2://inserta productos si hay espacio
                    if (c.hayEspacio()) {

                        c.insertaProducto(Lectura.leeProducto(scan));
                    } else {
                        System.out.println("No hay mas espacio");
                    }
                    break;

                case 3://Buscar producto por numero de serie
                    int cod;
                    try {
                        cod = Lectura.leeEntero(scan, "Introduce codigo a buscar");
                        if (c.buscarNumSerie(cod) >= 0) {
                            System.out.println(c.getProducto(c.buscarNumSerie(cod)));
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Codigo no encontrado");
                    }

                    break;

                case 4://Buscar producto por nombre
                    String nombre;
                    scan.nextLine();
                    nombre = Lectura.leeCadena(scan, "Introduce nombre a buscar");
                    if (c.buscarNombre(nombre) >= 0) {
                        System.out.println(c.getProducto(c.buscarNombre(nombre)));
                    }
                    break;

                case 5: //Elimina producto por numero de serie
                    int codE;
                    codE = Lectura.leeEntero(scan, "Introduce el numero de serie del producto a eliminar");
                    c.eliminaNumS(codE);
                    break;
                    
                case 6://lista productos borrados
                    System.out.println(c.getBorrados());
                    break;
                
                case 7: //restar cantidad por numero de serie
                    int codR; 
                    int cantidad;
                    codR = Lectura.leeEntero(scan, "Introduce el numero de serie");
                    cantidad = Lectura.leeEntero(scan, "¿Cuantos deseas borrar?");
                    c.getProducto(c.buscarNumSerie(codR)).restarCantidad(cantidad);
                    break;
            }
            System.out.println("\n Pulse una tecla para continuar: ");
            scan.nextLine();
        } while (op != ULT);
    }
}
