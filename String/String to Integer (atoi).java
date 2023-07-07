class Solution {
    public int myAtoi(String s) {
        int sign = 1, i = 0, result = 0, n = s.length();
        if (s == null || s.length() == 0)
            return 0;
        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + s.charAt(i) - '0';
            i++;
        }

        return (sign * result);
    }
}