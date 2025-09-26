void main() {
    Solver solver = new Solver();
    IO.println("Expected is : apbqcrds");
    IO.println("Actual is : " + solver.mergeAlternately("abcd", "pqrs"));
}

// https://leetcode.com/problems/merge-strings-alternately/description/
private static class Solver {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0, pos = 0;
        Order order = Order.FIRST_WORD;

        char[] newWord = new char[n + m];
        while (i < n && j < m) {
            if (order == Order.FIRST_WORD) {
                newWord[pos] = word1.charAt(i);
                i++;
                order = Order.SECOND_WORD;
            } else {
                newWord[pos] = word2.charAt(j);
                j++;
                order = Order.FIRST_WORD;
            }
            pos++;
        }

        while (i < n) {
            newWord[pos] = word1.charAt(i);
            i++;
            pos++;
        }

        while (j < m) {
            newWord[pos] = word2.charAt(j);
            j++;
            pos++;
        }

        return new String(newWord);
    }

    private enum Order {
        FIRST_WORD, SECOND_WORD
    }
}
