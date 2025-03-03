package codility;

import java.util.Arrays;
/*

    Prepare a notification of the given message which will be displayed on a mobile device. The message is made of words separated by single spaces. The length of the notification is limited to K characters. If the message is too long to be displayed fully, some words from the end of the message should be cropped, keeping in mind that:
    • the notification should be as long as possible;
    • only whole words can be cropped;
    • if any words are cropped, the notification should end with "..."; the dots should be separated from the last word by a single space;
    • the notification may not exceed the K-character limit, including the dots.
    If all the words need to be cropped, the notification is"..." (three dots without a space).
    For example, for message = "And now here is my secret" and K = 15, the notification is "And now ...". 
    Note that:
    • the notification "And ..." would be incorrect, because there is a longer correct notification;
    • the notification "And now her ..." would be incorrect, because the original message is cropped through the middle of a word;
    • the notification "And now ... "would be incorrect, because it ends with a space;
    • the notification "And now here..." would be incorrect, because there is no space before the three dots;
    • the notification "And now here ..." would be incorrect, because it exceeds the 15-character limit.
    Write a function:
    function solution(message, K);
    that, given a string message and an integer K, returns the notification to display, which has no more than K characters, as described above.
    Examples:
    1. For message = "And now here is my secret" and K = 15, the function should return "And now ...", as explained above.
    2. For message = "There is an animal with four legs" and K = 15, the function should return "There is an ...".
    3. For message = "super dog" and K = 4, the function should return "...".
    4. For message = "how are you" and K = 20, the function should return "how are you".
    Assume that:
    • K is an integer within the range [3..500]:
    • the length of string message is within the range [1..500];
    • string message is made of English letters ('a'-'z', 'A-Z') and spaces (* *);
    • message does not contain spaces at the beginning or at the end;
    • words are separated by a single space (there are never two or more consecutive spaces).
 */
class MessagingNotification {
    public String solution(String msg,int k){
        if (msg.length()<= k) {
          return msg;  
        }
        String[] wordArray = msg.split(" ");
        int length = wordArray.length;
        int[] prefixSum = new int[length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + wordArray[i].length();
            if (i > 0) {
                prefixSum[i + 1] += 1;
            }
        }
        for (int i = length; i >= 1; i--) {
            int currentLength = prefixSum[i] + 4;
            if (currentLength <= k) {
                String result = String.join(" ", Arrays.copyOfRange(wordArray, 0, i)) + " ...";
                return result;
            }
        }
        return "...";
    }
    public static void main(String[] args) {
        MessagingNotification msg = new MessagingNotification();
        System.out.println(msg.solution("Hello", 5));
    }
}
