

public class Vigenere {

    static String encode(String s, String password) {
        s = s.toUpperCase();
        password = password.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        s = normalitzar(s);
        password = normalitzar(password);
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 0 && s.charAt(i) < 65 || s.charAt(i) > 90){
                s2.append(s.charAt(i));
            }
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90){
                if (s.charAt(i) + (password.charAt(cont) - 64) > 90){
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + (password.charAt(cont) - 64) - 26);
                    s2.append(ch2);
                    cont++;
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + (password.charAt(cont) - 64));
                    s2.append(ch2);
                    cont++;
                }
            }
            if (cont == password.length()){
                cont = 0;
            }
        }
        return s2.toString();
    }

    static String decode(String s, String password) {
        return null;
    }

    public static String normalitzar(String input) {
        // Cadena de caracters a substituir.
        String original = "áàäéèëâíìïóòöúùuñÂÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        // Cadena de caracters ASCII.
        String ascii = "aaaeeeaiiiooouuunAAAAEEEIIIOOOUUUNcC";
        String output = input;
        for (int i=0; i<original.length(); i++) {
            // Reemplasam els caracters especials.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }
        return output;
    }
}


