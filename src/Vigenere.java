
public class Vigenere {

    static String encode(String s, String password) {
        s = work(s, password, true);
        //En acabar retorna s encriptat.
        return s;
    }

    static String decode(String s, String password) {
        s = work(s, password, false);
        //En acabar retorna s desencriptat.
        return s;
    }

    static String work(String s, String password, boolean op) {
        //Es pasa els String a majuscules i lleva caracters extranys als dos strings.
        s = s.toUpperCase();
        password = password.toUpperCase();
        password = normalitzar(password);
        s = normalitzar(s);
        //Variable s2(string2) on es generara el missatge tractat.
        StringBuilder s2 = new StringBuilder();
        //contador que indicara la posicio del index de la password.
        int cont = 0;
        //Bucle per treballar amb tot el string.
        for (int i = 0; i < s.length(); i++) {
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
                    if (s.charAt(i) - (password.charAt(cont) - 64) < 65) {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch + 26 - (password.charAt(cont) - 64));
                        s2.append(ch2);
                        cont++;
                        //si el caracter menys el valor del caracter de la password no es menor a 65(A) se fica directament a s2.
                    } else {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch - (password.charAt(cont) - 64));
                        s2.append(ch2);
                        cont++;
                    }
                }

            } else {
                //Comprovacio si el caracter es una lletra majuscula
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    /**Si el caracter mes delta es major a 90(Z) es guarda el caracter a ch(character)
                     i a ch2(character2) es guarda el caracter mes delta i se li resta 26 per a que el valor minim sigui 65(A),
                     i despres s'afelleix el caracter ch2 a la variable s2.**/
                    if (s.charAt(i) + (password.charAt(cont) - 64) > 90) {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch + (password.charAt(cont) - 64) - 26);
                        s2.append(ch2);
                        cont++;
                        //Si el valor del caracter mes el valor del caracter de la password
                        // no pasa de 90(Z) s'afegeix ch2 directament a s2.
                    } else {
                        char ch = s.charAt(i);
                        char ch2 = (char) ((int) ch + (password.charAt(cont) - 64));
                        s2.append(ch2);
                        cont++;
                    }
                }
            }
            if (cont == password.length()) {
                cont = 0;
            }
        }
        //retorna s2 com a string.
        return s2.toString();
    }

    public static String normalitzar(String input) {
        // Cadena de caracters a substituir.
        String original = "ÂÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑÇ";
        // Cadena de caracters ASCII.
        String ascii = "AAAAEEEIIIOOOUUUNC";
        String output = input;
        for (int i = 0; i < original.length(); i++) {
            // Reemplaçam els caracters especials.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }
        //retornam el string sense caracters especials.
        return output;
    }
}


