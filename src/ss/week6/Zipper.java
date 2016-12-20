package ss.week6;

public class Zipper {
    /*@
       requires s1 != null & s2 != null;
       requires s1.length() == s2.length();
     */
    public static String zip(String s1, String s2) {
        String result = "";
        for (int i = 0; i < s1.length(); i++) {
            result += Character.toString(s1.charAt(i))
                              + Character.toString(s2.charAt(i));
        }
        return result;
    }

    /*@
       requires s1 != null & s2 != null;
       requires s1.length() == s2.length();
    */
    public static String zip2(String string1, String string2) throws TooFewArgumentsException, ArgumentLengthsDifferException {
        if (string1 == null || string2 == null) {
            throw new TooFewArgumentsException("error: must pass two command line arguments");
        } else if (string1.length() != string2.length()) {
            throw new ArgumentLengthsDifferException(string1.length(), string2.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string1.length(); i++) {
            sb.append(string1.charAt(i));
            sb.append(string2.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s1 = args.length >= 1 ? args[0] : null;
        String s2 = args.length >= 2 ? args[1] : null;
        if (s1 == null || s2 == null) {
            System.out.println("error: must pass two command line arguments");
        } else if (s1.length() != s2.length()) {
            System.out.println("error: length of command line arguments "
                                       + "differs (" + s1.length() + ", " + s2.length() + ")");
        } else {
            System.out.println(zip(s1, s2));
        }
    }
}
