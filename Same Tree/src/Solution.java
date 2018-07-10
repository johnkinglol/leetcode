class TreeNode 
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
        	return true;
        }
        if(p == null || q == null)
        {
        	return false;
        }
        
        String pString = midSearch(p);
        String qString = midSearch(q);
        
        return pString.equals(qString);
    }
    
    public static String midSearch(TreeNode p)
	{
		StringBuilder sb = new StringBuilder();
		if(p != null)
		{
			sb.append(p.val);
			sb.append(midSearch(p.left));
			sb.append(midSearch(p.right));
		}
		else
		{
			sb.append("null");
		}
		
		return sb.toString();
	}
    
    public static void main(String[] args) {
    	TreeNode treeNode1 = new TreeNode(1);
    	TreeNode treeNode2 = new TreeNode(2);
    	
    	TreeNode treeNode3 = new TreeNode(1);
    	TreeNode treeNode4 = new TreeNode(2);
    	
    	treeNode1.left = treeNode2;
    	treeNode3.right = treeNode4;
    	System.out.println(midSearch(treeNode1));
    	System.out.println(midSearch(treeNode3));
	}
}