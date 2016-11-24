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


    static String cypher(String s, String key) {
        return null;
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

}
