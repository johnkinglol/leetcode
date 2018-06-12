
public class Solution {

	public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
    	int maxSum = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(sum < 0 && sum < nums[i])
    		{
    			sum = nums[i];
    		}
    		else
    		{
    			sum += nums[i];
    		}
    		
    		if(sum > maxSum)
    		{
    			maxSum = sum;
    		}
    	}
    	
    	return maxSum;
    }
}
