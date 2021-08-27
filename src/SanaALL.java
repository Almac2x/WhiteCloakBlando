public class SanaALL {
    private static final String OPEN_BRACKET = "{";
    private static final String CLOSED_BRACKET = "}";
    private static final String EMPTY_STRING = "";

    // Function to break a string into all possible combinations of
    // non-overlapping substrings enclosed within parenthesis
    public static void recur(String s, int i, String out)
    {
        if (i == s.length()) {
            System.out.print(out +", ");
        }

        // consider each substring `S[i, j]`
        for (int j = s.length() - 1; j >= i; j--)
        {
            String sub_str =  s.substring(i, j + 1);

            // append the substring to the result and recur with an index of
            // the next character to be processed and the result string
            recur(s, j + 1, out + sub_str);
        }
    }

    public static void main(String[] args)
    {
        // input string
        final String s = "ABCaD";

        int starting_index = 0;
        recur(s, starting_index, "");
    }
}
