/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

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
           if (!esValidoNif(ret)) System.out.println("ERROR. Introduzca un NIF válido");
        }while (!esValidoNif(ret));
        return ret;
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
                System.out.println("ERROR.Sólo se admiten números.! " + e.toString());
               
            } finally {
                scan.nextLine();
            }
        } while (error);
        return ret;
    }
     
     public static int menuPrincipal (Scanner scan){
         int op;
         
         do {             
             System.out.println("1.- Listar medicos");
             System.out.println("2.- Instertar medicos");
             System.out.println("3.- Buscar medico por codigo");
             System.out.println("4.- Buscar medico por nombre");
             System.out.println("5.- Elimina medico por codigo");
             System.out.println("6.- Salir");
             op=leeEntero(scan, "");
             } while (op<1);
         /**} while (op<1 || op>ULT);
         */
         return op;
     }
}