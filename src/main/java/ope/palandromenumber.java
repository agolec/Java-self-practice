package ope;

public class palandromenumber {
    public static void main(String[] args){
        Solution hi = new Solution();

        System.out.println(String.valueOf(hi.isPalindrome(121)) + " " + 121);
        System.out.println(String.valueOf(hi.isPalindrome(-121)) + " " + -121);
        System.out.println(String.valueOf(hi.isPalindrome(10)) + " " + 10);
        System.out.println(String.valueOf(hi.isPalindrome(1221)) + " " + 1221);
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        String numberString = String.valueOf(x);

        int start = 0;
        int end = numberString.length() - 1;

        while(start <= end){
            if(numberString.charAt(start) != numberString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/*

Go to last digit and check if the number found matches the first index.
    If the last digit does not match, return false immediately.

Move the pointer on the last digit back one, and a pointer at the first index up one.
    If these numbers do not match, return false again.

    If pointers are less than or equal to same and the values are the same at those pointers, return true for the entire function.

*/