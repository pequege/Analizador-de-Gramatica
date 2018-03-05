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
      reglas.add(regla);
    }
    return reglas;
  }

  //CREA REGLA A PARTIR DE UNA LINEA DE TEXTO
  public static Regla crearRegla (String linea) {
    String[] partes = separarPartes(linea);
    Regla regla = new Regla(partes[0], partes[1]);
    return regla;
  }

  //CONSTRUCTOR DE REGLA
  public Regla (String parteIzquierda, String parteDerecha) {
    this.parteIzquierda = parteIzquierda;
    this.parteDerecha = parteDerecha;
  }

  //SEPARADOR DE PARTE IZQ Y DER DE UNA REGLA
  public static String[] separarPartes (String a) {
    String[] partes = a.split(" → ");
    return partes;
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

  //CUENTA LA CANTIDAD DE NO TERMINALES DE LA PARTE DERECHA DE UNA REGLA
  public int contarNoTerminales () {
    int terminales = 0;
    for (int i = 0; i < this.getParteDerecha().length(); i++) {
      if (Character.isUpperCase(this.getParteDerecha().charAt(i))) {
        terminales++;
      }
    }
    return terminales;
  }
}
