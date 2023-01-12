/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jnieto
 */
public class Lectura {
    
    public static final int ULT = 6;
    
     public static String leeCadena(Scanner scan,String mensaje){
        System.out.println(mensaje);
        return (scan.nextLine());
    }
    
    public static String leeNif(Scanner scan){
        String ret;
        
        do{
           ret=leeCadena(scan,"NIF: ") ;
           if (!Medico.esValidoNif(ret)) System.out.println("ERROR. Introduzca un NIF válido");
        }while (!Medico.esValidoNif(ret));
        return ret;
    }

    public static Medico.TipoMedico leeTipo(Scanner scan){
        int op;
        do{
            System.out.println("Seleccione el tipo: ");
            for (int i = 0; i < Medico.TipoMedico.values().length; i++) {
                
                System.out.println((i+1)+".- "+Medico.TipoMedico.values()[i].toString());
                
            }
            op=scan.nextInt();
        }while (op<1 || op>Medico.TipoMedico.values().length);
        scan.nextLine();
        return Medico.TipoMedico.values()[op-1];
    }
    
    
    
    public static Medico leeMedico(Scanner scan){
        String nombre;
        String especialidad;
        Medico.TipoMedico tipo;
        String nif;
        
        nombre = leeCadena(scan,"Nombre: ");
        especialidad = leeCadena(scan,"Especialidad: ");
        tipo = leeTipo(scan);
        
        nif = leeNif(scan);
                
        return new Medico(nombre, especialidad, tipo, nif);
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
         } while (op<1 || op>ULT);
         
         return op;
     }
}
