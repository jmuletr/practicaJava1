
public class Caesar {
    static String cypher(String s, int delta) {
        s = s.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (delta > 26){
                delta = delta % 26;
            }
            if (s.charAt(i) >= 0 && s.charAt(i) < 65 || s.charAt(i) > 90){
                s2.append(s.charAt(i));
            }
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90){
                if (s.charAt(i) + delta > 90){
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + delta - 26);
                    s2.append(ch2);
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + delta);
                    s2.append(ch2);
                }
            }
        }
        return s2.toString();
    }

    static String decypher(String s, int delta) {
        s = s.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (delta > 26){
                delta = delta % 26;
            }
            if (s.charAt(i) >= 0 && s.charAt(i) < 65 || s.charAt(i) > 90){
                s2.append(s.charAt(i));
            }
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90){
                if (s.charAt(i) - delta < 65){
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch - delta + 26);
                    s2.append(ch2);
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch - delta);
                    s2.append(ch2);
                }
            }
        }
        return s2.toString();
    }

    static String magic(String s) {
        return null;
    }
}
