/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author damdu108
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jnieto
 */
public class Lectura {
    
     public static String leeCadena(Scanner scan,String mensaje){
        System.out.println(mensaje);
        return (scan.nextLine());
    }
     
    public static boolean esValidoNif(String nif) {
        String sDni;
        boolean correcto;
        int num;
        Character letra;
        Character[] letraDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char[] aLetraD;

        nif = nif.trim().toUpperCase();
        correcto = (nif.length() == 9);
        if (correcto) {
            sDni = nif.substring(0, 8);
            for (int i = 0; i < 8; i++) {
                if (!Character.isDigit(sDni.charAt(i))) {
                    correcto = false;
                }
            }
            if (correcto) {
                correcto =  nif.charAt(8) == letraDNI[Integer.parseInt(sDni) % 23];
            }
        }
        return correcto;
    }
    
    public static String leeNif(Scanner scan){
        String ret;
        
        do{
           ret=leeCadena(scan,"NIF: ") ;
           if (!esValidoNif(ret)) System.out.println("ERROR. Introduzca un NIF v�lido");
        }while (!esValidoNif(ret));
        return ret;
    }
    
     public static Producto leeProducto(Scanner scan){
        String nombre;
        Producto.Categoria categoria;
        String marca;
        int cantidad;
        int precio;
        
        nombre = leeCadena(scan,"Nombre: ");
        categoria = leeCategoria(scan);
        marca = leeCadena(scan,"Marca: ");
        cantidad = leeEntero(scan,"Cantidad: ");
        precio = leeEntero(scan,"Precio: ");
                
        return new Producto(nombre, categoria, marca, cantidad, precio);
    }
     
     public static Producto.Categoria leeCategoria(Scanner scan){
        int op;
        do{
            System.out.println("Seleccione la categoria: ");
            for (int i = 0; i < Producto.Categoria.values().length; i++) {
                
                System.out.println((i+1)+".- "+Producto.Categoria.values()[i].toString());
                
            }
            op=leeEntero(scan,"");
        }while (op<1 || op>Producto.Categoria.values().length);
        scan.nextLine();
        return Producto.Categoria.values()[op-1];
    }
    public static Cliente leeCliente(Scanner scan){
        String nombre;
        int telefono;
        String dni;
        String direccion;
        
        nombre = leeCadena(scan,"Nombre: ");
        telefono = leeEntero(scan,"Telefono: ");
        direccion = leeCadena(scan,"Direccion: ");
        dni = leeNif(scan);
                
        return new Cliente (nombre, telefono, dni, direccion);
    }
     public static int leeEntero(Scanner scan,String msj) {
        int ret;
        boolean error;
        
        ret = 0;
        error = true;
        do {
            System.out.println(msj);
            try {
                ret = scan.nextInt();
                error = false;
                
            } catch (InputMismatchException e) {
               System.out.println("ERROR.S�lo se admiten n�meros.! " + e.toString());
               scan.nextLine();
               error = true;
            } 
        } while (error);
        return ret;
    }
     
     public static int menuPrincipal (Scanner scan){
         int op;
         
         do {             
             System.out.println("1.- Listar productos");
             System.out.println("2.- Instertar productos");
             System.out.println("3.- Buscar producto por codigo");
             System.out.println("4.- Buscar producto por nombre");
             System.out.println("5.- Elimina producto por codigo");
             System.out.println("6.- Salir");
             op=leeEntero(scan, "");
             } while (op<1);
         /**} while (op<1 || op>ULT);
         */
         return op;
     }
}