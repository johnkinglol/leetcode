import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, String> strMap = new HashMap<String, String>();
        int emptyCount = 0;
        for(String string : strs)
        {
        	if(string.isEmpty())
        	{
        		emptyCount++;
        		strMap.put("empty", emptyCount + "");
        		continue;
        	}
        	String sortedStr = sort(string);
        	if(strMap.containsKey(sortedStr))
        	{
        		String value = strMap.get(sortedStr);
        		strMap.put(sortedStr, value + "," + string);
        	}
        	else
        	{
        		strMap.put(sortedStr, string);
        	}
        }
        
        for(Entry<String, String> entry : strMap.entrySet())
        {
        	if(entry.getKey().equals("empty"))
        	{
        		int count = Integer.parseInt(entry.getValue());
        		List<String> emptyList = new ArrayList<String>();
        		for(int i = 0; i < count; i++)
        		{
        			emptyList.add("");
        		}
        		result.add(emptyList);
        		continue;
        	}
        	String value = entry.getValue();
        	result.add(Arrays.asList(value.split(",")));
        }
        
        return result;
    }
	
	public String sort(String data)
	{
		char[] dataArray = data.toCharArray();
		Arrays.sort(dataArray);
		
		return new String(dataArray);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] data = {"", ""};
		List<List<String>> result = solution.groupAnagrams(data);
	}
}
