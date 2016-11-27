import java.util.Arrays;

public class Transposition {
    static String cypher(String s, int dim) {
        StringBuilder s2 = new StringBuilder();
        char[][] missatge = arraymissatge(s, dim);
            for (int x = 0; x < missatge[0].length; x++) {
                for (int y = 0; y < missatge.length; y++) {
                    if (missatge[y][x] != 0) {
                        s2.append(missatge[y][x]);
                    }
                }
            }

        return s2.toString();
    }

    static String decypher(String s, int dim) {
        StringBuilder s2 = new StringBuilder();
        char[][] missatge = arraymissatgedec(s, dim);
        for (int y = 0; y < missatge.length; y++) {
            for (int x = 0; x < missatge[0].length; x++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }

        return s2.toString();
    }


    static String cypher(String s, String key) {
        StringBuilder s2 = new StringBuilder();
        char[][] missatge = arraymissatge(s, key.length());
        missatge = desordenar(missatge, key);
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }

        return s2.toString();
    }

    static String decypher(String s, String key) {
        StringBuilder s2 = new StringBuilder();
        char[][] missatge = arraymissatgedeck(s, key.length(), key);
        missatge = ordenar(missatge, key, s);
        for (int y = 0; y < missatge.length; y++) {
            for (int x = 0; x < missatge[0].length; x++) {
                if (missatge[y][x] != 0) {
                    s2.append(missatge[y][x]);
                }
            }
        }

        return s2.toString();
    }

    static char[][] arraymissatge(String s, int dim){
        int pos = 0;
        double dimy = (double) s.length() / dim;
        if (dimy > s.length()/dim){
            dimy++;
        }
        char[][] missatge = new char[(int)dimy][dim];
        for (int y = 0; y < missatge.length; y++) {
            for (int x = 0; x < missatge[0].length; x++) {
                if (pos < s.length()){
                    missatge[y][x]= s.charAt(pos);
                    pos++;
                } else {
                    missatge[y][x]= 0;
                }
            }
        }
        return missatge;
    }
    static char[][] arraymissatgedec(String s, int dim){
        int pos = 0;
        double dimy = (double) s.length() / dim;
        if (dimy > s.length()/dim){
            dimy++;
        }
        char[][] missatgedec = new char[(int)dimy][dim];
        int x = 0;
        int y = 0;
        while (x < missatgedec[0].length){
            while (y < missatgedec.length){
                if (pos < s.length() && !(y == missatgedec.length - 1 && x > (missatgedec[0].length - 1) -(missatgedec.length * missatgedec[0].length - s.length()))){
                    missatgedec[y][x]= s.charAt(pos);
                    pos++;
                    y++;
                } else if (y >= missatgedec.length - 1 ){
                    missatgedec[y][x]= 0;
                    y++;
                } else {
                    y++;
                }
            }
            x++;
            y = 0;
        }
        return missatgedec;
    }
    static char[][] desordenar (char[][] missatge, String key){
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        char[][] missatgedes = new char[missatge.length][missatge[0].length];
        int [] ordre = new int[missatge[0].length];
        int cont;
        for (int i2=0;i2 <= missatge[0].length-1;i2++) {
            for (cont = 0; cont < key.length(); cont++) {
                if (key.charAt(i2) == chars[cont]) {
                    ordre[i2] = cont;
                    chars[cont] = 0;
                    break;
                }
            }
        }
        cont = 0;
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                missatgedes[y][ordre[cont]] = missatge[y][x];
            }
            cont++;
        }
        return missatgedes;
    }

    static char[][] ordenar(char[][] missatge, String key, String s) {//TODO arreglar funcio ordenar
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        char[][] missatgeord = new char[missatge.length][missatge[0].length];
        int [] ordre = new int[missatge[0].length];
        int cont;
        for (int i2=0;i2 <= missatge[0].length-1;i2++) {
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
        System.out.println(Arrays.deepToString(missatgeord));
        return missatgeord;
    }
    static char[][] arraymissatgedeck(String s, int dim, String key){
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        int [] ordre = new int[key.length()];
        int cont = 0;
        for (int i2=0;i2 <= key.length()- 1;i2++) {
            for (cont = 0; cont < key.length(); cont++) {
                if (key.charAt(i2) == chars[cont]) {
                    ordre[i2] = cont;
                    chars[cont] = 0;
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
        for (int x = 0; x < missatge[0].length; x++) {
            for (int y = 0; y < missatge.length; y++) {
                if (!((y == missatge.length - 1) && (ordre[x] >= ordre.length - (missatge.length * missatge[0].length - s.length())))) {
                        missatge[y][x] = s.charAt(pos);
                        pos++;
                    } else {
                        missatge[y][x] = 0;
                    }
                }
            }
        System.out.println(Arrays.deepToString(missatge));
        return missatge;
    }

}
