package platform.codingnomads.co.javaLogicPuzzles;

public class IsPalindrome {
    public boolean isSortedPalindrome(String word){
        String reverse = "";
        for(int i = 0; i < word.length(); i++){
            reverse += word.charAt(word.length() - i -1);
        }
        if(word.equals(reverse)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isUnsortedPalindrome(String word){
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
    }
}
