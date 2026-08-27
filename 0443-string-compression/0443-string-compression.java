class Solution {
    public int compress(char[] chars) {

        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < chars.length) {

            char currentChar = chars[readIndex];
            int count = 0;

            // Count duplicate character
            while (readIndex < chars.length &&
                   currentChar == chars[readIndex]) {
                readIndex++;
                count++;
            }

            // Insert current character
            // and make it available
            chars[writeIndex] = currentChar;
            writeIndex++;

            // Insert the count
            if (count > 1) {

                String countStr = String.valueOf(count);

                for (char digit : countStr.toCharArray()) {
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
        }

        return writeIndex;
    }
}