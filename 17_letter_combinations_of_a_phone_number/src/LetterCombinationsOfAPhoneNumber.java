import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solver solver = new Solver();
        System.out.println("For digits 23 expected is [ad, ae, af, bd, be, bf, cd, ce, cf]");
        System.out.println("Calculated is " + solver.letterCombinations("23"));
        System.out.println("Calculated is " + solver.letterCombinationsBacktracking("23"));
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    private static class Solver {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            String[] letters = new String[]{
                    "",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
            };

            Queue<String> queue = new LinkedList<>();
            queue.offer("");

            for (char digit: digits.toCharArray()) {
                int pos = digit - '0';
                int size = queue.size();

                while (size-- > 0) {
                    String curLetters = queue.poll();
                    for (char letter : letters[pos].toCharArray()) {
                        queue.offer(curLetters + letter);
                    }
                }
            }

            result.addAll(queue);
            return result;
        }

        private static final String[] KEYS = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        public List<String> letterCombinationsBacktracking(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return result;
            }
            backtracking(result, digits, 0, new StringBuilder());
            return result;
        }

        private void backtracking(List<String> result, String digits, int index, StringBuilder sb) {
            if (index == digits.length()) {
                result.add(sb.toString());
                return;
            }
            String letters = KEYS[digits.charAt(index) - '0'];
            for (char letter : letters.toCharArray()) {
                sb.append(letter);
                backtracking(result, digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}