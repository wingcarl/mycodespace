//Search Insert Position
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = dfs(nums,0,nums.length,target);
        return i;
    }
    int dfs(int[] nums,int i,int j,int target){
        if(i==j){
           return i;
                
        }
        int mid = (i+j)/2;
        if(nums[mid] > target){
            return dfs(nums,i,mid,target);
        }
        else if(nums[mid] < target){
            return dfs(nums,mid+1,j,target);
        }else {
            return mid;
        }
    }
}