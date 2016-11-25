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
        System.out.println(Arrays.deepToString(missatge));
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
        String sp = key + s;
        char[][] missatge = arraymissatge(sp, key.length());
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
        return null;
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
                if (pos < s.length() && !(y == missatgedec.length - 1 && x <= (s.length() - missatgedec.length * missatgedec[0].length))){
                    missatgedec[y][x]= s.charAt(pos);
                    pos++;
                    y++;
                    System.out.println(Arrays.deepToString(missatgedec));
                } else if (y == missatgedec.length - 1 ){
                    missatgedec[y][x]= 0;
                    y++;
                    System.out.println("valor 0: ");
                    System.out.println(Arrays.deepToString(missatgedec));
                } else {
                    y++;
                }
            }
            x++;
            y = 0;
        }
        return missatgedec;
    }

}
