
public class Caesar {
    static String cypher(String s, int delta) {
        s = s.toUpperCase();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (delta > 50){
                delta = 26 - (delta/25);
            }
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90){
                System.out.println(s.charAt(i));
                if (s.charAt(i) + delta > 90){
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + delta - 26);
                    s2.append(ch2);
                } else {
                    char ch = s.charAt(i);
                    char ch2 = (char)((int)ch + delta);
                    s2.append(ch2);
                }
                System.out.println(s.charAt(i));
                System.out.println(s2.toString());
            }
        }
        return s2.toString();
    }

    static String decypher(String s, int delta) {
        return null;
    }

    static String magic(String s) {
        return null;
    }
}
