
package programacuerposcelestes;

/**
 * Clase que alberga métodos que complementan al lanzador de CuerpoCeleste.
 * 
 * @author Adrián Arjona
 * @version 1.0 Febrero 2023
 */
public class MetodosCuerpoCeleste {
    
    /* Francisco Adrián Arjona Bravo
    UNIDAD 6: almacenando datos.
    */
    
    
    /**
     * Método que muestra el menú de la aplicación
     */
    public static void mostrarMenu(){
        
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
    
    
    /**
     * Método que comprueba si el código del cuerpo celeste tiene 3 dígitos.
     * 
     * @param codigo Código del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaCodigo(short codigo){
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el nombre del cuerpo celeste tiene como máximo 15 caracteres.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaNombre(String nombre){
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el diámetro tiene 6 dígitos como máximo.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
}
