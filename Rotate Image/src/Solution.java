class Solution {
    public void rotate(int[][] matrix) {
		if(null == matrix || matrix.length == 0)
		{
			return;
		}
		
        for(int i = 0; i < matrix.length / 2; i++)
        {
        	moveFollowCircle(matrix, i, matrix.length - i - 1);
        }
    }
	
	void moveFollowCircle(int[][] nums, int columnBegin, int columnEnd)
	{
		if(columnBegin >= columnEnd)
		{
			return;
		}
		
		int columnLength = columnEnd - columnBegin;
		for(int i = 0; i < columnLength; i++)
		{
			int swap = nums[columnBegin][i + columnBegin];
			//the edge of the matrix is 4.
			int nowRow = columnBegin;
			int nowColumn = i + columnBegin;
			int begin = 0;
			int temp = 0;
			int end = 0;
			for(int j = 1; j <= 4; j++)
			{
				
				switch (j) {
				case 1:
					begin = columnLength - columnEnd + nowColumn + nowRow;
					temp = nums[begin][columnEnd];
					nums[begin][columnEnd] = swap;
					swap = temp;
					nowRow = begin;
					nowColumn = columnEnd;
					break;
				case 2:
					end = 2 * columnEnd - nowRow - columnLength;
					temp = nums[columnEnd][end];
					nums[columnEnd][end] = swap;
					swap = temp;
					nowRow = columnEnd;
					nowColumn = end;
					break;
				case 3:
					begin = nowRow - columnLength + (nowColumn - columnBegin);
					end = columnBegin;
					temp = nums[begin][end];
					nums[begin][end] = swap;
					swap = temp;
					nowRow = begin;
					nowColumn = end;
					break;
				case 4:
					end = columnBegin + columnLength - (nowRow - columnBegin);
					begin = columnBegin;
					temp = nums[begin][end];
					nums[begin][end] = swap;
					swap = temp;
					nowRow = begin;
					nowColumn = end;
					break;
				default:
					break;
				}
			}
		}
	}
}