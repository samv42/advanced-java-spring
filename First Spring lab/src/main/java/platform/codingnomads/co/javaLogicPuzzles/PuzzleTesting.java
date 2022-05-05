package platform.codingnomads.co.javaLogicPuzzles;

public class PuzzleTesting {
    public static void main(String[] args) {
        IsPalindrome testWord = new IsPalindrome();
        System.out.println(testWord.isSortedPalindrome("aaagaaa"));
        System.out.println(testWord.isSortedPalindrome("aaagaaae"));
        System.out.println("");
        System.out.println(testWord.isUnsortedPalindrome("aarrrr"));
        System.out.println(testWord.isUnsortedPalindrome("eeerrreeeeu"));
    }
}
