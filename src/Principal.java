import java.io.IOException;

public class Principal {
  public static void main(String[] args) throws IOException {
    final String asd = "/home/pequege/IdeaProjects/AnalizadorDeGramaticas/src/gramaticaDePrueba.txt";
    Gramatica gramatica = new Gramatica(asd);
    gramatica.mostrarGramatica();
    gramatica.analizarJerarquia();
    //String a = "Jamiroquai";
    //a.replace("Jami", "Tu Hermana");
    //System.out.println(a);
    gramatica.derivarPalabra();
  }
}
