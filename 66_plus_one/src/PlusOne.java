// https://leetcode.com/problems/plus-one/description/
void main() {
    Solver solver = new Solver();
    IO.println(Arrays.toString(solver.plusOne(new int[]{1, 9, 9, 9, 9})));
}

private static class Solver {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int first = digits[n - 1] + 1;
        int carry = first / 10;
        digits[n - 1] = first % 10;

        for (int i = n - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry == 0)
            return digits;

        int[] newDigits = new int[n + 1];
        newDigits[0] = carry;
        System.arraycopy(digits, 0, newDigits, 1, n);
            /* Works well
            for (int i = 1; i < n + 1; i++) {
                newDigits[i] = digits[i - 1];
            }
            */
        return newDigits;
    }
}
