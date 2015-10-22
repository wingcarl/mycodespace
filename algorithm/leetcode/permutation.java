public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list0 = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            list0.add(nums[i]);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(list0);
        for(int i=0; i<factorial(nums.length)-1; i++){
            ret.add(nextPermutation(nums));
        }
        return ret;
    }
    private List<Integer> nextPermutation(int[] nums){
        int len = nums.length;
        int i = 0;
        for(i=len-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        if(i != -1){
            int k = len - 1;
            for(;k>i;k--){
                if(nums[k] > nums[i]){
                    swap(nums,k,i);
                    break;
                }
            }
        }
        for(int a=len-1,b=i+1;a>b;a--,b++){
            swap(nums,a,b);
        }
        List<Integer> tmp = new ArrayList<Integer>();
        for(i=0;i<nums.length;i++){
            tmp.add(nums[i]);
        }
        return tmp;
    }
    private int factorial(int n){
        return n==1||n==0 ?1:n*factorial(n-1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}