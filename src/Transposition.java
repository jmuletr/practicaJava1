import java.util.Arrays;

public class Transposition {
    static String cypher(String s, int dim) {
        StringBuilder s2 = new StringBuilder();
        //cridam la funcio arraymissatge per generar un array amb el contingut de s i dimensio de x el tamany de dim.
        char[][] missatge = arraymissatge(s, dim);
        //bucle que fica els caracter del array a la variable s2 de llegint l'array de manera vertical.
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }
        //retornam el missatge codificat com a string.
        return s2.toString();
    }

    static String decypher(String s, int dim) {
        StringBuilder s2 = new StringBuilder();
        //es crida la funcio arraymissatgedec(array del missatge decodificat) per crear l'arrai per decodificar el missatge.
        char[][] missatge = arraymissatgedec(s, dim);
        //es fa el mateix que per codificar pero llegint l'array de manera horitzontal.
        for (int y = 0; y < missatge.length; y++) {
            for (int x = 0; x < missatge[0].length; x++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }
        //es retorna el missatge decodificat com a string.
        return s2.toString();
    }


    static String cypher(String s, String key) {
        StringBuilder s2 = new StringBuilder();
        //es fa el mateix per codificar que a l'anterior pero substituint la variable dim per una key(contrasenya).
        char[][] missatge = arraymissatge(s, key.length());
        //es crida la funcio desordenar per ordenar l'array mitjançant la key.
        missatge = desordenar(missatge, key);
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }
        //es retorna el missatge codificat com a string.
        return s2.toString();
    }

    static String decypher(String s, String key) {
        StringBuilder s2 = new StringBuilder();
        //es crida la funcio arraymissatgedeck per crear l'array decodificat amb la key.
        char[][] missatge = arraymissatgedeck(s, key.length(), key);
        //es crida la funcio ordenar per ordenar l'array amb les posicions que indiqui la key.
        missatge = ordenar(missatge, key, s);
        for (int y = 0; y < missatge.length; y++) {
            for (int x = 0; x < missatge[0].length; x++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }
        //es retorna el missatge decodificat com a string.
        return s2.toString();
    }

    static char[][] arraymissatge(String s, int dim) {
        //contador per controlar l'index del string s.
        int pos = 0;
        //comprobam que el string capiga dins l'array si no afegim una altra filera a l'array.
        double dimy = (double) s.length() / dim;
        if (dimy > s.length() / dim) {
            dimy++;
        }
        char[][] missatge = new char[(int) dimy][dim];
        for (int y = 0; y < missatge.length; y++) {
            //introduim cada caracter de s al array de manera horitzontal.
            for (int x = 0; x < missatge[0].length; x++) {
                if (pos < s.length()) {
                    missatge[y][x] = s.charAt(pos);
                    pos++;
                    //per asegurar que les posicions del array sobrants no contenguin res lis donam el valor ascii 0(null).
                } else {
                    missatge[y][x] = 0;
                }
            }
        }
        //tornam l'array del missatge.
        return missatge;
    }

    static char[][] arraymissatgedec(String s, int dim) {
        int pos = 0;
        double dimy = (double) s.length() / dim;
        if (dimy > s.length() / dim) {
            dimy++;
        }
        char[][] missatgedec = new char[(int) dimy][dim];
        //variables per controlar la posicio x i y.
        int x = 0;
        int y = 0;
        //cream el array del string s de manera vertical.
        while (x < missatgedec[0].length) {
            while (y < missatgedec.length) {
                /**if que mira que y no sigui la darrera posicio i x no sigui dels darrers per comprobar que
                   no sigui una posicio sobrant del array.**/
                if (pos < s.length() && !(y == missatgedec.length - 1 && x >
                        (missatgedec[0].length - 1) -
                                (missatgedec.length * missatgedec[0].length - s.length()))) {
                    missatgedec[y][x] = s.charAt(pos);
                    pos++;
                    y++;
                    //per asegurar que les posicions del array sobrants no contenguin res lis donam el valor ascii 0(null).
                } else {
                    missatgedec[y][x] = 0;
                    y++;
                }
            }
            //s'aumenta el valor de x i es posa a 0 el contador de y.
            x++;
            y = 0;
        }
        //es retorna l'array del missatge ordenat per a decodificar.
        return missatgedec;
    }

    static char[][] desordenar(char[][] missatge, String key) {
        //transformam la key en un array de chars i l'ordenam alfabeticament.
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        char[][] missatgedes = new char[missatge.length][missatge[0].length];
        //array per gordar l'ordre de la key.
        int[] ordre = new int[missatge[0].length];
        //contador per emprar de index.
        int cont;
        for (int i2 = 0; i2 <= missatge[0].length - 1; i2++) {
            for (cont = 0; cont < key.length(); cont++) {
                //comprovam el valor de key augmentant el contador fins que sigui igual al valor del array chars amb posicio del contador.
                if (key.charAt(i2) == chars[cont]) {
                    //ficam el valor de cont al array ordre a la posicio de i2
                    ordre[i2] = cont;
                    //borram el caracter de la key per no repetirlo.
                    chars[cont] = 0;
                    //aturam el bucle interior per aumentar i2 i comprovar el següent caracter de la key.
                    break;
                }
            }
        }
        //posam el contador a 0 per utilitzarlo de index
        cont = 0;
        //transposam el missatge amb l'ordre de la key alfabeticament.
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                missatgedes[y][ordre[cont]] = missatge[y][x];
            }
            cont++;
        }
        //tornam l'array del missatge amb l'ordre alfabetic de la key.
        return missatgedes;
    }

    static char[][] ordenar(char[][] missatge, String key, String s) {
        //es fa el mateix que al anterior pero  ordenam l'array trasposat.
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        char[][] missatgeord = new char[missatge.length][missatge[0].length];
        int[] ordre = new int[missatge[0].length];
        int cont;
        for (int i2 = 0; i2 <= missatge[0].length - 1; i2++) {
            for (cont = 0; cont < key.length(); cont++) {
                if (key.charAt(i2) == chars[cont]) {
                    ordre[i2] = cont;
                    chars[cont] = 0;
                    break;
                }
            }
        }
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                missatgeord[y][x] = missatge[y][ordre[x]];
            }
        }
        //retornam l'array.
        return missatgeord;
    }

    static char[][] arraymissatgedeck(String s, int dim, String key) {
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        int[] ordre = new int[key.length()];
        int[] ordreorig = new int[key.length()];
        int cont = 0;
        //sercam l'ordre alfabetic de la key i l'ordre original.
        for (int i2 = 0; i2 <= key.length() - 1; i2++) {
            for (cont = 0; cont < key.length(); cont++) {
                if (key.charAt(i2) == chars[cont]) {
                    ordre[i2] = cont;
                    chars[cont] = 0;
                    ordreorig[cont] = i2;
                    break;
                }
            }
        }

        int pos = 0;
        double dimy = (double) s.length() / dim;
        if (dimy > s.length() / dim) {
            dimy++;
        }
        char[][] missatge = new char[(int) dimy][dim];
        //ficam el caracter del string al array missatge si no es una de les posicions sobrants del array.
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                if (!((y == missatge.length - 1) && (ordreorig[x] >= ordre.length - (missatge.length * missatge[0].length - s.length())))) {
                    missatge[y][x] = s.charAt(pos);
                    pos++;
                } else {
                    missatge[y][x] = 0;
                }
            }
        }
        //tornam l'array del missatge..
        return missatge;
    }

}
