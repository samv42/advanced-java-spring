package platform.codingnomads.co.javaLogicPuzzles;

public class IsPalindromable {

        private static boolean isPalindrome(String word) {

            // Implement your solution here
            String reverse = "";
            for(int i = 0; i < word.length(); i++){
                reverse += word.charAt(word.length() - i -1);
            }
            if(word.equals(reverse)){
                return true;
            }else{
                return false;
            }
            // Don't forget to remove the Exception
           // throw new RuntimeException("Not implemented");
        }

        public static void main(String[] args) {
            // Positive cases
            test("", true);
            test("a", true);
            test("aa", true);
            test("aba", true);
            test("abba", true);

            // Negative cases
            test("abcd", false);
            test("aba ", false);
        }

        private static void test(String str, boolean expected) {
            try {
                boolean actual = isPalindrome(str);
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
