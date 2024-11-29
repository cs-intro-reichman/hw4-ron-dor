public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        int sentencesLength = sentences.length;
        int keywordsLength = keywords.length;
        for (int i = 0; i < sentencesLength; i++) {
            String currentSentence = sentences[i];
            for (int j = 0; j < keywordsLength; j++) {
                String currentKeyWord = keywords[j];
                boolean keyAtSentence = contains(currentSentence, currentKeyWord);
                if (keyAtSentence) {
                    System.out.println(currentSentence);
                    break;
                }
            }
        }
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // Case: Input Error.
        if (str1 == null || str2 == null) {
            return false;
        } 
        // Case: Empty String.
        if (str2.equals("")) {
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
        // str1 = removeSpaces(str1);
        // str2 = removeSpaces(str2);
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
}
