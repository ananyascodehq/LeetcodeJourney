class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;
        int temp = x;
        int dup = 0;
        while(temp!=0){
            int y = temp % 10;
            temp = temp/10;
            dup = (dup * 10) + y;
        }

        return (dup == x);
    }
}