void main() {
    Solver solver = new Solver();
    IO.println(solver.longestPalindrome("abCDCCDCef"));
    IO.println(solver.longestPalindrome("abCDC_CDCef"));
    IO.println(solver.longestPalindrome("babad"));
    IO.println(solver.longestPalindrome("cbbd"));
}

private static class Solver {

    public String longestPalindrome(String s) {
        if (s == null || s.isBlank()) {
            return "";
        }
        s = s.trim();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = searchLengthOfPalindrome(s, i, i);
            int even = searchLengthOfPalindrome(s, i, i + 1);
            int temp_max = Math.max(odd, even);

            if (temp_max > end - start) {
                start = i - (temp_max - 1) / 2;
                end = i + temp_max / 2;
            }
        }


        return s.substring(start, end + 1);
    }

    private int searchLengthOfPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
