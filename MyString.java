public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        // Case: Input Error.
        if (str == null) {
            return null;
        } 
        // Case: Empty String.
        if (str == "") {
            return "";
        }
        String lowerString = "";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            // Example: 'K' in 75, 'k' in 107.
            if (currentChar >= 'A' && currentChar <= 'Z') {
                lowerString += (char) (currentChar+32);
            } else {
                lowerString += currentChar;
            }
        }
        return lowerString;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // Case: Input Error.
        if (str1 == null || str2 == null) {
            return false;
        } 
        // Case: Empty String.
        if (str2 == "") {
            return true;
        }
        // Case: Str1 cannot contain Str2 as it's smaller.
        if (str2.length() > str1.length()) {
            return false;
        }
        // Logic: More comfortable dealing with lower cases.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // Logic: More comfortable dealing without spaces.
        str1 = removeSpaces(str1);
        str2 = removeSpaces(str2);
        // Logic: Prevent Exceedance.
        int iterateLimit = str1.length() - str2.length();
        for (int i = 0; i <= iterateLimit; i++) {
            String subString = str1.substring(i, i+str2.length());
            if(subString.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    // Logic: Function to remove spaces at string.
    public static String removeSpaces(String strInput) {
        String newString = "";
        for(int i = 0; i < strInput.length(); i++) {
            char currentChar = strInput.charAt(i);
            if (currentChar != ' ') {
                newString += currentChar;
            }
        }
        return newString;
    }
}