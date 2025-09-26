void main() {
    Solver solver = new Solver();
    IO.println(solver.strStr("sadbutsad", "sad"));
    IO.println("Expected result is 0");
    IO.println(solver.strStr("leetcode", "leeto"));
    IO.println("Expected result is -1");
}

private static class Solver {

    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack))
            return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            var hay = haystack.substring(i, i + needle.length());

            if (needle.equals(hay)) {
                return i;
            }
        }
        return -1;
    }

}
