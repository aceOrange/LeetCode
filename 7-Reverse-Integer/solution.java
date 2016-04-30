public class Solution {
    public static int reverse(int x)
	{
		int start=0, sign=1, val=0;
		String str = Integer.toString(x);
		if (str.charAt(0)=='-')
		{
			start=1;
			sign=-1;
		}
		
		for(int i=1; i<=str.length()-start; i++)
		{
			if (val > Integer.MAX_VALUE/10 && i <= str.length()-start) return 0;
			val =val*10 + Character.getNumericValue(str.charAt(str.length()-i));
		}
		return val*sign;
	}
}