package string;

public class Strings {
    public static void main(String[] args) {
        Strings str = new Strings();
        String sample = "DaD";
        boolean isPalindrome = str.isPalindrome(sample);
        System.out.println(str);
        System.out.println("isPalindrome" + isPalindrome);
    }
    /*
    Q. Given String, check if the string is palindrome(when read from start to and and end to start are equal) or not
    Example: String "madam"
    Output: true
    Example: String "that"
    Output: false

     */
    public boolean isPalindrome(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while (start<end){
            if (chars[start]!= chars[end]){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }

}
