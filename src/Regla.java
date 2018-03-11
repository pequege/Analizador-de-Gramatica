import java.io.IOException;
import java.util.ArrayList;

public class Regla {
  public String parteIzquierda;
  public String parteDerecha;


  //CONSTRUCTOR DE ARRAY DE REGLAS
  public static ArrayList<Regla> crearReglas (String gramatica) throws IOException {
    ArrayList<Regla> reglas = new ArrayList<>();
    String[] lineas = LectordeTexto.separarLinea(gramatica);
    for (String linea : lineas) {
      Regla regla = crearRegla(linea);
      if (regla.getParteDerecha() != "#"){
        reglas.add(regla);
      }
    }
    return reglas;
  }

  //CREA REGLA A PARTIR DE UNA LINEA DE TEXTO
  public static Regla crearRegla (String linea) {
    ArrayList<String> partes = separarPartes(linea);
    Regla regla = new Regla(partes.get(0), partes.get(1));
    return regla;
  }

  //CONSTRUCTOR DE REGLA
  public Regla (String parteIzquierda, String parteDerecha) {
    this.parteIzquierda = parteIzquierda;
    this.parteDerecha = parteDerecha;
  }

  //SEPARADOR DE PARTE IZQ Y DER DE UNA REGLA
  public static ArrayList<String> separarPartes (String a) {
    ArrayList<String> partes = new ArrayList<>();
    String[] parte = a.split(" → ");
    for (int i = 0; i < parte.length; i++){
      partes.add(parte[i]);
    }
    validarQueLasPartesNoEstenVacias(partes);
    return partes;
  }

  //SI LA PARTE IZQUIERDA O DERECHA ESTÁ VACÍA, DETIENE EL PROGRAMA
  private static void validarQueLasPartesNoEstenVacias (ArrayList<String> partes) {
    switch (partes.size()){
      case 0:
        System.err.println("Gramática inválida: parte izquierda no puede estar vacía");
        System.exit(1);
        break;
      case 1:
        partes.add("#");
        break;
      default:
        break;
    }
  }

  //GETS
  public String getParteIzquierda () {
    return parteIzquierda;
  }

  public String getParteDerecha () {
    return parteDerecha;
  }

  //MOSTRAR UNA REGLA POR CONSOLA
  public void mostrarRegla () {
    System.out.println(getParteIzquierda() + " → " + getParteDerecha());
  }

  //CUENTA LA CANTIDAD DE NO TERMINALES DE UNA REGLA
  public static int contarNoTerminales (String parte) {
    int terminales = 0;
    for (int i = 0; i < parte.length(); i++) {
      if (Character.isUpperCase(parte.charAt(i))) {
        terminales++;
      }
    }
    return terminales;
  }

  //VERIFICAR FORMATO DE REGLA
  public static boolean verificarRegla(String regla){
    boolean bandera = false;
    String parteIzquierda = regla;
    if (parteIzquierda.length() > 0 && contarNoTerminales(parteIzquierda) > 0){
      bandera = true;
    }
    return bandera;
  }
}
