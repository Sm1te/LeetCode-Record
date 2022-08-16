class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        int len = strings.length;
        for (int i = len - 1; i >= 0; i--) {
            if (!strings[i].trim().equals("")) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(strings[i]);
            }
        }

        return stringBuilder.toString();
    }
}