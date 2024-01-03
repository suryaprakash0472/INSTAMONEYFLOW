public int search(String text, String pattern) {
    int[] badChar = new int[pattern.length()];
    badChar(pattern, badChar);

    int s = 0;
    int p = 0;
    while (s <= text.length() - pattern.length()) {
        if (text.charAt(s + p) == pattern.charAt(p)) {
            if (p == pattern.length() - 1) {
                return s;
            }
            p++;
        } else {
            if (p == 0) {
                s++;
            } else {
                s += p - badChar[p - 1];
                p = badChar[p - 1];
            }
        }
    }
    return -1;
}