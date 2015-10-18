/**
*  Input: numbers={2, 7, 11, 15}, target=9
*  Output: index1=1, index2=2
*/
public class Solution {
    //方法一
    //使用哈希 O(n)
    public int[] twoSum(int[] numbers, int target) {
		int[] r = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<numbers.length;i++){
			if(!map.contains(numbers[i])){
				map.put(target-numbers[i],i+1);
			}else{
				int k = map.get(numbers[i]);
				r[0] = k;
				r[1] = i+1;
				break;
			}
		}
		return r;
	}
}