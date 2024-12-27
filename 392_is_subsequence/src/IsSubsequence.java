public class IsSubsequence
{

    public static void main(String[] args) {
        System.out.println(isSubsequence("ade", "abcde"));
    }

    // https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.isEmpty())
            return true;
        if (t.isEmpty())
            return false;

        int posWordS = 0, posWordT = 0, sizeOfS = s.length(), sizeOfT = t.length();
        while (posWordT < sizeOfT) {
            if (t.charAt(posWordT) == s.charAt(posWordS)) {
                posWordS++;
                if (posWordS == sizeOfS) return true;
            }
            posWordT++;
        }
        return false;
    }
}
