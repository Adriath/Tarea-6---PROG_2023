
package utilidades;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilidades.excepciones_utilidades.ExcepcionDecisionUsuario;

/**
 * Clase dedicada a métodos que ayuden al desarrollo de la tarea.
 * Ejemplo: un método para leer por pantalla una cadena de caracteres.
 * 
 * @author Adrián Arjona
 */
public class Utilidades {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 6: almacenando datos.
    */
    
     /**
     * Método que pide al usuario una cadena de caracteres pudiendo personalizar 
     * el mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide la cadena al usuario.
     * @return String mensaje. Devuelve la cadena introducida por el usuario.
     */
    public static String leerString(String msg){
    
        Scanner entrada = new Scanner(System.in) ;
        
        System.out.println(msg);
        String mensaje = entrada.nextLine() ;
        
        return mensaje ;
    }
    
     /**
     * Método que pide al usuario un número entero pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return int entero. Devuelve el número introducido por el usuario.
     */
    public static int leerEntero(String msg){
        
        int entero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                entero = Integer.parseInt(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("\nNo has introducido un número entero.");
            }
            catch (Exception e) {
                
                System.out.println("\nNo has introducido un número entero.");
            }
        } while (!validador);

     
        return entero ;
    }
    
    
     /**
     * Método que pide al usuario un número corto pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return byte. Devuelve el n�mero introducido por el usuario.
     */
    public static byte leerByte(String msg){
        
        byte numero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                numero = Byte.parseByte(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("\nNo has introducido un número válido.");
            }
            catch (Exception e) {
                
                System.out.println("\nNo has introducido un número válido.");
            }
        } while (!validador);

     
        return numero ;
    }
    
    /**
     * Método que crea un objeto de tipo BufferedReader para leer una cadena de 
     * caracteres.
     * 
     * @param msg. Tipo String. Es el mensaje con el que se pide los datos al usuario/a.
     * @return mensaje. String. Devuelve el mensaje introducido por el/la usuario/a.
     */
    public static String leerStringBuffer(String msg){
    
        String mensaje = "" ;
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
        try
        {
        mensaje = dato.readLine() ;    
        }
        catch(IOException e){
            System.out.println("\nError de entrada de datos.");
        }
        catch(Exception e){
            System.out.println("\nHa ocurrido algún error.");
        }
        
        return mensaje ;
    }
    
    
    /**
     * Método que crea un objeto de tipo BufferedReader para leer un número entero
     * introducido por el/la usuario/a.
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Int. Devuelve el número introducido por el/la usuario/a.
     */
    public static int leerEnteroBuffer(String msg){
    
        int numero = 0 ;
        boolean validador = false ;
        
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
            do 
            {
                try
                {
                numero = Integer.parseInt(dato.readLine()) ;
                validador = true ;
                }
                catch (NumberFormatException e){
                    System.out.println("\nTienes que introducir un número entero.");
                }
                catch(IOException e){
                    System.out.println("\nError de entrada de datos.");
                }
                catch(Exception e){
                    System.out.println("\nHa ocurrido algún error.");
                }
                
            } while (!validador);
        
        return numero ;
    }
    
    
      
    /**
     * Método que crea un objeto de tipo BufferedReader para leer un número corto
     * introducido por el/la usuario/a.
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Short. Devuelve el número introducido por el/la usuario/a.
     */
    public static short leerShortBuffer(String msg){
    
        short numero = 0 ;
        boolean validador = false ;
        
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
            do 
            {
                try
                {
                numero = Short.parseShort(dato.readLine()) ;
                validador = true ;
                }
                catch (NumberFormatException e){
                    System.out.println("\nTienes que introducir un número no demasiado largo.");
                }
                catch(IOException e){
                    System.out.println("\nError de entrada de datos.");
                }
                catch(Exception e){
                    System.out.println("\nHa ocurrido algún error.");
                }
                
            } while (!validador);
        
        return numero ;
    }
    
    
    /**
     * Método que valida la respuesta del usuario respecto a si continuar la 
     * ejecución.
     * 
     * @param msj String. Mensaje introducido por el usuario.
     * @return boolean valido. Devuelve si es válida la respuesta (true) o no (false).
     */
    public static boolean compruebaDecisionUsuario(String msj)throws ExcepcionDecisionUsuario{
        String si = "s" ;
        String no = "n" ;
        boolean valido = false ;
        
        if (msj.equalsIgnoreCase(si) ^ msj.equalsIgnoreCase(no)) // Si el mensaje introducido es igual a "s" o "n" será válido...
        {
           valido = true ;
        }
        else // ...de lo contrario no y saltará la excepción.
        {
            throw new ExcepcionDecisionUsuario("\nTienes que decir sí \"s/S\" o no \"n/N\".") ;
        }
        
        return valido ;
    }
    
    
    
    /**
     * Método que extraerá la decisión del usuario, previamente validada con el método compruebaDecisionUsuario().
     * 
     * @param decision String. Mensaje al usuario/a.
     * @see Utilidades.compruebaDecisionUsuario()
     * @return tipo boolean. Devuelve false si la respuesta es positiva y true si la respuesta es negativa.
     */
    public static boolean distingueEntreSiYNo(String decision){
        
        boolean respuesta = false ;
        
        if (decision.equalsIgnoreCase("s")) // Si la decisión del usuario/a es "s/S"...
        {
            respuesta = false ; // ...respuesta será false.
        }
        else if (decision.equalsIgnoreCase("n")) // Si la decisión del usuario/a es "n/N"...
        {
            respuesta = true ; // ...la respuesta será true.
        }
        
        return respuesta ;
    }
    
    /**
     * Método que unifica los métodos compruebaDecisionUsuario() y distingueEntreSiYNo().
     * Preguntará al usuario/a si quieres salir. Si la respuesta es válida la almacenará y evaluará.
     * 
     * @return boolean validador. Devuelve la decision del usuario/a según seá sí o no.
     * @see Utilidades.compruebaDecisionUsuario()
     * @see Utilidades.distingueEntreSiYNo()
     */
    public static boolean secuenciaSalida(){
        
        String decision ;
        boolean validador = false ;
        
        do // Ejecuta hasta que la decisión del usuario/a sea válida.
            {                
                decision = Utilidades.leerString("\n¿Quieres salir del programa? (s/n)\n") ; // Pregunta al usuario/a si quiere continuar.
            
                try 
                {
                    validador = Utilidades.compruebaDecisionUsuario(decision) ; // Comprueba si la decisión es válida...
                } 
                catch (ExcepcionDecisionUsuario e) {
                    
                    System.out.println(e.getMessage()); // ...y si no lo es capturará la excepción.
                }
                
            } while (!validador); // Sale del bucle si la respuesta es válida.
            
        validador = Utilidades.distingueEntreSiYNo(decision) ; // Dependiendo de la decisión que se haya tomado (sí o no) se seguirá o no la ejecución.
        
        return validador ;
    }
    
    /**
     * Método que calcula un número aleatorio entre 1 y 3.
     * 
     * @param num. Tipo int. Es el número máximo hasta el que hará el cálculo.
     * @return int numero. Devuelve 1, 2 ó 3.
     */
    public static int numeroAleatorio(int num){
        
                
        int numero = (int)(Math.random()*num+1) ;
        
        return numero ;
    }
    
}
