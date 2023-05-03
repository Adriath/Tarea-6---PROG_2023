
package programacuerposcelestes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import modelo.CuerpoCeleste;
import programacuerposcelestes.excepciones.ExcepcionCuerpoCeleste;
import utilidades.Utilidades;

/**
 * Lanzador de la clase CuerpoCeleste. Contiene el main para su ejecución.
 * 
 * @author Adrián Arjona
 * @version 1.0 Febrero 2023
 */
public class LanzadorCuerpoCeleste {
    
    /* Francisco Adrián Arjona Bravo
    UNIDAD 6: almacenando datos.
    */
    
    private static File fichero = new File("sistemasolar.dat") ;
    private static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    

    // ------------------------------------------------------------
    // -------------------- MÉTODO MAIN ---------------------------
    // ------------------------------------------------------------
    
    
    /**
     * Método main para CuerpoCeleste.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        int opcion ;
        boolean salir = false ;
        
        System.out.println("----------------------");
        System.out.println("    ¡BIENVENIDO/A!    ");
        System.out.println("----------------------\n");
        
        do 
        {
            MetodosCuerpoCeleste.mostrarMenu();
                
            opcion = Utilidades.leerEnteroBuffer("\nElige una cpción: ") ;

            switch(opcion)
            {
                case 1: // AÑADIR REGISTRO
                    aniadirCuerpoCeleste() ;
                    break ;

                case 2: // LISTAR REGISTROS
                    listarCuerpoCeleste() ;
                    break ;

                case 3: // BUSCAR REGISTRO POR CÓDIGO
                    buscarCuerpoCelestePorCodigo() ;
                    break ;

                case 4: // BUSCAR REGSITRO POR TIPO
                    buscarCuerpoCelestePorTipo() ;
                    break ;

                case 5: // ELIMINAR REGISTRO
                    eliminarCuerpoCeleste() ;
                    break ;

                case 6: // ELIMINAR FICHERO COMPLETO
                    eliminarFichero() ;
                    break ;
                    
                case 7: // SALIR
                    salir = !Utilidades.secuenciaSalida("\n¿Quieres salir del programa?") ;
                    break ;

                default:
                    System.out.println("\nDebes elegir una opción válida (1-7).");
                    break ;
            }
            
        } while (!salir);
        
        System.out.println("\n --------- ¡GRACIAS POR UTILIZAR EL PROGRAMA! ----------\n");
    }
    
    
// ------------------ MÉTODOS DEL MENÚ ------------------------------
    
    
    /**
     * Método privado que añade cuerpos celestes.
     */
    private static void aniadirCuerpoCeleste(){
        
        short codigoCuerpo ;
        String nombre ;
        String tipoObjeto ;
        int diametro ;
        
        boolean validador ;
        
        abrir() ;
        
        do // Pide y comprueba el código hasta que sea válido
        {
            codigoCuerpo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste (3 dígitos max.):") ;
            validador = MetodosCuerpoCeleste.compruebaCodigo(codigoCuerpo) ;
            
        } while (!validador);
        
        validador = false ;
        
        do // Pide y comprueba el nombre hasta que sea válido
        {
            nombre = Utilidades.leerStringBuffer("\nIntroduce en el nombre del cuerpo celeste (15 caracteres max.):") ;
            validador = MetodosCuerpoCeleste.compruebaNombre(nombre) ;
            
        } while (!validador);
        
        validador = false ;
        
        // Pedimos el tipo de objeto
        
        tipoObjeto = Utilidades.leerStringBuffer("\nIntroduce el tipo de cuerpo celeste:") ;
        
        do // Pide y comprueba el diámetro hasta que sea válido
        { 
            diametro = Utilidades.leerEnteroBuffer("\nIntroduce el diámetro (6 dígitos max.):") ;
            validador = MetodosCuerpoCeleste.compruebaDiametro(diametro) ;
            
        } while (!validador);
        
        /*
            Hemos terminado de pedir los datos y han sido comprobados. Si son 
            válidos continuamos almacenándolos.
        */
        
        if (cuerposCelestes.isEmpty()) // Si el array está vacío...
        {
            cuerposCelestes = new ArrayList<CuerpoCeleste>() ; // ... créalo.
        }
        
        try
        {
            cuerposCelestes.add(new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro)) ;
        }
        catch(ExcepcionCuerpoCeleste e){
            
            System.out.println(e.getMessage());
        }
        
        escribirArchivo();
        System.out.println("\nCuerpo Celeste " + cuerposCelestes.size()+ " añadido");
    }
    
    
    /**
     * Método que nos permite visualizar todos los datos almacenador.
     * Primero comprobamos que el fichero exista.
     * Si existe, lo abrimos y comprobamos que no esté vacío recorriendo todo su contenido.
     */
    private static void listarCuerpoCeleste(){
        
        if (!fichero.exists()) 
        {
            System.out.println("\nNO EXISTEN DATOS");
        }
        else
        {
            abrir() ;
            
            if (cuerposCelestes != null) 
            {
                int contador = 1 ;
                
                for (CuerpoCeleste objeto: cuerposCelestes) 
                {
                    System.out.println("Registro nº " + contador + " - "  + objeto.toString());
                    contador++ ;
                }
            }
            else
            {
                System.out.println("\nNo existen registros de cuerpos celestes.");
            }
        }
    }
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su código.
     */
    private static void buscarCuerpoCelestePorCodigo(){
        
        int contador ;
        boolean encontrado = false ;
        
        do
        {
            short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;
        
            abrir() ;
            
            contador = 1 ;

            for (CuerpoCeleste cuerpoCeleste: cuerposCelestes) 
            {
                if (cuerpoCeleste.getCodigoCuerpo() == codigo) 
                {
                    encontrado = true ;
                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                }
                
                contador++ ;
            }
            
            if (!encontrado) 
            {
                System.out.println("\nREGISTRO NO ENCONTRADO.");
            }
            
        } while (!Utilidades.secuenciaSalida("¿Quieres buscar otro registro?"));
    }
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su tipo.
     */
    private static void buscarCuerpoCelestePorTipo(){
        
        int contador ;
        boolean encontrado = false ;
        
        do
        {
            String tipo = Utilidades.leerStringBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;
        
            abrir() ;
            
            contador = 1 ;

            for (CuerpoCeleste cuerpoCeleste: cuerposCelestes) 
            {
                if (cuerpoCeleste.getTipoObjeto().equalsIgnoreCase(tipo)) 
                {
                    encontrado = true ;
                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                }
                
                contador++ ;
            }
            
            if (!encontrado) 
            {
                System.out.println("\nNO EXISTEN CUERPOS CELESTES DE ESE TIPO.");
            }
            
        } while (!Utilidades.secuenciaSalida("¿Quieres buscar otro registro?"));
    }
    
    
    /**
     * Método similar al anterior pero que en lugar de limitarse a mostrarnos el 
     * resultado de la búsqueda, nos permite decidir si deseamos elminar el 
     * registro encontrado.
     */
    private static void eliminarCuerpoCeleste(){ // NO FUNCIONA CORRECTAMENTE, VOY A SEGUIR Y LUEGO LO ATIENDO
        
        /*
        Uno de los errores es que elmina una entrada. Poniendo 1 como código, por ejemplo, 
        ha dado un error pero ha borrado la entrada 1 del fichero. Eso no debería ocurrir porque 
        el código no coincide con 1.
        */
        
        int contador ;
        boolean encontrado ;
        
        try
        {
            do 
            {
                short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas eliminar: ") ;
        
                abrir() ;

                contador = 1 ;
                
                encontrado = false ;

                for(CuerpoCeleste cuerpoCeleste: cuerposCelestes)
                {
                    if (cuerpoCeleste.getCodigoCuerpo() == codigo)
                    {
                        encontrado = true ;
                        System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                        
                        if (!Utilidades.secuenciaSalida("¿Quiere eliminar este registro?")) 
                        {
                            cuerposCelestes.remove((contador - 1)) ;
                            escribirArchivo() ;
                            System.out.printf("\nREGISTRO Nº%d ELIMINADO", contador);
                        }
                    }
                    
                contador++ ;
                }
            
                if (!encontrado) 
                {   
                    System.out.println("\nREGISTRO NO ENCONTRADO.") ;
                }
            
            } while (!Utilidades.secuenciaSalida("\n¿Quieres buscar otro registro?"));
        }
        catch(ConcurrentModificationException e){
            System.err.println("");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Método que nos elimina el fichero de datos del disco.
     */
    private static void eliminarFichero(){
        
        boolean respuesta ;
        boolean borrado ;
        
        try
        {
            respuesta = Utilidades.secuenciaSalida("\n¿Desea eliminar el fichero completo?") ;
            
            if (!respuesta)
            {
                borrado = fichero.delete() ;
                
                if (borrado) 
                {
                    System.out.println("\nFICHERO DE DATOS ELMINADO.");
                    cuerposCelestes.clear();
                }
            }
            else
            {
                System.out.println("\nNO SE HA REALIZADO NINGUNA ACCIÓN.");
            }
        }
        catch (Exception e){
            System.err.println("\nAlgún error ocurrió: " + e.getMessage());
        }
    }

// ------------------   MÉTODOS DE APOYO -------------------------
    
    /**
     * Método que nos abre el fichero de datos para cargar su contenido en el array "cuerposCelestes".
     * Previamente comprueba si el fichero exsite y, si es así, carga su contenido en el ArrayList.
     * Luego cierra el fichero. Si por cualquier motivo no se puede leer el disco (está creado 
     * pero no tiene datos) nos avisa que el fichero está vacío.
     */
    private static void abrir(){
            
        try
        {
            if (!fichero.exists()) 
            {
                crearArchivo() ;
            }
            else
            {
                if (fichero.canRead())
                {
                    FileInputStream fis = new FileInputStream(fichero) ;
                    ObjectInputStream ois = new ObjectInputStream(fis) ;
                    cuerposCelestes = (ArrayList<CuerpoCeleste>)ois.readObject() ;
                    ois.close();
                    fis.close();                        
                }
                else
                {
                    System.out.println("\nFICHERO VACÍO.") ;
                }
            }
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("\nError: " + e.getMessage()) ;
        }
    }
    
    /**
     * Método que nos crea el fichero. Válido para cuando se comprueba que no existe.
     */
    private static void crearArchivo(){
        
        try
        {
            fichero.createNewFile() ;
            System.out.println("\nFichero creado.");
        }
        catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        }
    }
    
    
    /**
     * Método que nos escribe el ArrayList en el fichero de disco. Es la manera 
     * de guardar los datos serializados ya que la clase CuerpoCeleste lo está.
     */
    private static void escribirArchivo(){
        
        try
        {
            if (!fichero.exists())
                fichero = new File("sistemasolar.dat");
            FileOutputStream fos = new FileOutputStream(fichero) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(cuerposCelestes);
            oos.close();
            fos.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 
}
