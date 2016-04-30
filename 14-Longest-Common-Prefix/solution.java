public class Solution {
    public static String longestCommonPrefix(String[] strs)
	{
		if (strs.length==1) return strs[0];
		
		int minPrefix=Integer.MAX_VALUE;
		String Prefix="";
		
		for(int i=1;i<strs.length;i++)
		{	
			int maxPrefix=0;
			int m=strs[i-1].length(),n=strs[i].length();
			for(int j=0;j<Math.min(Math.min(m,n),minPrefix);j++)
			{
				if (strs[i-1].charAt(j) == strs[i].charAt(j)) maxPrefix++;
				else	break;
			}
			if (maxPrefix < minPrefix)
			{
				minPrefix=maxPrefix;
				Prefix=strs[i-1].substring(0, maxPrefix);
			}
		}
		return Prefix;
	}
}