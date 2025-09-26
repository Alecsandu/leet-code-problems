void main() {
    Solver solver = new Solver();
    IO.println(solver.lengthOfLastWord("Hello World"));
    IO.println("Expected is 5");
    IO.println(solver.lengthOfLastWord("   fly me   to   the moon  "));
    IO.println("Expected is 4");
    IO.println(solver.lengthOfLastWord("luffy is still joyboy"));
    IO.println("Expected is 6");
}

private static class Solver {

    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean isWord = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !isWord) {
                isWord = true;
                count++;
            } else if (s.charAt(i) != ' ' && isWord) {
                count++;
            } else if (s.charAt(i) == ' ' && isWord) {
                break;
            }

        }

        return count;
    }

}
