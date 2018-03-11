import java.util.ArrayList;


//RECIBE UN CONJUNTO DE REGLAS PARA ANALIZAR A QUE JERARQUIA PERTENECEN
public class AnalizadorDeJerarquia {

  //VERIFICAR A QUE JERARQUIA PERTENECE EL CONJUNTO DE REGLAS
  public static int verificarTipo(Regla regla){
    int tipo;
    if(longitudParteIzquierdaIgualA1(regla)){
      if(hayUnoOMenosNoTerminales(regla)){
        tipo = EsTipos3(regla);
      }else {
        tipo = 2;
      }
    }else {
      if (parteIzquierdaMenorOIgualAParteDerecha(regla)){
        tipo = 1;
      }else {
        tipo = 0;
      }
    }
    return tipo;
  }

  public static int EsTipos3 (Regla regla) {
    if (empiezaConNoTerminal(regla)){
      return 4;
    }else {
      if (terminaConNoTerminal(regla)){
        return 5;
      }else {
        return 2;
      }
    }
  }



  //VERIFICA QUE LA LONGITUD DE LA PARTE IZQUIERDA SEA IGUAL A 1
  public static boolean longitudParteIzquierdaIgualA1 (Regla regla){
    boolean bandera = false;
    final int longitudParteIzquierda = regla.getParteIzquierda().length();
    bandera = longitudParteIzquierda == 1;
    return bandera;
  }

  //VERIFICA QUE LA LONGITUD DE LA PARTE IZQUIERDA SEA MENOR O IGUAL A LA PARTE DERECHA
  public static boolean parteIzquierdaMenorOIgualAParteDerecha (Regla regla){
    Boolean bandera = false;
    bandera = regla.getParteIzquierda().length() <= regla.getParteDerecha().length();
    return bandera;
  }

  //VERIFICA QUE LA PARTE DERECHA DEL CONJUNTO DE REGLAS EMPIECEN CON 1 NO TERMINAL
  public static boolean empiezaConNoTerminal (Regla regla){
    boolean bandera = false;
    bandera = Character.isUpperCase(regla.getParteDerecha().charAt(0));
    return bandera;
  }

  //VERIFICA QUE LA PARTE DERECHA DEL CONJUNTO DE REGLAS TERMINEN CON 1 NO TERMINAL
  public static boolean terminaConNoTerminal (Regla regla){
    boolean bandera = false;
    int i = regla.getParteDerecha().length();
    if (Character.isUpperCase(regla.getParteDerecha().charAt(i - 1))){
      bandera = true;
    }else {
      bandera = false;
    }
    return bandera;
  }

  //VERIFICA QUE HAYA UNO O MENOS NO TERMINALES EN LA PARTE DERECHA
  public static boolean hayUnoOMenosNoTerminales (Regla regla){
    boolean bandera = false;
    int noTerminales = Regla.contarNoTerminales(String.valueOf(regla));
    bandera = noTerminales <= 1;
    return bandera;
  }
}
