
public class Caesar {
    static String cypher(String s, int delta) {
        s = work(s, delta, true);
        //En acabar retorna s encriptat.
        return s;
    }

    static String decypher(String s, int delta) {
        s = work(s, delta, false);
        //En acabar retorna s desencriptat.
        return s;
    }

    static String work(String s, int key, boolean op) {
        //Es pasa el String a majuscules
        s = s.toUpperCase();
        //Variable s2(string2) on es generara el missatge tractat.
        StringBuilder s2 = new StringBuilder();
        //Bucle per treballar amb tot el string.
        for (int i = 0; i < s.length(); i++) {
            //fer que delta no sigui major que 26 i es pugui treballar amb ell.
            if (key > 26) {  //TODO fer que accepti delta negatiu.
                key = key % 26;
            }
            //Comprovacio de si el caracter no es una lletra majuscula
            if (s.charAt(i) >= 0 && s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
                s2.append(s.charAt(i));
            }
            //comprovacio si s'ha de desencriptar o encriptar.
            if (!op) {
                //Comprovacio si el caracter es una lletra majuscula
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    /**Per a descifrar el missatge es mira que el caracter menys delta no sigui menor a 65(A) i
                     si o es se li suma 26 per tornar a 90(Z).**/
                    if (s.charAt(i) - key < 'A') {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch - key + 26);
                        s2.append(ch2);
                        //si el caracter menys delta no es menor a 65(A) se fica directament a s2.
                    } else {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch - key);
                        s2.append(ch2);
                    }
                }
            } else {
                //Comprovacio si el caracter es una lletra majuscula
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    /**Si el caracter mes delta es major a 90(Z) es guarda el caracter a ch(character)
                     i a ch2(character2) es guarda el caracter mes delta i se li resta 26 per a que el valor minim sigui 65(A),
                     i despres s'afelleix el caracter ch2 a la variable s2.**/
                    if (s.charAt(i) + key > 'Z') {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch + key - 26);
                        s2.append(ch2);
                        //Si el valor del caracter mes delta no pasa de 90(Z) s'afegeix ch2 directament a s2.
                    } else {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch + key);
                        s2.append(ch2);
                    }
                }
            }
        }
        //retorna s2 com a string.
        return s2.toString();
    }

    static String magic(String s) {
        s = s.toUpperCase();
        String s2 = s;
        //bucle que s'executara fins al valor maxim de delta per trobarlo.
        for (int i = 1; i < 26; i++) {
            //es crida la funcio per a descifrar el missatge donant com a valor de delta el valor de i.
            s2 = decypher(s, i);
            //si s2 conte una de les següents paraules que tinguin sentit es dona com a descifrat.
            if (s2.contains(" DE ") || s2.contains(" LA ") || s2.contains(" EL ") || s2.contains(" EN ") || s2.contains(" QUE ") || s2.contains(" ÉS ")) {
                break;
            }
        }
        //es retorna el string s2.
        return s2;
    }
}
