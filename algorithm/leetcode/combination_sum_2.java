/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
NO Duplicate
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates,target,0);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target,int start) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for(int i=start;i<candidates.length;i++){
            if( i!=start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] < target){
                for(List<Integer> ar : combinationSum(candidates,target-candidates[i],i)){
                    ar.add(0,candidates[i]);
                    ret.add(ar);
                }
            }else if(candidates[i] == target){
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                ret.add(lst);
            }else{
                break;
            }
        }
        return ret;
    }
}