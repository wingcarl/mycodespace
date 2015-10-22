/**
 * 字典序的求法：
 * 从后往前找到第一个递减序列，记录该位置
 * 从后向该记录的位置，找到第一个比该记录位置值大的值的位置，交换两个元素。
 * (此时i向后一定为递减序列)
 * 从该位置到最后的值按照逆序排列；
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length - 1;
        int i = 0;
        for(i = len-1;i>=0;i--){
            if(nums[i] < nums[i+1])
                break;
        }
        if(i!=-1){
            int k = len;
            for(; k > i ; k--){
                if(nums[k] > nums[i]){
                    swap(nums,i,k);
                    break;
                }
            }
        }
        for(int a = i+1,b=len;a<b;a++,b--){
            swap(nums,a,b);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}