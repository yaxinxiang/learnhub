package lmytest.p4;

public class StringNormalize {
    public static String normalize(String in) {
        StringBuilder out = new StringBuilder();
        String l = in.toLowerCase();
        for (int i = 0; i < l.length(); ++i) {
            char c = l.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                out.append(c);
            }
        }
        return out.toString();
    }
}
