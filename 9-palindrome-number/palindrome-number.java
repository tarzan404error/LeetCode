class Solution {
    public boolean isPalindrome(int x) {
        int org=x;
        int rev=0;

        while(x>0){

            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;

        }

        if(org==rev){
            return true;
        }
        else{
            return false; 
        }
    }
}