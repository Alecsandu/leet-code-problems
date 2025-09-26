void main() {

    Solver solver = new Solver();

    IO.println("s = \"PAYPALISHIRING\", numRows = 3 result is \"PAHNAPLSIIGYIR\", calculated was: " + solver.convert("PAYPALISHIRING", 3));
    IO.println("s = \"PAYPALISHIRING\", numRows = 4 result is \"PINALSIGYAHRPI\", calculated was: " + solver.convert("PAYPALISHIRING", 4));

}

private static class Solver {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        Vector<ArrayList<Character>> rows = new Vector<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(i, new ArrayList<>());
        }

        int idx = 0, d = 1;
        for (Character ch : s.toCharArray()) {
            rows.get(idx).add(ch);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder sb = new StringBuilder();
        for (var row : rows) {
            for (var el : row) {
                sb.append(el);
            }
        }

        return sb.toString();
    }
}