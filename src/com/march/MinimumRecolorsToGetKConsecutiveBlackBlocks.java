class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        int n = blocks.length();
        int res = Integer.MAX_VALUE;
        int count =0;
        while(right < n){
            if(right-k >=0){
                if(blocks.charAt(right-k)=='B')count--;
            }
            while(right < n && right-left+1 < k){
                if(blocks.charAt(right)=='B')count++;
                right++;
            }
            res = Math.min(res, k-count);
            left++;
        }
        return res;
    }
}
