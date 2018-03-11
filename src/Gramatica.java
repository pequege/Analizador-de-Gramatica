import java.io.IOException;
import java.util.ArrayList;

public class Gramatica {
    public ArrayList<Regla> reglasDeProduccion = new ArrayList<>();
    public ArrayList<Regla> axioma = new ArrayList<>();
    public int tipo;

  public void setAxioma (ArrayList<Regla> axioma) {
    this.axioma = axioma;
  }

  public void setTipo (int tipo) {
    this.tipo = tipo;
  }

  public ArrayList<Regla> getAxioma() {
    return axioma;
  }

  public Gramatica(String gramatica) throws IOException {
    ArrayList<Regla> reglas = Regla.crearReglas(gramatica);
    for (int i = 0; i < reglas.size(); i++){
      String parteIzquierda = reglas.get(i).getParteIzquierda();
      if (Regla.verificarRegla(parteIzquierda)){
        if(parteIzquierda.equals("S")){
          axioma.add(reglas.get(i));
        }else {
          reglasDeProduccion.add(reglas.get(i));
        }
      }else {
        System.err.println("ERROR: no se puede crear gramática");
        break;
      }
    }
  }

  public void mostrarGramatica(){
    System.out.println("Axioma: ");
    for (Regla axiomas: axioma) {
      axiomas.mostrarRegla();
    }
    System.out.println("Reglas de produccion: ");
    for (Regla reglaProduccion: reglasDeProduccion) {
      reglaProduccion.mostrarRegla();
    }
  }

  public void analizarJerarquia (){
    for (Regla axiomas :axioma) {
      setTipo(AnalizadorDeJerarquia.verificarTipo(axiomas));
    }
    for (Regla regla: reglasDeProduccion) {
      if (tipo > AnalizadorDeJerarquia.verificarTipo(regla)){
        setTipo(AnalizadorDeJerarquia.verificarTipo(regla));
      }
    }
    System.out.println("Gramática: " + Tipos.values()[tipo]);
  }

  public void derivarPalabra(){
    String palabra = Derivador.derivarPalabra(axioma, reglasDeProduccion);
    System.out.println("Palabra derivada: " + palabra);
  }
}