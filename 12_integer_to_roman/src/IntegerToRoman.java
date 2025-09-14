public class IntegerToRoman {
    public static void main(String[] args) {
        Solver solver = new Solver();
        System.out.println("Integer to roman for 3749 is MMMDCCXLIX, calculated is " + solver.intToRoman(3749));
        System.out.println("Integer to roman for 58 is LVIII, calculated is " + solver.intToRoman(58));
        System.out.println("Integer to roman for 1994 is MCMXCIV, calculated is " + solver.intToRoman(1994));
    }

    // https://leetcode.com/problems/integer-to-roman/description/
    private static class Solver {

        private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < VALUES.length; i++) {
                int value = VALUES[i];
                while (num >= value) {
                    res.append(SYMBOLS[i]);
                    num -= value;
                }
            }

            return res.toString();
        }
    }
}