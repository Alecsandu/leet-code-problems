public class LengthOfLastWord {

    public static void main(String[] args) {
        Solver solver = new Solver();
        System.out.println(solver.lengthOfLastWord("Hello World"));
        System.out.println("Expected is 5");
        System.out.println(solver.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("Expected is 4");
        System.out.println(solver.lengthOfLastWord("luffy is still joyboy"));
        System.out.println("Expected is 6");
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

}
