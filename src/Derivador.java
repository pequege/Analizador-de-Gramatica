import java.util.ArrayList;
import java.util.Random;

public class Derivador {
//  public static String buscarSiguienteNoTerminal (String palabra){
//    String siguienteNoTerminal = "";
//    for (int i = 0; i < palabra.length(); i++){
//      if (Character.isUpperCase(palabra.charAt(i))){
//        siguienteNoTerminal = String.valueOf(palabra.charAt(i));
//        palabra = palabra.replace(String.valueOf(palabra.charAt(i)), "");
//        break;
//      }
//    }
//    return siguienteNoTerminal;
//  }

  public static String BuscarNoTerminalEnRegla(Regla regla, String noTerminal){
    String parteIzquierda = regla.getParteIzquierda();
    String derivacion = "";
    for (int i = 0; i < parteIzquierda.length(); i++){
      if (String.valueOf(parteIzquierda.charAt(i)).equals(noTerminal)){
        derivacion = regla.getParteDerecha();
        break;
      }
    }
    return derivacion;
  }

//  public static boolean tieneNoTerminales(String palabra){
//    boolean bandera = false;
//    for (int i = 0; i < palabra.length(); i++){
//      if (Character.isUpperCase(palabra.charAt(i))){
//        bandera = true;
//      }
//    }
//    return bandera;
//  }

  public static int NumeroAlAzar (int longitud){
    Random random = new Random();
    int numeroAlAzar = random.nextInt(longitud);
    return numeroAlAzar;
  }

  public static String derivarPalabra(ArrayList<Regla> axioma, ArrayList<Regla> reglas){
    int indiceAlAzar = NumeroAlAzar(axioma.size());
    String palabra = axioma.get(indiceAlAzar).getParteDerecha();
    String palabraDerivada = "";
    String derivacion = "";
    String siguienteNoTerminal;
    for (int i = 0; i < palabra.length(); i++){
      if (Character.isUpperCase(palabra.charAt(i))) {
        siguienteNoTerminal = String.valueOf(palabra.charAt(i));
        for (Regla regla : reglas) {
          derivacion = BuscarNoTerminalEnRegla(regla, siguienteNoTerminal);
          System.out.println("sig no terminal: " + siguienteNoTerminal);
          System.out.println("Derivacion: " + derivacion);
        }
        palabra = palabra.replace(String.valueOf(palabra.charAt(i)), ""); //borrarNoterminal
        System.out.println("palabra temporal: " + palabra);
        palabraDerivada = palabra.replace(siguienteNoTerminal, derivacion);
      }
    }
    return palabraDerivada;
  }
}
