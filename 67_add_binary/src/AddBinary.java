void main() {
    Solver solver = new Solver();
    IO.println(solver.addBinary("11", "1"));
    IO.println(solver.addBinaryOld("11", "1"));
}

static class Solver {

    public String addBinaryOld(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(j))) + carry;
            carry = sum >= 2 ? 1 : 0;
            sum %= 2;
            res.append(sum);
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + carry;
            carry = sum >= 2 ? 1 : 0;
            sum %= 2;
            res.append(sum);
            i--;
        }

        if (carry == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            res.append(carry % 2);
            carry /= 2;
        }
        return res.reverse().toString();
    }
}