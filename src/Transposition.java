
public class Transposition {
    static String cypher(String s, int dim) {
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < dim; i++) {
            for (int i2 = i; i2 < s.length(); i2 += dim) {
                s2.append(s.charAt(i2));
            }
        }
        return s2.toString();
    }

    static String decypher(String s, int dim) {
        return null;
    }


    static String cypher(String s, String key) {
        return null;
    }

    static String decypher(String s, String key) {
        return null;
    }
}
