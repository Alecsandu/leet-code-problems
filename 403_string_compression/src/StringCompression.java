void main() {
    char[] input1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    IO.println("Input1 res : " + compress(input1));
}

// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
public static int compress(char[] chars) {
    int newCharsPos = 0;
    int n = chars.length;

    for (int i = 0; i < n; i++) {
        char ch = chars[i];
        int count = 0;
        while (i < n && ch == chars[i]) {
            count++;
            i++;
        }

        chars[newCharsPos++] = ch;
        if (count > 1) {
            for (char numCh : Integer.valueOf(count).toString().toCharArray()) {
                chars[newCharsPos++] = numCh;
            }
        }
        i--;
    }

    return newCharsPos;
}