import java.io.IOException;
import java.util.ArrayList;

public class Gramatica {
    public ArrayList<Regla> reglasDeProduccion = new ArrayList<>();
    public Regla axioma;
    public int tipo;

  public void setAxioma(Regla axioma) {
    this.axioma = axioma;
  }

  public void setTipo (int tipo) {
    this.tipo = tipo;
  }

  public Regla getAxioma() {
    return axioma;
  }

  public Gramatica(String gramatica) throws IOException {
    ArrayList<Regla> reglas = Regla.crearReglas(gramatica);
    for (int i = 0; i < reglas.size(); i++){
      if(i == 0){
        setAxioma(reglas.get(i));
      }else {
        reglasDeProduccion.add(reglas.get(i));
      }
    }
  }

  public void mostrarGramatica(){
    System.out.println("Axioma: ");
    axioma.mostrarRegla();
    for (Regla reglaProduccion: reglasDeProduccion) {
      reglaProduccion.mostrarRegla();
    }
  }

  public void analizarJerarquia (){
    setTipo(AnalizadorDeJerarquia.verificarTipo(axioma));
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