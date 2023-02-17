
package programacuerposcelestes;

/**
 *
 * @author Adrián Arjona
 */
public class MetodosCuerpoCeleste {
    
    /* Francisco Adrián Arjona Bravo
    UNIDAD 6: almacenando datos.
    */
    
    public static void mostrarMenu(){ // MUESTRA MENÚ DE LA APLICACIÓN
        
        System.out.println("\n----------------------");
        System.out.println("-------- MENÚ --------");
        System.out.println("----------------------\n");
        
        System.out.println("1. Añadir cuerpo celeste");
        System.out.println("2. Listar cuerpos celestes");
        System.out.println("3. Buscar cuerpo celeste por código");
        System.out.println("4. Buscar cuerpo celeste por tipo");
        System.out.println("5. Borrar cuerpo celeste");
        System.out.println("6. Borrar fichero de cuerpos celestes");
        System.out.println("7. Salir de la aplicación");
    }
    
    
    public static boolean compruebaCodigo(short codigo){ // COMPRUEBA SI EL CÓDIGO TIENE 3 DÍGITOS
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    public static boolean compruebaNombre(String nombre){ // CPMPRUEBA SI EL NOMBRE TIENE COMO MÁXIMO 15 CARACTERES
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
}
