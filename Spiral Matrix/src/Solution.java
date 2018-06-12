import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
        if(null == matrix || matrix.length == 0)
        {
        	return result;
        }
        
        int nowRow = 0;
        int nowColumn = 0;
        int initRow = 0;
        int initColumn = 0;
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;
        
        while(initRow <= endRow && initColumn <= endColumn)
        {
        	//add the initial value
        	result.add(matrix[nowRow][nowColumn]);
        	
        	int rowStep = endColumn - initColumn;
        	int columnStep = endRow - initRow;
        	//move right
    		for(int i = 0; i < rowStep; i++)
        	{
        		nowColumn++;
        		result.add(matrix[nowRow][nowColumn]);
        	}
        	
    		//move down
        	for(int i = 0; i < columnStep; i++)
        	{
        		nowRow++;
        		result.add(matrix[nowRow][nowColumn]);
        	}
        	
        	//move left when data is not in the same row.
        	if(initRow < endRow)
        	{
        		for(int i = 0; i < rowStep; i++)
            	{
            		nowColumn--;
            		result.add(matrix[nowRow][nowColumn]);
            	}
        	}
        	
        	//move up when data is not in the same column.
        	if(initColumn < endColumn)
        	{
            	for(int i = 0; i < columnStep - 1; i++)
            	{
            		nowRow--;
            		result.add(matrix[nowRow][nowColumn]);
            	}
        	}
        	
        	nowRow = ++initRow;
        	nowColumn = ++initColumn;
        	endColumn--;
        	endRow--;
        }
        
        return result;
    }
}
