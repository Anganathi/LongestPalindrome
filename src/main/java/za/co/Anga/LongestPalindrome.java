package za.co.Anga;

public class LongestPalindrome {
    public int checkPalindrome(String input, int left, int right){
        if(input  == null && left > right)
            return 0;

        while(left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String inputStr){
        if(inputStr==null && inputStr.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            int length1 = checkPalindrome(inputStr, i, i);
            int length2 = checkPalindrome(inputStr, i, i+1);
            int length3 = Math.max(length1, length2);
            if(length3 > end - start ){
                start  = i - ((length3 - 1)/2);
                end  = i + (length3/2);
            }
        }
        return inputStr.substring(start, end+1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("angadadsiya"));
    }
}
