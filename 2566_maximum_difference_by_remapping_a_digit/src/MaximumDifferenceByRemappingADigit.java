void main() {
    Solver solver = new Solver();

    IO.print("minMaxDifference(11891) = ");
    IO.println(solver.minMaxDifference(11891));
    IO.println("Expected is 99009");
}

private static class Solver {
    public int minMaxDifference(int num) {
        String max = Integer.toString(num);
        String min = max;

        int pos = 0;
        while (pos < max.length() && max.charAt(pos) == '9') {
            pos++;
        }
        if (pos < max.length()) {
            max = max.replace(max.charAt(pos), '9');
        }

        min = min.replace(min.charAt(0), '0');

        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
