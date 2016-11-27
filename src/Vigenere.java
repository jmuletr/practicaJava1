

public class Vigenere {

    static String encode(String s, String password) {
        //passam el string de entrada i la password a majuscules.
        s = s.toUpperCase();
        password = password.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        //cridam la funcio normalitzar per llevar els caracters especials del string i la password.
        s = normalitzar(s);
        password = normalitzar(password);
        //contador que indicara la posicio del index de la password.
        int cont = 0;
        //si es un caracter que no sigui una lletra majuscula s'afegeix a s2 directament sense codificar.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 0 && s.charAt(i) < 65 || s.charAt(i) > 90) {
                s2.append(s.charAt(i));
            }
            //Es codifica de la mateixa manera que al cesar per en aquest cas delta es el valor del caracter corresponent de la password.
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                /**per treure el valor de la password es resta 64 al valor del caracter per exemple si el
                 caracter es A el seu valor es 65 i 65 - 64 es 1 aixi que delta per al caracter a codificar
                 valdra 1 despres s'afagiria el valor de ch2 a s2 i s'aumentaria el contador per a pasar al
                 proxim caracter de la password.**/
                if (s.charAt(i) + (password.charAt(cont) - 64) > 90) {
                    char ch = s.charAt(i);
                    char ch2 = (char) ((int) ch + (password.charAt(cont) - 64) - 26);
                    s2.append(ch2);
                    cont++;
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char) ((int) ch + (password.charAt(cont) - 64));
                    s2.append(ch2);
                    cont++;
                }
            }
            /**Aqui es comprova que el contador no sigui major que l'index de la password i si o es el torna
             a 0 per tornar a comensar per el primer valor de la password.**/
            if (cont == password.length()) {
                cont = 0;
            }
        }
        return s2.toString();
    }

    static String decode(String s, String password) {
        s = s.toUpperCase();
        password = password.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        s = normalitzar(s);
        password = normalitzar(password);
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 0 && s.charAt(i) < 65 || s.charAt(i) > 90) {
                s2.append(s.charAt(i));
            }
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                /**es fa el mateix que per codificar pero es resta el valor de la password i
                 si es menor que 65(A) se li suma 26 per a que torni al valor 90(Z).**/
                if (s.charAt(i) - (password.charAt(cont) - 64) < 65) {
                    char ch = s.charAt(i);
                    char ch2 = (char) ((int) ch + 26 - (password.charAt(cont) - 64));
                    s2.append(ch2);
                    cont++;
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char) ((int) ch - (password.charAt(cont) - 64));
                    s2.append(ch2);
                    cont++;
                }
            }
            if (cont == password.length()) {
                cont = 0;
            }
        }
        //retorna el missatge com a string.
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


