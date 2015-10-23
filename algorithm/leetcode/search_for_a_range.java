//search for a range
/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return dfs(nums, 0, nums.length, target);
    }
    public int[] dfs(int[] nums, int i, int j, int target){
        if(i==j){
            int[] ret = {-1,-1};
            return ret;
        }
        int k = (i+j)/2;
        if(nums[k] > target){
            return dfs(nums,i,k,target);
        }else if(nums[k] < target){
            return dfs(nums,k+1,j)
        }else{
            int[] ret = {k,k};
            int left = dfs(nums,i,k,target)[0];
            int right = dfs(nums,k+1,j,target)[1];
            if(left != -1)   ret[0] = left;
            if(right != -1) ret[1] = right;
            return ret;
        }
    }
}
