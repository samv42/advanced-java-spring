package platform.codingnomads.co.javaLogicPuzzles;

    public class IsPalindromeAble {

        private static boolean isPalindromeAble(String word) {

            // Implement your solution here
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
            int index = 0;
            word.toLowerCase();
            int[] numChar;
            int odd = 0;

            if(word.length() > alphabet.length()){
                numChar = new int[word.length()];
            }else{
                numChar = new int[alphabet.length()];
            }

            for(int x = 0; x <alphabet.length(); x++) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == alphabet.charAt(x)) {
                        count++;
                    }
                }
                numChar[index] = count;
                index++;
            }
            for(int y = 0; y < numChar.length; y++){
                if(numChar[y] % 2 > 0){
                    odd++;
                }
            }
            if(odd % 2 > 0){
                return false;
            } else{
                return true;
            }
            // Don't forget to remove the Exception
            //throw new RuntimeException("Not implemented");
        }

        public static void main(String[] args) {
            // Positive cases
            test("", true);
            test("a", true);
            test("aa", true);
            test("aba", true);
            test("abba", true);

            test("abab", true);
            test("abfab", true);
            test("aabbccddf", true);
            test("aabbccddff", true);

            // Negative cases
            test("abcd", false);
            test("aba ", false);

            test("aabbcd", false);
            test("abcd", false);
        }

        private static void test(String str, boolean expected) {
            try {
                boolean actual = isPalindromeAble(str);
                System.out.printf("Test: '%s' expected: %s actual: %s ", str, expected, actual);
                if (actual == expected) {
                    System.out.println(" - pass");
                } else {
                    System.out.println(" - fail");
                }
            } catch (Exception e) {
                System.out.printf("Test: '%s' expected: %s actual: %s - fail with exception\n", str, expected, e.getLocalizedMessage());
            }
        }
    }

