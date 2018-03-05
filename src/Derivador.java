import java.util.ArrayList;

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

  public static String derivarPalabra(Regla axioma, ArrayList<Regla> reglas){
    String palabra = axioma.getParteDerecha();
    System.out.println(palabra);
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