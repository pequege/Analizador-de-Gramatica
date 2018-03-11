import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectordeTexto {
  static String leerArchivo(String urlArchivo, Charset cifrado) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(urlArchivo));
    String texto = new String(encoded, cifrado);
    texto = borrarLambda(texto);
    return texto;
  }

  public static String[] separarLinea(String texto) throws IOException {
    String textoTemporal = leerArchivo(texto, Charset.defaultCharset());
    String lineas[] = textoTemporal.split("\\r?\\n");
    return lineas;
  }

  //BORRAR SIMBOLO LAMBDA
  static String borrarLambda(String texto){
    texto = texto.replace("λ", "");
    return texto;
  }
}
